package br.com.cwi.tinderevolution.console;

import br.com.cwi.tinderevolution.dominio.CategoriasFilme;
import br.com.cwi.tinderevolution.dominio.CategoriasSerie;
import br.com.cwi.tinderevolution.dominio.Filme;
import br.com.cwi.tinderevolution.dominio.Serie;
import br.com.cwi.tinderevolution.gerenciador.FilmeGerenciador;
import br.com.cwi.tinderevolution.gerenciador.SerieGerenciador;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SerieMenu {


    public SerieGerenciador gerenciador;

    public SerieMenu() {
        this.gerenciador = new SerieGerenciador();
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

    public Serie criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Serie:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Lançamento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Lançamnto: ");
        int dia = scanner.nextInt();
        System.out.print("Numero de Temporadas: ");
        int numeroDeTemporadas = scanner.nextInt();
        System.out.print("Numero de Episódios: ");
        int numeroDeEpisodios = scanner.nextInt();


        System.out.println("Categoria:");
        System.out.println("[ A ] - Ação");
        System.out.println("[ C ] - Comédia");
        System.out.println("[ D ] - Drama");
        System.out.println("[ S ] - Sitcom");
        System.out.println("[ U ] - Suspense");
        System.out.println("[ T ] - Terror");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasSerie categoriasSerie;
        switch (categoria) {
            case "A":
                categoriasSerie = CategoriasSerie.ACAO;
                break;
            case "C":
                categoriasSerie = CategoriasSerie.COMEDIA;
                break;
            case "D":
                categoriasSerie = CategoriasSerie.DRAMA;
                break;
            case "S":
                categoriasSerie = CategoriasSerie.SITCOM;
                break;
            case "U":
                categoriasSerie = CategoriasSerie.SUSPENSE;
                break;
            case "T":
                categoriasSerie = CategoriasSerie.TERROR;
                break;
            default:
                categoriasSerie = CategoriasSerie.ACAO;
                break;
        }

        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();

        Serie serie = new Serie(nome, diretor, LocalDate.of(ano, mes, dia), numeroDeTemporadas, numeroDeEpisodios, categoriasSerie, sinopse);
        return gerenciador.salvar(serie);

    }

    public Serie editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Serie:");
        System.out.println("Qual serie deseja editar?");
        List<Serie> series = gerenciador.listar();
        for (Serie serie : series) {
            System.out.println("[" + serie.id + "] - " + serie.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();


        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Lançamento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Lançamnto: ");
        int dia = scanner.nextInt();
        System.out.print("Numero de Temporadas: ");
        int numeroDeTemporadas = scanner.nextInt();
        System.out.print("Numero de Episódios: ");
        int numeroDeEpisodios = scanner.nextInt();


        System.out.println("Categoria:");
        System.out.println("[ A ] - Ação");
        System.out.println("[ C ] - Comédia");
        System.out.println("[ D ] - Drama");
        System.out.println("[ S ] - Sitcom");
        System.out.println("[ U ] - Suspense");
        System.out.println("[ T ] - Terror");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasSerie categoriasSerie;
        switch (categoria) {
            case "A":
                categoriasSerie = CategoriasSerie.ACAO;
                break;
            case "C":
                categoriasSerie = CategoriasSerie.COMEDIA;
                break;
            case "D":
                categoriasSerie = CategoriasSerie.DRAMA;
                break;
            case "S":
                categoriasSerie = CategoriasSerie.SITCOM;
                break;
            case "U":
                categoriasSerie = CategoriasSerie.SUSPENSE;
                break;
            case "T":
                categoriasSerie = CategoriasSerie.TERROR;
                break;
            default:
                categoriasSerie = CategoriasSerie.ACAO;
                break;
        }

        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();

        Serie atualizacao = new Serie(nome, diretor, LocalDate.of(ano, mes, dia), numeroDeTemporadas, numeroDeEpisodios, categoriasSerie, sinopse);

        Serie serieAtualizada = gerenciador.editar(id, atualizacao);

        if (serieAtualizada == null) {
            System.out.println("Serie não encontrada.");
        } else {
            System.out.println(serieAtualizada);
        }

        return serieAtualizada;

    }

    public List<Serie> listar() {

        System.out.println("\nListando Series:");
        List<Serie> series = gerenciador.listar();

        for (Serie serie : series) {
            System.out.println(serie);
        }

        return series;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Serie:");
        System.out.println("Qual o código da serie?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Serie serie = gerenciador.procurar(id);

        if (serie == null) {
            System.out.println("Serie não encontrada.");
        } else {
            System.out.println(serie);
        }

    }
    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeletando Serie:");
        System.out.println("Qual serie deseja deletar?");

        List<Serie> series = gerenciador.listar();
        for (Serie serie : series){
            System.out.println("[" + serie.id + "] - " + serie.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)){
            System.out.println("Serie deletada!");
        }else{
            System.out.println("Serie não encontrada.");
        }

    }

}
