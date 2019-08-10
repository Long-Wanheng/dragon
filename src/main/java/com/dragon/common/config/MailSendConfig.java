package com.dragon.common.config;

import com.dragon.common.exception.DragonException;
import com.dragon.model.entity.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Properties;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 22:18
 */
@Configuration
public class MailSendConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSendConfig.class);
    /**
     * smtp服务器
     */
    @Value("${smtp.server.address}")
    private String smtpServerAddress;
    /**
     * 发件人地址
     */
    @Value("${from.mail.address}")
    private String fromMailAddress;
    /**
     * 用户名
     */
    @Value("${mail.user.name}")
    private String mailUserName;
    /**
     * 163的授权码
     */
    @Value("${mail.authorization.key}")
    private String mailAuthorizationKey;

    //private String[] tos = new String[]{"243027528@qq.com"};

    private static final String MAIL_SMTP_HOST = "mail.smtp.host";

    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    /**
     * 发送邮件
     *
     * @param mail 邮件实体类
     */
    public boolean send(Mail mail) {
        Properties props = new Properties();
        //设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put(MAIL_SMTP_HOST, smtpServerAddress);
        //需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put(MAIL_SMTP_AUTH, "true");
        //用props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        //用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        Transport transport = null;
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(fromMailAddress));
            // 加载收件人地址
            List<String> toMail = mail.getToMail();
            if (null == toMail || toMail.size() <= 0) {
                throw new DragonException("收件人不能为空");
            }
            InternetAddress[] sendTo = new InternetAddress[toMail.size()];
            for (int i = 0; i < toMail.size(); i++) {
                sendTo[i] = new InternetAddress(toMail.get(i));
            }
            message.addRecipients(Message.RecipientType.TO, sendTo);
            //设置在发送给收信人之前给自己（发送方）抄送一份，不然会被当成垃圾邮件，报554错
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(fromMailAddress));
            //加载标题
            message.setSubject(mail.getTitle());
            //向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();
            //设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(mail.getContext());
            multipart.addBodyPart(contentPart);
            //将multipart对象放到message中
            message.setContent(multipart);
            //保存邮件
            message.saveChanges();
            //发送邮件
            transport = session.getTransport("smtp");
            //连接服务器的邮箱
            transport.connect(smtpServerAddress, fromMailAddress, mailAuthorizationKey);
            //把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            LOGGER.info("send mail success title {} to {} ", mail.getTitle(), toMail);
            return true;
        } catch (Exception e) {
            LOGGER.error("邮件发送失败!!", e);
        } finally {
            if (null != transport) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
