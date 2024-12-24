package br.com.joaolourenco.processador.service;

import br.com.joaolourenco.processador.entity.ItemPedido;
import br.com.joaolourenco.processador.entity.Produto;
import br.com.joaolourenco.processador.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Produtoservice {

    private final ProdutoRepository produtoRepository;

    public Produtoservice(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void save(List<ItemPedido> itens) {
        itens.forEach(item -> {
            Produto produto = produtoRepository.save(item.getProduto());
        });

    }
}
