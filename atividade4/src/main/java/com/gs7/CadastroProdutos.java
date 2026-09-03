package com.gs7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CadastroProdutos {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(21, "Notebook"));
        produtos.add(new Produto(22, "Mouse"));
        produtos.add(new Produto(23, "Teclado"));
        produtos.add(new Produto(24, "Monitor"));
        produtos.add(new Produto(25, "Headset"));

        ProdutoService service = new ProdutoService();
        System.out.println("=== PRODUTOS A SEREM CADASTRADOS ===");
        System.out.println("----------");
        produtos.forEach(p -> {
            System.out.println(p.getNome());
        });
        System.out.println("----------");
        
        try {
            service.cadastrar(produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}