
package com.senai.aula11devops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import com.senai.aula11devops.models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    // Lista que simula um banco de dados
    private List<Produto> produtos = new ArrayList<>();

    // Construtor - Produtos iniciais
    public ProdutoController() {

        produtos.add(new Produto(1, "Notebook", 4500));
        produtos.add(new Produto(2, "Mouse", 100));
        produtos.add(new Produto(3, "Teclado", 250));

    }

    // POST - Cadastrar produto
    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(
            @RequestBody Produto produto) {

        produtos.add(produto);

        // HTTP 201 - Created
        return ResponseEntity.status(201).body(produto);
    }

    // GET - Listar produtos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {

        // HTTP 200 - OK
        return ResponseEntity.ok(produtos);
    }

    // GET - Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(
            @PathVariable int id) {

        for (Produto produto : produtos) {

            if (produto.getId() == id) {
                return ResponseEntity.ok(produto);
            }
        }

        // HTTP 404 - Not Found
        return ResponseEntity.notFound().build();
    }
}
