package com.example.springangular.services;

import java.util.List;

import com.example.springangular.dtos.Cliente;
import com.example.springangular.mappers.ClienteMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;

    
    public Cliente getById(Number id) {
        return clienteMapper.getById(id);
    }

    public List<Cliente> findAll() {
        return clienteMapper.findAll();
    }
    
}
