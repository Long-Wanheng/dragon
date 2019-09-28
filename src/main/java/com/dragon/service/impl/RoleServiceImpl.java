package com.dragon.service.impl;

import com.dragon.common.exception.DragonException;
import com.dragon.common.utils.UserUtils;
import com.dragon.dao.RoleDAO;
import com.dragon.model.entity.Role;
import com.dragon.model.entity.User;
import com.dragon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 22:32
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public int addRole(Role role) {
        checkAddRole(role);
        return roleDAO.addRole(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDAO.getAllRole();
    }

    @Override
    public int updateRole(Role role) {
        if (null == role) {
            throw new DragonException("参数不能为空");
        }
        if (role.getId() == null || role.getId() <= 0) {
            throw new DragonException("非法id");
        }
        return roleDAO.updateRole(role);
    }

    @Override
    public int logicDelete(Long id) {
        if (null == id || id.intValue() <= 0) {
            throw new DragonException("id非法");
        }
        return roleDAO.logicDelete(id);
    }

    private void checkAddRole(Role role) {
        if (null == role) {
            throw new DragonException("参数不能为空");
        }
        if (null == role.getRoleName()) {
            throw new DragonException("角色名不能为空");
        }
        User user = UserUtils.getCurrentUser().get();
        role.setCreateUser(user.getRealName() + "(" + user.getNickName() + ")");
    }
}
