package com.mercado.komprinha.controller;

import com.mercado.komprinha.model.Categoria;
import com.mercado.komprinha.model.Produto;
import com.mercado.komprinha.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", Categoria.values());
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto,
                         @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String base64 = Base64.getEncoder().encodeToString(file.getBytes());
                produto.setImagem(base64);
            }
            produtoRepository.save(produto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", Categoria.values());
        return "editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Produto produto,
                            @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                // Usuário enviou nova imagem
                String base64 = Base64.getEncoder().encodeToString(file.getBytes());
                produto.setImagem(base64);
            } else {
                // Nenhum arquivo enviado → mantém imagem anterior
                Produto existente = produtoRepository.findById(produto.getId())
                        .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + produto.getId()));
                produto.setImagem(existente.getImagem());
            }

            produtoRepository.save(produto);
            return "redirect:/produtos";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("produto", produto);
        return "visualizar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }
}
