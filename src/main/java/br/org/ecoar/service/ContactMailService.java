package br.org.ecoar.service;

import br.org.ecoar.controller.ContactForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactMailService {

    private final JavaMailSender mailSender;

    @Value("${ecoar.mail.to}")
    private String destination;

    public ContactMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destination);
        message.setReplyTo(form.getEmail());
        message.setSubject("Novo contato pelo site — Instituto Ecoar");
        message.setText(
            "Nome: " + form.getNome() + "\n" +
            "E-mail: " + form.getEmail() + "\n" +
            "Telefone: " + form.getTelefone() + "\n\n" +
            "Mensagem:\n" + (form.getMensagem() == null ? "" : form.getMensagem())
        );
        mailSender.send(message);
    }
}
