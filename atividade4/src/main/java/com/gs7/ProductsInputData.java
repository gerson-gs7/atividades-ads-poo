package com.gs7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsInputData {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("Cadastre os produtos ou digite 'sair' para cancelar");
        System.out.println("----------------------------------------------------");
        List<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nome;
        int cont = 10;
        do {
            System.out.print("Digite o nome do produto: ");
            nome = sc.next();
            if (!nome.equalsIgnoreCase("sair")) {
                cont++;
                Produto p = new Produto(cont, nome);
                produtos.add(p);
            }
        } while (!nome.equalsIgnoreCase("sair"));
        sc.close();
        if (!produtos.isEmpty()) {
            try {
                new ProdutoService().cadastrar(produtos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
