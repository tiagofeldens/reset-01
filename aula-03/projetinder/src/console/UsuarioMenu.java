package console;

import dominio.Localizacao;
import dominio.Usuario;
import gerenciador.UsuarioGerenciador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UsuarioMenu {

    public UsuarioGerenciador gerenciador;

    public UsuarioMenu() {
        this.gerenciador = new UsuarioGerenciador();
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

    public Usuario criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Usuário:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Ano de Nascimento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Nascimento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Nascimento: ");
        int dia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bio: ");
        String bio = scanner.nextLine();
        System.out.print("Latitude: ");
        double latitude = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitude = scanner.nextDouble();

        Localizacao localizacao = new Localizacao(latitude, longitude);

        Usuario usuario = new Usuario(nome, email, telefone, LocalDate.of(ano, mes, dia), bio,localizacao);
        return gerenciador.salvar(usuario);

    }

    public Usuario editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando Usuário:");
        System.out.println("Qual Usuário deseja editar?");
        List<Usuario> usuarios = gerenciador.listar();
        for (Usuario usuario : usuarios) {
            System.out.println("[" + usuario.id + "] - " + usuario.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Ano de Nascimento: ");
        int ano = scanner.nextInt();
        System.out.print("Mês de Nascimento: ");
        int mes = scanner.nextInt();
        System.out.print("Dia de Nascimento: ");
        int dia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bio: ");
        String bio = scanner.nextLine();
        System.out.print("Latitude: ");
        double latitude = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitude = scanner.nextDouble();

        Localizacao localizacao = new Localizacao(latitude, longitude);

        Usuario atualizacao = new Usuario(nome, email, telefone, LocalDate.of(ano, mes, dia), bio, localizacao);

        Usuario usuarioAtualizado = gerenciador.editar(id, atualizacao);

        if (usuarioAtualizado == null) {
            System.out.println("Usuário não encontrada.");
        } else {
            System.out.println(usuarioAtualizado);
        }

        return usuarioAtualizado;

    }

    public List<Usuario> listar() {

        System.out.println("\nListando Usuários:");
        List<Usuario> usuarios = gerenciador.listar();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }

        return usuarios;

    }


    public void procurar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisando Usuário:");
        System.out.println("Qual o código da usuário?");
        System.out.print("-> ");
        int id = scanner.nextInt();

        Usuario usuario = gerenciador.procurar(id);

        if (usuario == null) {
            System.out.println("Usuário não encontrada.");
        } else {
            System.out.println(usuario);
        }

    }
    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeletando Usuário:");
        System.out.println("Qual usuário deseja deletar?");

        List<Usuario> usuarios = gerenciador.listar();
        for (Usuario usuario : usuarios){
            System.out.println("[" + usuario.id + "] - " + usuario.nome);
        }

        System.out.print("-> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)){
            System.out.println("Usuário deletado!");
        }else{
            System.out.println("Usuário não encontrado.");
        }

    }

}
