package com.dragon.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 22:18
 */
@Configuration
public class MailSendConfig {
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
    /**
     * 邮件标题
     */
    private String subject = "手表服务抛异常了";
    private String[] tos = new String[]{"993111960@qq.com"};

    /**
     * 发送邮件
     */
    public void send(String context) {
        Properties props = new Properties();
        //设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", smtpServerAddress);
        //需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");
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
            InternetAddress[] sendTo = new InternetAddress[tos.length];
            for (int i = 0; i < tos.length; i++) {
                sendTo[i] = new InternetAddress(tos[i]);
            }
            message.addRecipients(Message.RecipientType.TO, sendTo);
            //设置在发送给收信人之前给自己（发送方）抄送一份，不然会被当成垃圾邮件，报554错
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(fromMailAddress));
            //加载标题
            message.setSubject(subject);
            //向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();
            //设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(context);
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
