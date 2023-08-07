package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CofrinhoApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        Dollar dollar = new Dollar(10.0);
        Euro euro = new Euro(20.0);
        Real real = new Real(30.0);

        cofrinho.adicionarMoeda(dollar);
        cofrinho.adicionarMoeda(euro);
        cofrinho.adicionarMoeda(real);

        int opcao;
        do {
            System.out.println("\n----- Cofrinho -----");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Valor total em Reais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da moeda: ");
                    double valor = scanner.nextDouble();
                    System.out.print("Digite o tipo de moeda (D - Dollar, E - Euro, R - Real): ");
                    String tipo = scanner.next().toUpperCase();
                    Moeda moeda;
                    switch (tipo) {
                        case "D":
                            moeda = new Dollar(valor);
                            break;
                        case "E":
                            moeda = new Euro(valor);
                            break;
                        case "R":
                            moeda = new Real(valor);
                            break;
                        default:
                            System.out.println("Tipo de moeda inválido! Moeda não adicionada.");
                            continue;
                    }
                    cofrinho.adicionarMoeda(moeda);
                    System.out.println("Moeda adicionada ao cofrinho!");
                    break;

                case 2:
                    System.out.println("Moedas no cofrinho:");
                    listarMoedas(cofrinho);
                    System.out.print("Digite o índice da moeda que deseja remover: ");
                    try {
                        int indice = scanner.nextInt();
                        if (cofrinho.indiceValido(indice)) {
                            Moeda moedaRemovida = cofrinho.getMoedas().get(indice);
                            cofrinho.removerMoeda(moedaRemovida);
                            System.out.println("Moeda removida do cofrinho!");
                        } else {
                            System.out.println("Índice inválido! Nenhuma moeda removida.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Certifique-se de digitar um número inteiro.");
                        scanner.next(); // Limpar a entrada inválida do scanner
                    }
                    break;

                case 3:
                    System.out.println("Moedas no cofrinho:");
                    listarMoedas(cofrinho);
                    break;

                case 4:
                    System.out.println("Valor total em Reais: R$" + cofrinho.getValorTotalConvertido());
                    break;

                case 0:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void listarMoedas(Cofrinho cofrinho) {
        List<Moeda> moedas = cofrinho.getMoedas();
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio!");
        } else {
            for (int i = 0; i < moedas.size(); i++) {
                Moeda moeda = moedas.get(i);
                System.out.print(i + ". ");
                moeda.info();
            }
        }
    }
}