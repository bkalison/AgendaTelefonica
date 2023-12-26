package br.com.estudos;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contatos contatos = new Contatos("","", "");

        int opcao = 0;

        while (opcao != 7) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contatos.create();
                    break;
                case 2:
                    contatos.imprime();
                    contatos.remove();
                    break;
                case 3:
                    contatos.imprime();
                    contatos.visualizaContato();
                    break;
                case 4:
                    contatos.imprime();
                    contatos.edit();
                    break;
                case 5:
                    contatos.pesquisa();
                    break;
                case 6:
                    contatos.imprime();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("==================\n");
        System.out.println("O que deseja fazer :");
        System.out.println("1 - Criar Contato");
        System.out.println("2 - Remover Contatos");
        System.out.println("3 - Visualizar Contato");
        System.out.println("4 - Editar Contatos");
        System.out.println("5 - Pesquisar Contatos");
        System.out.println("6 - Imprimir todos os contatos");
        System.out.println("7 - Sair\n");
        System.out.println("==================");
    }
}
