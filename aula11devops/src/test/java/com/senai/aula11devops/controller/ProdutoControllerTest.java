
package com.senai.aula11devops.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Teste 1 - Listar produtos
   
@Test
void testarListarProdutos() throws Exception {

    mockMvc.perform(get("/produtos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(3))
            .andExpect(jsonPath("$[0].nome").value("Notebook"))
            .andExpect(jsonPath("$[1].nome").value("Mouse"))
            .andExpect(jsonPath("$[2].nome").value("Teclado"));
}

    // Teste 2 - Cadastrar produto
    @Test
    void testarCadastrarProduto() throws Exception {

        String produto = """
            {
                "id": 1,
                "nome": "Notebook",
                "preco": 3500
            }
            """;

        mockMvc.perform(post("/produtos")
                .contentType("application/json")
                .content(produto))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Notebook"))
                .andExpect(jsonPath("$.preco").value(3500));
    }

    // Teste 3 - Buscar produto inexistente
    @Test
    void testarProdutoInexistente() throws Exception {

        mockMvc.perform(get("/produtos/99"))
                .andExpect(status().isNotFound());
    }
}
