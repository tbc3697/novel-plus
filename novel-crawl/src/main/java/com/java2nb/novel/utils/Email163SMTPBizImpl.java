package com.java2nb.novel.utils;

import com.java2nb.novel.utils.mail.IEmailBiz;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
public class Email163SMTPBizImpl implements IEmailBiz {

    @SneakyThrows
    @Override
    public boolean sendContext(String to, String subject, String content, boolean isHtml) {
        var contentType = isHtml ? "text/html;charset=UTF-8" : null;
        return sendContext(to, subject, content, contentType);
    }

    public boolean sendContext(String to, String subject, String content, String contentType) throws UnsupportedEncodingException {
        var mailConfig = new Mail163Config();
        try {
            Properties props = mailConfig.getSmtpProperties();
            Session session = createSession(props, mailConfig);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailConfig.getUsername(), "AutoNotify-NoReply", "UTF-8"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            if (contentType == null) {
                // "text/html;charset=UTF-8"
                message.setText(content);
            } else {
                message.setContent(content, contentType);
            }


            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }


    private Session createSession(Properties props, Mail163Config config) {
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getUsername(), config.getAuthCode());
            }
        });
    }

    @Getter
    @RequiredArgsConstructor
    class Mail163Config {
        // SMTP服务器配置
        private static final String SMTP_HOST = "smtp.163.com";
        private static final int SMTP_PORT = 25; // 587或465

        // 认证信息
        private final String username = "tbc521@163.com";
        private final String authCode = "ETaNs6tNDHQHUYm2"; //  = "your_163_auth_code"; // 163授权码，非登录密码

        public Properties getSmtpProperties() {
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.port", String.valueOf(SMTP_PORT));
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            return props;
        }
    }

    public static void main(String[] args) {
        var email = new Email163SMTPBizImpl();
        var result = email.sendContext("312383074@qq.com", "NovelTest", "章节内容已隐藏，请登录后查看", false);
        System.out.println(result);
    }
}
