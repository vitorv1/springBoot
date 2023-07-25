package com.example.produtos.domain;

import jakarta.persistence.*;

import java.util.Random;


@Entity
@Table(name="produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigo;
    private String nome;
    private double valor;
    private String marca;




    public Produto(DadosCadastroProduto dados) {
        Random random = new Random();
        this.codigo = random.nextLong(3000);
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.valor = dados.valor();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", valor=" + valor +
                '}';
    }
    public Produto (){}


    public Long getCodigo() {
        return codigo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public double getValor() {
        return valor;
    }

    public void atualizaDados(DadosAlteraProduto dados){
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.valor = dados.valor();
    }


}
