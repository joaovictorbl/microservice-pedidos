package br.com.joaolourenco.processador.service;

import br.com.joaolourenco.processador.entity.ItemPedido;
import br.com.joaolourenco.processador.entity.Pedido;
import br.com.joaolourenco.processador.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void updateItemPedido(List<ItemPedido> listItensPedido, Pedido pedido) {
        listItensPedido.forEach(item -> {
            item.setPedido(pedido);
            this.save(item);
        });


    }

    private void save(ItemPedido item) {
        itemPedidoRepository.save(item);
    }
}
