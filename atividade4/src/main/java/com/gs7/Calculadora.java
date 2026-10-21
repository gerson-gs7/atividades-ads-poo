package com.gs7;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.print("Escolha a operação (+, -, *, /): ");
        char operacao = scanner.next().charAt(0);

        double resultado;

        switch (operacao) {
            case '+':
                resultado = numero1 + numero2;
                System.out.println(numero1 + " + " + numero2 + " = " + resultado);
                break;
            case '-':
                resultado = numero1 - numero2;
                System.out.println(numero1 + " - " + numero2 + " = " + resultado);
                break;
            case '*':
                resultado = numero1 * numero2;
                System.out.println(numero1 + " * " + numero2 + " = " + resultado);
                break;
            case '/':
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println(numero1 + " / " + numero2 + " = " + resultado);
                } else {
                    System.out.println("Erro: divisão por zero não é permitida.");
                }
                break;
            default:
                System.out.println("Operação inválida!");
        }

        scanner.close();
    }
}
