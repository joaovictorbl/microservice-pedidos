package br.com.joaolourenco.processador.entity;


import br.com.joaolourenco.processador.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    private UUID uuid = UUID.randomUUID();
    private String cliente;
    @Column(name = "itens_pedido")
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;
    @Column(name = "valor_total")
    private Double valorTotal;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPedido;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = Status.EM_PROCESSAMENTO;
        this.dataPedido = LocalDateTime.now();
    }
}
