package console;

import dominio.EstiloMusical;
import dominio.Musica;
import gerenciador.MusicaGerenciador;

import java.lang.annotation.ElementType;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MusicaMenu {

    public MusicaGerenciador gerenciador;

    public MusicaMenu() {
        this.gerenciador = new MusicaGerenciador();
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

    public Musica criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Musica:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Lançamento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Lançamnto: ");
        int dia = scanner.nextInt();

        System.out.println("Estilo:");
        System.out.println("[ F ] - Funk");
        System.out.println("[ I ] - Indie");
        System.out.println("[ M ] - Metal");
        System.out.println("[ P ] - Pagode");
        System.out.println("[ R ] - Rock");
        System.out.println("[ S ] - Sertanejo");
        System.out.print("-> ");
        String estilo = scanner.next();

        EstiloMusical estiloMusical;
        switch (estilo) {
            case "F":
                estiloMusical = EstiloMusical.FUNK;
                break;
            case "I":
                estiloMusical = EstiloMusical.INDIE;
                break;
            case "M":
                estiloMusical = EstiloMusical.METAL;
                break;
            case "P":
                estiloMusical = EstiloMusical.PAGODE;
                break;
            case "R":
                estiloMusical = EstiloMusical.ROCK;
                break;
            case "S":
                estiloMusical = EstiloMusical.SERTANEJO;
                break;
            default:
                estiloMusical = EstiloMusical.SERTANEJO;
                break;
        }

        Musica musica = new Musica(nome, artista, LocalDate.of(ano, mes, dia), estiloMusical);
        return gerenciador.salvar(musica);

    }

    public Musica editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Musica:");
        System.out.println("Qual musica deseja editar?");
        List<Musica> musicas = gerenciador.listar();
        for (Musica musica : musicas) {
            System.out.println("[" + musica.id + "] - " + musica.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Lançamento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Lançamnto: ");
        int dia = scanner.nextInt();

        System.out.println("Estilo:");
        System.out.println("[ F ] - Funk");
        System.out.println("[ I ] - Indie");
        System.out.println("[ M ] - Metal");
        System.out.println("[ P ] - Pagode");
        System.out.println("[ R ] - Rock");
        System.out.println("[ S ] - Sertanejo");
        System.out.print("-> ");
        String estilo = scanner.next();

        EstiloMusical estiloMusical;
        switch (estilo) {
            case "F":
                estiloMusical = EstiloMusical.FUNK;
                break;
            case "I":
                estiloMusical = EstiloMusical.INDIE;
                break;
            case "M":
                estiloMusical = EstiloMusical.METAL;
                break;
            case "P":
                estiloMusical = EstiloMusical.PAGODE;
                break;
            case "R":
                estiloMusical = EstiloMusical.ROCK;
                break;
            case "S":
                estiloMusical = EstiloMusical.SERTANEJO;
                break;
            default:
                estiloMusical = EstiloMusical.SERTANEJO;
                break;
        }

        Musica atualizacao = new Musica(nome, artista, LocalDate.of(ano, mes, dia), estiloMusical);

        Musica musicaAtualizada = gerenciador.editar(id, atualizacao);

        if (musicaAtualizada == null) {
            System.out.println("Musica não encontrada.");
        } else {
            System.out.println(musicaAtualizada);
        }

        return musicaAtualizada;

    }

        public List<Musica> listar() {

            System.out.println("\nListando Musicas:");
            List<Musica> musicas = gerenciador.listar();

            for (Musica musica : musicas) {
                System.out.println(musica);
            }

            return musicas;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Musica:");
        System.out.println("Qual o código da musica?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Musica musica = gerenciador.procurar(id);

        if (musica == null) {
            System.out.println("Musica não encontrada.");
        } else {
            System.out.println(musica);
        }

    }
     public void deletar(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("\nDeletando Musica:");
         System.out.println("Qual musica deseja deletar?");

         List<Musica> musicas = gerenciador.listar();
         for (Musica musica : musicas){
             System.out.println("[" + musica.id + "] - " + musica.nome);
         }

         System.out.print("-> ");
         int id = scanner.nextInt();

         if (gerenciador.deletar(id)){
             System.out.println("Musica deletada!");
         }else{
             System.out.println("Musica não encontrada.");
         }

     }

}

