package br.com.cwi.tinderevolution.console;

import br.com.cwi.tinderevolution.dominio.CategoriasCuriosidade;
import br.com.cwi.tinderevolution.dominio.Curiosidade;
import br.com.cwi.tinderevolution.gerenciador.CuriosidadeGerenciador;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CuriosidadeMenu {

    public CuriosidadeGerenciador gerenciador;

    public CuriosidadeMenu() {
        this.gerenciador = new CuriosidadeGerenciador();
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

    public Curiosidade criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Curiosidade:");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("Categoria:");
        System.out.println("[ A ] - Alimentação");
        System.out.println("[ B ] - Aparência");
        System.out.println("[ C ] - Comportamento");
        System.out.println("[ E ] - Evento");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasCuriosidade categoriasCuriosidade;
        switch (categoria) {
            case "A":
                categoriasCuriosidade = CategoriasCuriosidade.ALIMENTACAO;
                break;
            case "B":
                categoriasCuriosidade = CategoriasCuriosidade.APARENCIA;
                break;
            case "C":
                categoriasCuriosidade = CategoriasCuriosidade.COMPORTAMENTO;
                break;
            case "E":
                categoriasCuriosidade = CategoriasCuriosidade.EVENTO;
                break;
            default:
                categoriasCuriosidade = CategoriasCuriosidade.COMPORTAMENTO;
                break;
        }

        Curiosidade curiosidade = new Curiosidade(descricao, categoriasCuriosidade);
        return gerenciador.salvar(curiosidade);

    }

    public Curiosidade editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Curiosidade:");
        System.out.println("Qual curiosidade deseja editar?");
        List<Curiosidade> curiosidades = gerenciador.listar();
        for (Curiosidade curiosidade : curiosidades) {
            System.out.println("[" + curiosidade.id + "] - " + curiosidade.descricao);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();


        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("Categoria:");
        System.out.println("[ A ] - Alimentação");
        System.out.println("[ B ] - Aparência");
        System.out.println("[ C ] - Comportamento");
        System.out.println("[ E ] - Evento");
        System.out.print("-> ");
        String categoria = scanner.next();

        CategoriasCuriosidade categoriasCuriosidade;
        switch (categoria) {
            case "A":
                categoriasCuriosidade = CategoriasCuriosidade.ALIMENTACAO;
                break;
            case "B":
                categoriasCuriosidade = CategoriasCuriosidade.APARENCIA;
                break;
            case "C":
                categoriasCuriosidade = CategoriasCuriosidade.COMPORTAMENTO;
                break;
            case "E":
                categoriasCuriosidade = CategoriasCuriosidade.EVENTO;
                break;
            default:
                categoriasCuriosidade = CategoriasCuriosidade.COMPORTAMENTO;
                break;
        }

        Curiosidade atualizacao = new Curiosidade(descricao, categoriasCuriosidade);

        Curiosidade curiosidadeAtualizada = gerenciador.editar(id, atualizacao);

        if (curiosidadeAtualizada == null) {
            System.out.println("Curiosidade não encontrada.");
        } else {
            System.out.println(curiosidadeAtualizada);
        }

        return curiosidadeAtualizada;

    }

    public List<Curiosidade> listar() {

        System.out.println("\nListando Curiosidades:");
        List<Curiosidade> curiosidades = gerenciador.listar();

        for (Curiosidade curiosidade : curiosidades) {
            System.out.println(curiosidade);
        }

        return curiosidades;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Curiosidade:");
        System.out.println("Qual o código da curiosidade?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Curiosidade curiosidade = gerenciador.procurar(id);

        if (curiosidade == null) {
            System.out.println("Curiosidade não encontrada.");
        } else {
            System.out.println(curiosidade);
        }

    }
    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeletando Curiosidade:");
        System.out.println("Qual curiosidade deseja deletar?");

        List<Curiosidade> curiosidades = gerenciador.listar();
        for (Curiosidade curiosidade : curiosidades){
            System.out.println("[" + curiosidade.id + "] - " + curiosidade.descricao);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)){
            System.out.println("Curiosidade deletada!");
        }else{
            System.out.println("Curiosidade não encontrada.");
        }

    }

}
