package com.fundatec.McDonaids.repository;


import com.fundatec.McDonaids.model.pedidoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface pedidoRepository extends MongoRepository<pedidoModel, Integer> {

    Optional<pedidoModel> findById(Integer id);

}
