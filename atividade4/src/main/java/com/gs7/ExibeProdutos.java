package com.gs7;

import java.io.IOException;
import java.util.List;

public class ExibeProdutos {
    public static void main(String[] args) {

        try {
            List<Produto> produtos = new ProdutoService().buscarProdutos();
            System.out.println("=== PRODUTOS DO ARQUIVO ===");
            System.out.println("-------------");
            System.out.println("ID | PRODUTO");
            System.out.println("-------------");
            produtos.forEach(p -> {
                System.out.println(p.toString());
            });
            System.out.println("-------------");
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}