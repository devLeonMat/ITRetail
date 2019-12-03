package com.rleon.clientes.dao;

import com.rleon.clientes.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends MongoRepository<Client, String> {

}
