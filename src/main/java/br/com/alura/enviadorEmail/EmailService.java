package br.com.alura.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
	
	private static final String PASSWORD = "jose26011993";
	private static final String JOSECARLOSBUSS_GMAIL_COM = "josecarlosbuss@gmail.com";

	public void enviar(String nome, String emailConvidado){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(JOSECARLOSBUSS_GMAIL_COM, PASSWORD));
            email.setSSLOnConnect(true);

            email.setFrom(JOSECARLOSBUSS_GMAIL_COM);
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {  
            e.printStackTrace();
        }
    }
}