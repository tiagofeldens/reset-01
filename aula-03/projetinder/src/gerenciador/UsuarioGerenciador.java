package gerenciador;

import Banco.UsuarioBanco;
import dominio.Usuario;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class UsuarioGerenciador {

    private UsuarioBanco banco = new UsuarioBanco();

    public Usuario salvar (Usuario usuario){
        List<Usuario> usuarios = banco.listar();

        if (usuario.nome.isEmpty() || usuario.email.isEmpty() || usuario.telefone.isEmpty() || usuario.bio.isEmpty() || usuario.dataNascimento == null){
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Usuario usuarioExistente : usuarios){
            if (usuario.email.equals(usuarioExistente.email)){
                return usuarioExistente;

            }
        }
        if (calcularIdade(usuario.dataNascimento) <18) {
            System.out.println("Usuário deve ter idade igual ou superior a 18 anos.");
            return null;
        }

        return banco.salvar(usuario);
    }

    public List<Usuario> listar () {
        return banco.listar();
    }

    public Usuario procurar (int id){
        if (id>0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Usuario editar (int id, Usuario usuarioEditado){
        List<Usuario> usuarios = banco.listar();
        Usuario usuarioExistente = procurar(id);
        if (usuarioExistente == null) {
            return null;
        }

        if (usuarioEditado.nome.isEmpty() || usuarioEditado.email.isEmpty() || usuarioEditado.telefone.isEmpty() || usuarioEditado.bio.isEmpty() || usuarioEditado.dataNascimento == null){
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }
        else {
            for (Usuario usuario : usuarios){
                if (usuarioEditado.email.equals(usuario.email) && usuarioEditado.id != usuario.id){
                    return usuarioExistente;
                }
            }
            return banco.editar(usuarioExistente, usuarioEditado);
        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }

    private double calcularIdade (LocalDate dataNascimento){
        Period anos = Period.between(dataNascimento, LocalDate.now());
        double idade = anos.getYears();
        return idade;


    }


}
