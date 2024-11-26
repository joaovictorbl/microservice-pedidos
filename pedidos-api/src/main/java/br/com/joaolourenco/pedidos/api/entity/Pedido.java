package br.com.joaolourenco.pedidos.api.entity;

import br.com.joaolourenco.pedidos.api.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Pedido {

    private UUID uuid = UUID.randomUUID();
    private String cliente;
    private List<ItemPedido> itens;
    private Double valorTotal;
    private String email;
    private Status status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPedido;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = Status.EM_PROCESSAMENTO;
        this.dataPedido = LocalDateTime.now();
    }
}
