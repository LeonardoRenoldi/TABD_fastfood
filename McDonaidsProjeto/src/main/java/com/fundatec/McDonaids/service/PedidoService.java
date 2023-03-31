package com.fundatec.McDonaids.service;

import com.fundatec.McDonaids.model.pedidoModel;
import com.fundatec.McDonaids.repository.pedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
   @Autowired
    private pedidoRepository produtoRepository;
   private pedidoModel pedidoModelo;



    public void deletarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }





}
