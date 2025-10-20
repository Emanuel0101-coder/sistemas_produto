package com.mercado.komprinha.controller;

import com.mercado.komprinha.model.Produto;
import com.mercado.komprinha.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Página inicial com lista de produtos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "listar";
    }

    // Página de cadastro
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    // Salvar novo produto
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    // Página de edição
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("produto", produto);
        return "editar";
    }

    // Atualizar produto
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    // Página de visualização
    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("produto", produto);
        return "visualizar";
    }

    // Excluir produto
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }
}
