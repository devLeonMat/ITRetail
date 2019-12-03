package com.rleon.clientes.service;

import com.rleon.clientes.model.Client;
import com.rleon.clientes.model.Kpi;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {

    public Client createNewCliente(Client user) throws Exception;
    public List<Client> findAll() ;
    public Kpi getKpi() throws Exception;

}
