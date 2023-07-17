package com.example.pessoa.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

    @Id
    private Long id;
    private String nome;
    private Integer idade;
    private String sexo;
    private String profissao;

    public Pessoa(){
    }

    public Pessoa(String nome, Integer idade, String sexo, String profissao){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
    }



}
