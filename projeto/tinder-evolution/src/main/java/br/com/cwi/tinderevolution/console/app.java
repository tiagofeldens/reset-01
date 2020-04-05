package br.com.cwi.tinderevolution.console;

import java.util.Scanner;


public class app {

    public static void main(String[] args) {

        UsuarioMenu usuarioMenu = new UsuarioMenu();
        MusicaMenu musicaMenu = new MusicaMenu();

        Scanner scanner = new Scanner(System.in);
        char opcao = ' ';

        while (opcao != 'X') {

            System.out.println("\nSelecione uma opção");
            System.out.println("[ U ] - Usuário");
            System.out.println("[ M ] - Músicas");
            System.out.println("[ X ] - Encerrar");
            System.out.print("-> ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'U':
                    usuarioMenu.opcoes();
                    break;

                case 'M':
                    musicaMenu.opcoes();
                    break;

                case 'X':
                    System.out.println("Encerrando");
                    break;

                default:
                    System.out.println("... opção inválida ...");
            }
        }
    }
}
