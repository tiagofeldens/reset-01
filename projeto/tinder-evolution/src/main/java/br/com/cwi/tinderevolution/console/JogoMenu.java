package br.com.cwi.tinderevolution.console;

import br.com.cwi.tinderevolution.dominio.CategoriasJogo;
import br.com.cwi.tinderevolution.dominio.Jogo;
import br.com.cwi.tinderevolution.dominio.PlataformasJogo;
import br.com.cwi.tinderevolution.gerenciador.JogoGerenciador;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class JogoMenu {

    public JogoGerenciador gerenciador;

    public JogoMenu() {
        this.gerenciador = new JogoGerenciador();
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

    public Jogo criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Jogo:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();
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
        System.out.println("[ M ] - Musical");
        System.out.println("[ S ] - Suspense");
        System.out.println("[ T ] - Terror");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasJogo categoriasJogo;
        switch (categoria) {
            case "A":
                categoriasJogo = CategoriasJogo.ACAO;
                break;
            case "C":
                categoriasJogo = CategoriasJogo.COMEDIA;
                break;
            case "D":
                categoriasJogo = CategoriasJogo.DRAMA;
                break;
            case "M":
                categoriasJogo = CategoriasJogo.MUSICAL;
                break;
            case "S":
                categoriasJogo = CategoriasJogo.SUSPENSE;
                break;
            case "T":
                categoriasJogo = CategoriasJogo.TERROR;
                break;
            default:
                categoriasJogo = CategoriasJogo.ACAO;
                break;
        }

        System.out.println("Plataforma:");
        System.out.println("[ C ] - PC");
        System.out.println("[ p ] - PS4");
        System.out.println("[ S ] - SNES");
        System.out.println("[ X ] - XBOX");
        System.out.print("-> ");
        String plataforma = scanner.next();

        PlataformasJogo plataformasJogo;
        switch (plataforma) {
            case "C":
                plataformasJogo = PlataformasJogo.PC;
                break;
            case "P":
                plataformasJogo = PlataformasJogo.PS4;
                break;
            case "S":
                plataformasJogo = PlataformasJogo.SNES;
                break;
            case "X":
                plataformasJogo = PlataformasJogo.XBOX;
                break;
            default:
                plataformasJogo = PlataformasJogo.PC;
                break;
        }

        Jogo jogo  = new Jogo(nome, publisher, LocalDate.of(ano, mes, dia),categoriasJogo, plataformasJogo);
        return gerenciador.salvar(jogo);

    }

    public Jogo editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Jogo:");
        System.out.println("Qual Jogo deseja editar?");
        List<Jogo> jogos = gerenciador.listar();
        for (Jogo jogo : jogos) {
            System.out.println("[" + jogo.id + "] - " + jogo.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();


        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();
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
        System.out.println("[ M ] - Musical");
        System.out.println("[ S ] - Suspense");
        System.out.println("[ T ] - Terror");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasJogo categoriasJogo;
        switch (categoria) {
            case "A":
                categoriasJogo = CategoriasJogo.ACAO;
                break;
            case "C":
                categoriasJogo = CategoriasJogo.COMEDIA;
                break;
            case "D":
                categoriasJogo = CategoriasJogo.DRAMA;
                break;
            case "M":
                categoriasJogo = CategoriasJogo.MUSICAL;
                break;
            case "S":
                categoriasJogo = CategoriasJogo.SUSPENSE;
                break;
            case "T":
                categoriasJogo = CategoriasJogo.TERROR;
                break;
            default:
                categoriasJogo = CategoriasJogo.ACAO;
                break;
        }

        System.out.println("Plataforma:");
        System.out.println("[ C ] - PC");
        System.out.println("[ p ] - PS4");
        System.out.println("[ S ] - SNES");
        System.out.println("[ X ] - XBOX");
        System.out.print("-> ");
        String plataforma = scanner.next();

        PlataformasJogo plataformasJogo;
        switch (plataforma) {
            case "C":
                plataformasJogo = PlataformasJogo.PC;
                break;
            case "P":
                plataformasJogo = PlataformasJogo.PS4;
                break;
            case "S":
                plataformasJogo = PlataformasJogo.SNES;
                break;
            case "X":
                plataformasJogo = PlataformasJogo.XBOX;
                break;
            default:
                plataformasJogo = PlataformasJogo.PC;
                break;
        }

        Jogo atualizacao = new Jogo(nome, publisher, LocalDate.of(ano, mes, dia), categoriasJogo, plataformasJogo);

        Jogo jogoAtualizado = gerenciador.editar(id, atualizacao);

        if (jogoAtualizado == null) {
            System.out.println("Jogo não encontrado.");
        } else {
            System.out.println(jogoAtualizado);
        }

        return jogoAtualizado;

    }

    public List<Jogo> listar() {

        System.out.println("\nListando Jogos:");
        List<Jogo> jogos = gerenciador.listar();

        for (Jogo jogo : jogos) {
            System.out.println(jogo);
        }

        return jogos;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Jogo:");
        System.out.println("Qual o código do jogo?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Jogo jogo = gerenciador.procurar(id);

        if (jogo == null) {
            System.out.println("Jogo não encontrado.");
        } else {
            System.out.println(jogo);
        }

    }
    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeletando Jogo:");
        System.out.println("Qual jogo deseja deletar?");

        List<Jogo> jogos = gerenciador.listar();
        for (Jogo jogo : jogos){
            System.out.println("[" + jogo.id + "] - " + jogo.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)){
            System.out.println("Jogo deletado!");
        }else{
            System.out.println("Jogo não encontrado.");
        }

    }

}
