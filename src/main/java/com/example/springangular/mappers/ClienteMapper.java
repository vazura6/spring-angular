package com.example.springangular.mappers;

import java.util.List;

import com.example.springangular.dtos.Cliente;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClienteMapper {
    

    List<Cliente> findAll();

    Cliente getById(@Param("id") Number id);

}
