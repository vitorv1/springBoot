package com.example.pessoa.domain;


public class Pessoa {


    private Long id;
    private String nome;
    private Integer idade;
    private String sexo;
    private String profissao;

    public Pessoa(){
    }

    public Pessoa(DadosCadastros dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.sexo = dados.sexo();
        this.profissao = dados.profissao();
    }



}
