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
import java.util.Optional;

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
        return new ResponseEntity ("Criado com sucesso !",HttpStatus.CREATED);
    }

    @GetMapping("/pedidos")
    public List<pedidoModel> getAllPedidos() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<pedidoModel> deletarPedido(@PathVariable Integer id) {
         pedidoService.deletarProduto(id);
        return new ResponseEntity("Deletado com sucesso !", HttpStatus.OK);
    }

    @RequestMapping(value = "/atualizar_pedido/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<pedidoModel> Put(@PathVariable(value = "id") Integer id,  @RequestBody pedidoModel newPedido)
    {
        Optional<pedidoModel> pedidoAntigo = repository.findById(id);
        if(pedidoAntigo.isPresent()){
            pedidoModel pedido = pedidoAntigo.get();
            pedido.setQuantidade(newPedido.getQuantidade());
            repository.save(pedido);
            return new ResponseEntity ("Atualizado com Sucesso !", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}



