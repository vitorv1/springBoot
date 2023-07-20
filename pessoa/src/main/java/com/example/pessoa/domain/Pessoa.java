package com.example.pessoa.domain;

import jakarta.persistence.*;

@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String sexo;
    private String profissao;

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", profissao='" + profissao + '\'' +
                '}';
    }


    public String getNome() {
        return nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public String getSexo() {
        return sexo;
    }
    public String getProfissao() {
        return profissao;
    }
    public Long getId() {return id;}

    public Pessoa(){
    }

    public Pessoa(DadosCadastros dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.sexo = dados.sexo();
        this.profissao = dados.profissao();
    }

    public void atualizaDados(DadosAlteraPessoa dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.sexo = dados.sexo();
        this.profissao = dados.profissao();
    }



}
