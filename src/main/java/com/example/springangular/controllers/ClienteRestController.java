package com.example.springangular.controllers;

import java.util.Date;
import java.util.List;

import com.example.springangular.dtos.Cliente;
import com.example.springangular.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("clientes")
    @ResponseBody
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("clientes/{id}")
    @ResponseBody
    public Cliente show(
        @PathVariable("id") Integer idInteger
    ){
        return clienteService.getById(idInteger);
    }

    @PostMapping("clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        cliente.setCreate_at(new Date());
        return this.clienteService.save(cliente);
    }

    @DeleteMapping("clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
        @PathVariable("id") Integer id
    ) throws Exception {

        this.clienteService.delete(id);
        return;
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Integer id) {
        Cliente clienteActual = clienteService.getById(id);
        clienteActual.setApellidos(cliente.getApellidos());
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setEmail(cliente.getEmail());

        return this.clienteService.save(clienteActual);
    }

}
