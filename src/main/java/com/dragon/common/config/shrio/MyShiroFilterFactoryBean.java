package com.dragon.common.config.shrio;

import com.dragon.dao.MenuDAO;
import com.dragon.dao.RoleMenuDAO;
import com.dragon.mapper.MenuMapper;
import com.dragon.model.entity.Menu;
import com.dragon.model.entity.RoleMenu;
import com.google.common.collect.Maps;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:22
 */
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroFilterFactoryBean.class);

    public static final String ROLE_STRING = "roles[{0}]";
    private static String filterChainDefinitions;


    private MenuMapper menuDAO;

    public void setMenuDAO(MenuMapper menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public void setFilterChainDefinitions(String definitions) {
        filterChainDefinitions = definitions;
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }

        List<Menu> menus = menuDAO.getAllMenu();
        List<RoleMenu> roleMenus = menuDAO.queryByMenuIds(menus);
        Map<Long, String> roleMenusMap = Maps.newConcurrentMap();
        //menu作为key,拼接String类型roleIds
        roleMenus.forEach(roleMenu -> {
            if (roleMenusMap.containsKey(roleMenu.getMenuId())) {
                StringBuilder roleIds = new StringBuilder(roleMenusMap.get(roleMenu.getMenuId()));
                roleIds.append(roleMenu.getRoleId()).append(",");
                roleMenusMap.put(roleMenu.getMenuId(), roleIds.toString());
            } else {
                roleMenusMap.put(roleMenu.getMenuId(), roleMenu.getRoleId() + ",");
            }
        });

        for (Menu menu : menus) {
            if (StringUtils.hasText(menu.getMenuUrl())) {
                String roleIds = roleMenusMap.get(menu.getId());
                if (null != roleIds) {
                    String str = roleIds.substring(0, roleIds.length() - 1);
                    section.put(menu.getMenuUrl(), MessageFormat.format(ROLE_STRING, str));
                }
            }
        }
        section.put("/**", "authc");
        this.setFilterChainDefinitionMap(section);
    }

    public synchronized void update() {
        try {
            AbstractShiroFilter shiroFilter = (AbstractShiroFilter) this.getObject();
            PathMatchingFilterChainResolver resolver = (PathMatchingFilterChainResolver) shiroFilter
                    .getFilterChainResolver();
            // 过滤管理器
            DefaultFilterChainManager manager = (DefaultFilterChainManager) resolver.getFilterChainManager();
            // 清除权限配置
            manager.getFilterChains().clear();
            this.getFilterChainDefinitionMap().clear();

            // 重新设置权限
            this.setFilterChainDefinitions(filterChainDefinitions);

            Map<String, String> chains = this.getFilterChainDefinitionMap();
            if (!CollectionUtils.isEmpty(chains)) {
                Iterator var12 = chains.entrySet().iterator();

                while (var12.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry) var12.next();
                    String url = (String) entry.getKey();
                    String chainDefinition = (String) entry.getValue();
                    manager.createChain(url, chainDefinition);
                }
            }
        } catch (Exception e) {
            LOGGER.error("shiro 更新权限失败！！{}", e);
        }
    }
}
