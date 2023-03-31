package com.fundatec.McDonaids.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
public class pedidoModel {

   @Id
    private int numeroDoPedido;

    private String item;

    private int quantidade;

    private double valor;
}
