package com.example.pessoa.controller;


import com.example.pessoa.domain.DadosAlteraPessoa;
import com.example.pessoa.domain.DadosCadastros;
import com.example.pessoa.domain.Pessoa;
import com.example.pessoa.domain.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;


    @GetMapping("/cadastro")
    public String carregaFomulario(Long id, Model model){
        if(id != null) {
            Pessoa pessoa = repository.getReferenceById(id);
            model.addAttribute("lista", pessoa);
        }
        return "pessoa/cadastro";
    }

    @GetMapping
    public String carregaListagem(Model model){
            model.addAttribute("lista", repository.findAll());
        return "pessoa/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastroPessoa(DadosCadastros dados){
        Pessoa pessoa = new Pessoa(dados);
        repository.save(pessoa);
        return "redirect:/pessoa";
    }

    @PutMapping
    @Transactional
    public String alteraPessoa(DadosAlteraPessoa dados){
        Pessoa pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizaDados(dados);
        return "redirect:/pessoa";
    }

    @DeleteMapping
    @Transactional
    public String deletaPessoa(Long id){
        Pessoa pessoa = repository.getReferenceById(id);
        repository.deleteById(id);
        return "redirect:/pessoa";
    }


}
