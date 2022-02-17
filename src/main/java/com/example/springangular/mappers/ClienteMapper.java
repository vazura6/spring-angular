package com.example.springangular.mappers;

import java.util.List;

import com.example.springangular.dtos.Cliente;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClienteMapper {
    

    public List<Cliente> findAll();

    public Cliente getById(@Param("id") Integer id);

    public int insert(Cliente cliente);

    public int delete(Cliente cliente);

    public int update(Cliente cliente);

}
