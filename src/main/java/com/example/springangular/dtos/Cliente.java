package com.example.springangular.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    
    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private Date create_at;
    

}
