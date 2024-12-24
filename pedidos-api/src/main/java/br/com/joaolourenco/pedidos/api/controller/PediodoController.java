package br.com.joaolourenco.pedidos.api.controller;

import br.com.joaolourenco.pedidos.api.entity.Pedido;
import br.com.joaolourenco.pedidos.api.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pedidos", description = "gestao de pedidos")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PediodoController {

    private final Logger logger = LoggerFactory.getLogger(PediodoController.class);

    private final PedidoService pedidoService;

    public PediodoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(summary = "Cria um novo pedido",
    responses = @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))
    ))
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        logger.info("Criando pedido: {}", pedido.toString());
        pedidoService.enviarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }



}
