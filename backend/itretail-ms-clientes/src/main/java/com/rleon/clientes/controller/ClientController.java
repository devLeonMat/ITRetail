package com.rleon.clientes.controller;


import com.rleon.clientes.model.Client;
import com.rleon.clientes.model.Kpi;
import com.rleon.clientes.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequestMapping("/client")
@Api(value = "Endpoint de usuario", consumes = "endPoint de creacion y reporte de clientes")
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ClientService clientServ;

    public ClientController(ClientService clientServ) {
        this.clientServ = clientServ;
    }

    @GetMapping(value = "/status")
    String checkStatus() {
        return "ok";
    }

    @PostMapping(value = "/creacliente")
    @ApiOperation(value = "Creacion de nuevo Cliente", notes = "Crea un nuevo cliente")
    public ResponseEntity<Client> createQualification(@Valid @RequestBody Client client) throws Exception {

        logger.trace("Inicio servicio NEW CLIENTE");
        return new ResponseEntity<>(clientServ.createNewCliente(client), HttpStatus.OK);
    }

    @GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listado de Clientes", notes = "CLIENTES")
    public List<Client> getAll() throws ServiceException {
        return clientServ.findAll();
    }

    @GetMapping(value = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "KPI de Clientes", notes = "KPI")
    public Kpi getKpi() throws Exception {
        return clientServ.getKpi();
    }

}
