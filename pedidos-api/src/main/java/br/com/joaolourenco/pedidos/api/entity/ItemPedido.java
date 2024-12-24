package br.com.joaolourenco.pedidos.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemPedido {

    private UUID uuid = UUID.randomUUID();
    private Produto produto;
    private Integer quantidade;

}
