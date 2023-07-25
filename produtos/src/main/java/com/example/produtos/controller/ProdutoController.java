package com.example.produtos.controller;

import com.example.produtos.domain.DadosAlteraProduto;
import com.example.produtos.domain.DadosCadastroProduto;
import com.example.produtos.domain.Produto;
import com.example.produtos.domain.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/cadastro")
    public String carregaPaginaCadastro(Long id, Model model){
        if(id != null){
            Produto produto = repository.getReferenceById(id);
            model.addAttribute("produto", produto);
        }
        return "produto/cadastro";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "produto/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastroProduto(DadosCadastroProduto dados){
        Produto produto = new Produto(dados);
        repository.save(produto);
        return "redirect:/produto";
    }


    @PutMapping
    @Transactional
    public String alteraProduto(DadosAlteraProduto dados){
        Produto produto = repository.getReferenceById(dados.id());
        produto.atualizaDados(dados);
        return "redirect:/produto";
    }

    @DeleteMapping
    @Transactional
    public String deleteProduto(Long id){
        repository.deleteById(id);
        return "redirect:/produto";
    }

}
