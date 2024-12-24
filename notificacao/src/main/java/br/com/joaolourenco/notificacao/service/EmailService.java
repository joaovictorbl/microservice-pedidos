package br.com.joaolourenco.notificacao.service;

import br.com.joaolourenco.notificacao.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmail (Pedido pedido) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("pedido-api@companu.com");
        message.setTo(pedido.getEmail());
        message.setSubject("Pedido realizado com sucesso!");
        message.setText(gerarMensagem(pedido));
        javaMailSender.send(message);
    }

    private String gerarMensagem(Pedido pedido) {
        return "Pedido realizado com sucesso! \n" +
                "Status do pedido: " + pedido.getStatus() + "\n" +
                "Código do pedido: " + pedido.getUuid() + "\n" +
                "Data do pedido: " + pedido.getDataPedido() + "\n" +
                "Valor total: " + pedido.getValorTotal();
    }
}
