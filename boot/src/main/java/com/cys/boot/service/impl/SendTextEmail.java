package com.cys.boot.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import com.sun.mail.util.MailSSLSocketFactory;

import com.cys.boot.entity.User;
import com.cys.boot.service.EmailService;
import com.cys.boot.utils.MyAuthenticator;
/**
 *	@description send text email only 
 *	@author cys(ChenYongsheng)
 * 	@date 2022/7/27
 */
@Service
public class SendTextEmail implements EmailService{

	@Override
	public void sendEmail(User user) {
		//
		Properties properties=null;
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("auth.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getDefaultInstance(properties, new MyAuthenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1764940738@qq.com","bqzbyliyocwmfcfh");
            }
        });
 
        session.setDebug(true);
 
        Transport transport = null;
		try {
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
 
        try {
			transport.connect("smtp.qq.com","1764940738@qq.com","bqzbyliyocwmfcfh");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
 
        //�����ʼ�����
        MimeMessage mimeMessage = new MimeMessage(session);
 
        //�ʼ�������
        try {
        mimeMessage.setFrom(new InternetAddress("1764940738@qq.com"));
 
        //�ʼ�������
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(user.geteMail()));
 
        //�ʼ�����
        mimeMessage.setSubject("Boot APP");
 
        //�ʼ�����
        mimeMessage.setContent("注册成功！感谢你对陈永胜的支持💗💗💗","text/html;charset=UTF-8");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        //�����ʼ�
        try {
			transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
 
        //�ر�����
        try {
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
