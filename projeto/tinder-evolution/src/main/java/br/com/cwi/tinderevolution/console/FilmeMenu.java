package br.com.cwi.tinderevolution.console;

import br.com.cwi.tinderevolution.dominio.CategoriasFilme;
import br.com.cwi.tinderevolution.dominio.Filme;
import br.com.cwi.tinderevolution.gerenciador.FilmeGerenciador;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FilmeMenu {

    public FilmeGerenciador gerenciador;

    public FilmeMenu() {
        this.gerenciador = new FilmeGerenciador();
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

    public Filme criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Filme:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Lançamento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Lançamnto: ");
        int dia = scanner.nextInt();

        System.out.println("Categoria:");
        System.out.println("[ A ] - Ação");
        System.out.println("[ C ] - Comédia");
        System.out.println("[ D ] - Drama");
        System.out.println("[ S ] - Sitcom");
        System.out.println("[ U ] - Suspense");
        System.out.println("[ T ] - Terror");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasFilme categoriasFilme;
        switch (categoria) {
            case "A":
                categoriasFilme = CategoriasFilme.ACAO;
                break;
            case "C":
                categoriasFilme = CategoriasFilme.COMEDIA;
                break;
            case "D":
                categoriasFilme = CategoriasFilme.DRAMA;
                break;
            case "S":
                categoriasFilme = CategoriasFilme.SITCOM;
                break;
            case "U":
                categoriasFilme = CategoriasFilme.SUSPENSE;
                break;
            case "T":
                categoriasFilme = CategoriasFilme.TERROR;
                break;
            default:
                categoriasFilme = CategoriasFilme.ACAO;
                break;
        }

        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();

        Filme filme = new Filme(nome, autor, LocalDate.of(ano, mes, dia), categoriasFilme, sinopse);
        return gerenciador.salvar(filme);

    }

    public Filme editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Filme:");
        System.out.println("Qual filme deseja editar?");
        List<Filme> filmes = gerenciador.listar();
        for (Filme filme : filmes) {
            System.out.println("[" + filme.id + "] - " + filme.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Lançamento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Lançamnto: ");
        int dia = scanner.nextInt();

        System.out.println("Categoria:");
        System.out.println("[ A ] - Ação");
        System.out.println("[ C ] - Comédia");
        System.out.println("[ D ] - Drama");
        System.out.println("[ S ] - Sitcom");
        System.out.println("[ U ] - Suspense");
        System.out.println("[ T ] - Terror");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasFilme categoriasFilme;
        switch (categoria) {
            case "A":
                categoriasFilme = CategoriasFilme.ACAO;
                break;
            case "C":
                categoriasFilme = CategoriasFilme.COMEDIA;
                break;
            case "D":
                categoriasFilme = CategoriasFilme.DRAMA;
                break;
            case "S":
                categoriasFilme = CategoriasFilme.SITCOM;
                break;
            case "U":
                categoriasFilme = CategoriasFilme.SUSPENSE;
                break;
            case "T":
                categoriasFilme = CategoriasFilme.TERROR;
                break;
            default:
                categoriasFilme = CategoriasFilme.ACAO;
                break;
        }

        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();

        Filme atualizacao = new Filme(nome, autor, LocalDate.of(ano, mes, dia), categoriasFilme, sinopse);

        Filme filmeAtualizado = gerenciador.editar(id, atualizacao);

        if (filmeAtualizado == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println(filmeAtualizado);
        }

        return filmeAtualizado;

    }

    public List<Filme> listar() {

        System.out.println("\nListando Filmes:");
        List<Filme> filmes = gerenciador.listar();

        for (Filme filme : filmes) {
            System.out.println(filme);
        }

        return filmes;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Filme:");
        System.out.println("Qual o código do filme?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Filme filme = gerenciador.procurar(id);

        if (filme == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println(filme);
        }

    }
    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeletando Filme:");
        System.out.println("Qual filme deseja deletar?");

        List<Filme> filmes = gerenciador.listar();
        for (Filme filme : filmes){
            System.out.println("[" + filme.id + "] - " + filme.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)){
            System.out.println("Filme deletado!");
        }else{
            System.out.println("Filme não encontrado.");
        }

    }

}
