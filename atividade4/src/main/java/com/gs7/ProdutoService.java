package com.gs7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    String URL_FILE = "atividade4/src/main/java/com/gs7/produtos.txt";

    public void cadastrar(List<Produto> produtos) throws IOException {

        FileWriter f = new FileWriter(URL_FILE);
        System.out.println("Cadastrando...");
        produtos.forEach(p -> {
            try {
                f.write(p.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        f.close();

        System.out.println("Produtos cadastrados com sucesso!");
    }

    public List<Produto> buscarProdutos() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(URL_FILE));

        List<Produto> produtos = new ArrayList<>();
        String linha;
        while ((linha = file.readLine()) != null) {
            produtos.add(new Produto().toProduto(linha));
        }
        file.close();
        return produtos;
    }

}
