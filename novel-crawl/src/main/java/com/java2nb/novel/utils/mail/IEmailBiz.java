package com.java2nb.novel.utils.mail;

public interface IEmailBiz {
    boolean sendContext(String to, String subject, String content, boolean isHtml) ;
}
