package br.com.cwi.tinderevolution.console;



import br.com.cwi.tinderevolution.dominio.Esporte;
import br.com.cwi.tinderevolution.gerenciador.EsporteGerenciador;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EsporteMenu {

    public EsporteGerenciador gerenciador;

    public EsporteMenu() {
        this.gerenciador = new EsporteGerenciador();
    }

    void opcoes() {
        Scanner scanner = new Scanner(System.in);
        char opcao = ' ';

        while (opcao != 'X') {

            System.out.println("Escolha uma opção:");
            System.out.println("[ C ] - Criar");
            System.out.println("[ E ] - Editar");
            System.out.println("[ L ] - Listar");
            System.out.println("[ P } - Procurar");
            System.out.println("[ D ] - Deletar");
            System.out.println("[ X ] - Voltar");
            System.out.print("-> ");
            opcao = scanner.next().charAt(0);


            switch (opcao) {
                case 'C':
                    criar();
                    break;
                case 'E':
                    editar();
                    break;
                case 'L':
                    listar();
                    break;
                case 'P':
                    procurar();
                    break;
                case 'D':
                    deletar();
                case 'X':
                    System.out.println("...");
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
            }

        }
    }

    public Esporte criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Esporte:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Esporte esporte = new Esporte(nome);
        return gerenciador.salvar(esporte);

    }

    public Esporte editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Esporte:");
        System.out.println("Qual esporte deseja editar?");
        List<Esporte> esportes = gerenciador.listar();
        for (Esporte esporte : esportes) {
            System.out.println("[" + esporte.id + "] - " + esporte.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();


        Esporte atualizacao = new Esporte(nome);

        Esporte esporteAtualizado = gerenciador.editar(id, atualizacao);

        if (esporteAtualizado == null) {
            System.out.println("Esporte não encontrada.");
        } else {
            System.out.println(esporteAtualizado);
        }

        return esporteAtualizado;

    }

    public List<Esporte> listar() {

        System.out.println("\nListando Esportes:");
        List<Esporte> esportes = gerenciador.listar();

        for (Esporte esporte : esportes) {
            System.out.println(esporte);
        }

        return esportes;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Esporte:");
        System.out.println("Qual o código do esporte?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Esporte esporte = gerenciador.procurar(id);

        if (esporte == null) {
            System.out.println("Esporte não encontrada.");
        } else {
            System.out.println(esporte);
        }

    }
    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeletando Esporte:");
        System.out.println("Qual esporte deseja deletar?");

        List<Esporte> esportes = gerenciador.listar();
        for (Esporte esporte : esportes){
            System.out.println("[" + esporte.id + "] - " + esporte.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)){
            System.out.println("Esporte deletado!");
        }else{
            System.out.println("Esporte não encontrada.");
        }

    }

}
