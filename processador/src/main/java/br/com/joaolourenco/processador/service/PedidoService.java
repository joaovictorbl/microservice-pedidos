package br.com.joaolourenco.processador.service;

import br.com.joaolourenco.processador.entity.ItemPedido;
import br.com.joaolourenco.processador.entity.Pedido;
import br.com.joaolourenco.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoService itemPedidoService;
    private final Produtoservice produtoservice;

    public PedidoService(PedidoRepository pedidoRepository, ItemPedidoService itemPedidoService, Produtoservice produtoservice) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoService = itemPedidoService;
        this.produtoservice = produtoservice;
    }


    public void salvarPedido(Pedido pedido) {
        //salvando produtos
        produtoservice.save(pedido.getItens());
        //salvando itens
        List<ItemPedido> listItensPedido = itemPedidoService.save(pedido.getItens());

        pedidoRepository.save(pedido);

        itemPedidoService.updateItemPedido(listItensPedido, pedido);
        logger.info("Pedido salvo com sucesso: {}", pedido.toString());
    }
}
