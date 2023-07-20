package com.example.produtos.controller;

import com.example.produtos.domain.DadosCadastroProduto;
import com.example.produtos.domain.Produto;
import com.example.produtos.domain.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoRepository repository;

    @GetMapping("/cadastro")
    public String carregaPaginaCadastro(){
        return "produto/cadastro";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "produto/listagem";
    }

    @PostMapping
    public String cadastroProduto(DadosCadastroProduto dados){
        Produto produto = new Produto(dados);
        repository.save(produto);
        return "redirect:/produto";
    }

}
