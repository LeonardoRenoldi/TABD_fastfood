package com.fundatec.McDonaids.repository;

import model.pedidoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pedidoRepository extends MongoRepository<pedidoModel, Integer> {



}
