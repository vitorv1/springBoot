package com.example.pessoa.controller;


import com.example.pessoa.domain.DadosCadastros;
import com.example.pessoa.domain.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    private List <Pessoa> pessoas = new ArrayList<>();


    @GetMapping("/cadastro")
    public String carregaFomulario(){
        return "pessoa/cadastro";
    }


    @GetMapping
    public String carregaListagem(Model model){
        model.addAttribute("lista", pessoas);
        return "pessoa/listagem";
    }

    @PostMapping
    public String cadastroPessoa(DadosCadastros dados){
        Pessoa pessoa = new Pessoa(dados);
        pessoas.add(pessoa);
        return "redirect:/pessoa";
    }


}
