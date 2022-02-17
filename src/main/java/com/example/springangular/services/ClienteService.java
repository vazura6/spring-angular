package com.example.springangular.services;

import java.util.List;

import com.example.springangular.dtos.Cliente;
import com.example.springangular.mappers.ClienteMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;

    
    public Cliente getById(Integer id) {
        return clienteMapper.getById(id);
    }

    public List<Cliente> findAll() {
        return clienteMapper.findAll();
    }

    public Cliente save (Cliente cliente) {

        if (cliente.getId() == null) {
            this.clienteMapper.insert(cliente);
        } else {
            this.clienteMapper.update(cliente);
        }

        return cliente;
    }

    public void delete (Integer clienteId) throws Exception {
        Cliente cliente = this.clienteMapper.getById(clienteId);

        if (cliente == null) {
            throw new Exception("Error");
        }
        this.clienteMapper.delete(cliente);
    }
    
}
