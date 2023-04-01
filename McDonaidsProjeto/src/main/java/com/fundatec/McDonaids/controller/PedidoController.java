package com.fundatec.McDonaids.controller;


import com.fundatec.McDonaids.exceptionHandler.Response;
import com.fundatec.McDonaids.model.pedidoModel;
import com.fundatec.McDonaids.repository.pedidoRepository;

import com.fundatec.McDonaids.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Validated
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private pedidoRepository repository;
    @Autowired
    private PedidoService pedidoService;


    public PedidoController(pedidoRepository pedidoRepository){
        this.repository = pedidoRepository;
    }

    @GetMapping("getpedido/{id}")
  public pedidoModel getProdutoById(@PathVariable("Id")Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping(value="/post")
    public ResponseEntity<pedidoModel> createPedido(@RequestBody pedidoModel pedido) {
        this.repository.save(pedido);
        return new ResponseEntity<pedidoModel>(HttpStatus.CREATED);
    }

    @GetMapping("/pedidos")
    public List<pedidoModel> getAllPedidos() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Integer id) {
         pedidoService.deletarProduto(id);
        return new ResponseEntity(new Error("Deletado com sucesso!"), HttpStatus.GONE);
    }





}



