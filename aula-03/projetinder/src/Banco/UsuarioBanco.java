package Banco;

import dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBanco {


    int contador = 1;
    final List<Usuario> usuarios = new ArrayList<>();

    public Usuario salvar(Usuario usuario) {
        usuario.id = contador++;
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario editar(Usuario usuarioExistente, Usuario usuarioEditado) {
        usuarioExistente.nome = usuarioEditado.nome;
        usuarioExistente.email = usuarioEditado.email;
        usuarioExistente.telefone = usuarioEditado.telefone;
        usuarioExistente.dataNascimento = usuarioEditado.dataNascimento;
        usuarioExistente.bio = usuarioEditado.bio;
        usuarioExistente.localizacao = usuarioEditado.localizacao;
        return usuarioExistente;
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario procurar(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.id == id) {
                return usuario;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Usuario usuarioParaDeletar = procurar(id);
        if (usuarioParaDeletar != null) {
            return usuarios.remove(usuarioParaDeletar);
        }
        return false;


    }
}
