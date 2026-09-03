package com.gs7;

public class Produto {
    private int codigo;
    private String nome;

    public Produto() {}
    public Produto(int id, String nome) {
        this.codigo = id;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return codigo + " | " + nome;
    }


    public Produto toProduto(String linha) {
        String l = linha.replace("|", "");
        String[] palavras = l.split("  ");
        return new Produto(Integer.parseInt(palavras[0]), palavras[1]);
    }

}