package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBanco {


    int contador = 1;
    final List<Usuario> usuarios = new ArrayList<>();

    public Usuario salvar(Usuario usuario) {
        usuario.setId(contador++);
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario editar(Usuario usuarioExistente, Usuario usuarioEditado) {
        usuarioExistente.setNome(usuarioEditado.getNome());
        usuarioExistente.setEmail(usuarioEditado.getEmail());
        usuarioExistente.setTelefone(usuarioEditado.getTelefone());
        usuarioExistente.setDataNascimento(usuarioEditado.getDataNascimento());
        usuarioExistente.setBio(usuarioEditado.getBio());
        usuarioExistente.setLatitude( usuarioEditado.getLatitude());;
        usuarioExistente.setLongitude(usuarioEditado.getLongitude());
        return usuarioExistente;
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario procurar(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
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
