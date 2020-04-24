package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.UsuarioBanco;
import br.com.cwi.tinderevolution.Banco.MusicaBanco;
import br.com.cwi.tinderevolution.dominio.*;
import br.com.cwi.tinderevolution.gerenciador.MusicaGerenciador;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


public class UsuarioGerenciador {

    private UsuarioBanco banco = new UsuarioBanco();
    private MusicaGerenciador musicaGerenciador = new MusicaGerenciador();
    private FilmeGerenciador filmeGerenciador = new FilmeGerenciador();
    private SerieGerenciador serieGerenciador = new SerieGerenciador();
    private JogoGerenciador jogoGerenciador = new JogoGerenciador();
    private EsporteGerenciador esporteGerenciador = new EsporteGerenciador();
    private CuriosidadeGerenciador curiosidadeGerenciador = new CuriosidadeGerenciador();


    public Usuario salvar(Usuario usuario) {
        List<Usuario> usuarios = banco.listar();

        if (usuario.getNome().isEmpty() || usuario.getEmail().isEmpty() || usuario.getTelefone().isEmpty() || usuario.getLongitude() == null || usuario.getLatitude() == null || usuario.getBio().isEmpty() || usuario.getDataNascimento() == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Usuario usuarioExistente : usuarios) {
            if (usuario.getEmail().equals(usuarioExistente.getEmail())) {
                return usuarioExistente;

            }
        }
        if (calcularIdade(usuario.getDataNascimento()) < 18) {
            System.out.println("Usuário deve ter idade igual ou superior a 18 anos.");
            return null;
        }

        return banco.salvar(usuario);
    }

    public List<Usuario> listar() {
        return banco.listar();
    }

    public Usuario procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Usuario editar(int id, Usuario usuarioEditado) {
        List<Usuario> usuarios = banco.listar();
        Usuario usuarioExistente = procurar(id);
        if (usuarioExistente == null) {
            return null;
        }

        if (usuarioEditado.getNome().isEmpty() || usuarioEditado.getEmail().isEmpty() || usuarioEditado.getTelefone().isEmpty() || usuarioEditado.getLongitude() == null || usuarioEditado.getLatitude() == null || usuarioEditado.getBio().isEmpty() || usuarioEditado.getDataNascimento() == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Usuario usuario : usuarios) {
                if (usuarioEditado.getEmail().equals(usuario.getEmail()) && usuarioEditado.getId() != usuario.getId()) {
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

    private double calcularIdade(LocalDate dataNascimento) {
        Period anos = Period.between(dataNascimento, LocalDate.now());
        double idade = anos.getYears();
        return idade;


    }


    public void curtirMusica(int id, int idMusica) {
        Usuario usuario = procurar(id);
        usuario.musicasCurtidas.add(idMusica);
    }

    public void descurtirMusica(int id, int idMusica) {
        Usuario usuario = procurar(id);
        usuario.musicasCurtidas.removeIf(i -> i == idMusica);
    }

    public void curtirFilme(int id, int idFilme) {
        Usuario usuario = procurar(id);
        usuario.filmesCurtidos.add(idFilme);
    }

    public void descurtirFilme(int id, int idFilme) {
        Usuario usuario = procurar(id);
        usuario.filmesCurtidos.removeIf(i -> i == idFilme);
    }

    public void curtirSerie(int id, int idSerie) {
        Usuario usuario = procurar(id);
        usuario.seriesCurtidas.add(idSerie);
    }

    public void descurtirSerie(int id, int idSerie) {
        Usuario usuario = procurar(id);
        usuario.seriesCurtidas.removeIf(i -> i == idSerie);
    }

    public void curtirJogo(int id, int idJogo) {
        Usuario usuario = procurar(id);
        usuario.jogosCurtidos.add(idJogo);
    }

    public void descurtirJogo(int id, int idJogo) {
        Usuario usuario = procurar(id);
        usuario.jogosCurtidos.removeIf(i -> i == idJogo);
    }

    public void curtirEsporte(int id, int idEsporte) {
        Usuario usuario = procurar(id);
        usuario.esportesCurtidos.add(idEsporte);
    }

    public void descurtirEsporte(int id, int idEsporte) {
        Usuario usuario = procurar(id);
        usuario.esportesCurtidos.removeIf(i -> i == idEsporte);
    }

    public void definirCuriosidade(int id, Curiosidade novaCuriosidade) {
        Usuario usuario = procurar(id);
        Curiosidade curiosidade = curiosidadeGerenciador.salvar(novaCuriosidade);
        usuario.curiosidades.add(curiosidade);
    }

    public List<Integer> listarMusicasCurtidas(int id) {
        Usuario usuario = procurar(id);
        return usuario.musicasCurtidas;
    }

    public List<Integer> listarFilmesCurtidos(int id) {
        Usuario usuario = procurar(id);
        return usuario.filmesCurtidos;
    }

    public List<Integer> listarSeriesCurtidas(int id) {
        Usuario usuario = procurar(id);
        return usuario.seriesCurtidas;
    }

    public List<Integer> listarJogosCurtidos(int id) {
        Usuario usuario = procurar(id);
        return usuario.jogosCurtidos;
    }

    public List<Integer> listarEsportesCurtidos(int id) {
        Usuario usuario = procurar(id);
        return usuario.esportesCurtidos;
    }

    public List<Curiosidade> listarCuriosidades(int id) {
        Usuario usuario = procurar(id);
        return usuario.curiosidades;
    }


    //MATCH

    public void curtirUsuario(int id, int idUsuarioCurtido) {
        Usuario usuario = procurar(id);
        Usuario usuarioCurtido = this.procurar(idUsuarioCurtido);
        usuario.usuariosCurtidos.add(usuarioCurtido.getId());

        for (int pessoa : usuarioCurtido.usuariosCurtidos){
            if (pessoa == usuario.getId()){
                usuario.matches.add(usuarioCurtido.getId());
                usuarioCurtido.matches.add(usuario.getId());
            }
        }
    }

    public void descurtirUsuario(int id, int idUsuarioDescurtido) {
        Usuario usuario = procurar(id);
        Usuario usuarioCurtido = this.procurar(idUsuarioDescurtido);

        usuario.usuariosCurtidos.removeIf(i -> i == usuarioCurtido.getId());

        usuarioCurtido.matches.removeIf(i -> i == usuario.getId());
        usuario.matches.removeIf(i -> i == usuarioCurtido.getId());
    }

    public List<Integer> listarMatches(int id) {
        Usuario usuario = procurar(id);
        return usuario.matches;
    }
}



