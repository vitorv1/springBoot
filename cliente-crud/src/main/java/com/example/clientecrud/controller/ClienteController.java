package com.example.clientecrud.controller;


import com.example.clientecrud.domain.Cliente;
import com.example.clientecrud.domain.ClienteRepository;
import com.example.clientecrud.domain.DadosAtualizados;
import com.example.clientecrud.domain.DadosCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/cadastro")
    public String carregaPaginaCadastro(Long id, Model model){
        if(id != null){
            Cliente cliente = repository.getReferenceById(id);
            model.addAttribute("cliente", cliente);
        }
        return "cliente/cadastro";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "cliente/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastroCliente(DadosCadastro dados){
        Cliente cliente = new Cliente(dados);
        repository.save(cliente);
        return "redirect:/cliente";
    }

    @PutMapping
    @Transactional
    public String alteraCliente(DadosAtualizados dados){
        Cliente cliente = repository.getReferenceById(dados.id());
        cliente.atualizaDados(dados);
        return "redirect:/cliente";
    }

    @DeleteMapping
    @Transactional
    public String deletaCliente(Long id){
        repository.deleteById(id);
        return "redirect:/cliente";
    }



}
