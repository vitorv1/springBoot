package com.example.clientecrud.domain;


import jakarta.persistence.*;

@Entity
@Table(name="clientes" )
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String numero_telefone;
    private String email;

    public Cliente(){}



    public Cliente (DadosCadastro dados){
        this.nome = dados.nome();
        this.cpf= dados.cpf();
        this.numero_telefone = dados.numero_telefone();
        this.email = dados.email();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", numero_telefone='" + numero_telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public String getEmail() {
        return email;
    }

    public void atualizaDados(DadosAtualizados dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.numero_telefone = dados.numero_telefone();
        this.email = dados.email();
    }



}
