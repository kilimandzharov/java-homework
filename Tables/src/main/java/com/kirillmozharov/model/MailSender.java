package com.kirillmozharov.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/*
 * Добавьте зависимости из указанных ссылок для использования этого класса:
 * https://mvnrepository.com/artifact/javax.mail/javax.mail-api
 * https://mvnrepository.com/artifact/com.sun.mail/javax.mail
 */

/**
 * @author Kotov Kirill
 */
public class MailSender {
    private String from;
    private String password;
    private String to;

    /**
     * Конструктор задает параметры: от кого отправка, пароль, кому
     * 1. Создайте новый аккаунт на почте mail.ru
     * 2. Зайдите в раздел "Пароль и безопасность"
     * 3. Выберите вкладку "Пароли для внешних приложений"
     * 4. Нажмите добавить, введите название java и запишите сгенерированный пароль
     * @param from Ваш аккаунт на mail.ru
     * @param password Ваш сгенерированный пароль для внешних приложений
     * @param to Аккаунт, кому производится отправка
     */
    public MailSender(String from, String password, String to) {
        this.from = from;
        this.password = password;
        this.to = to;
    }

    public void send(String subject, String text) {
        String host = "smtp.mail.ru";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtps.ssl.checkserveridentity", true);
        props.put("mail.smtps.ssl.trust", "*");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
            throw new IllegalArgumentException("Error sending message!");
        }
    }
}
