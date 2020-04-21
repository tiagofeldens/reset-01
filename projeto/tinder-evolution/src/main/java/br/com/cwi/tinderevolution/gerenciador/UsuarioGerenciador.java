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


    public Usuario salvar (Usuario usuario){
        List<Usuario> usuarios = banco.listar();

        if (usuario.nome.isEmpty() || usuario.email.isEmpty() || usuario.telefone.isEmpty() || usuario.longitude == null|| usuario.latitude == null || usuario.bio.isEmpty()|| usuario.dataNascimento == null){
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

        if (usuarioEditado.nome.isEmpty() || usuarioEditado.email.isEmpty() || usuarioEditado.telefone.isEmpty() ||usuarioEditado.longitude == null|| usuarioEditado.latitude == null || usuarioEditado.bio.isEmpty() || usuarioEditado.dataNascimento == null){
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


    public void curtirMusica (int id, int idMusica){
        Usuario usuario = procurar(id);
        Musica musica = musicaGerenciador.procurar(idMusica);
        usuario.musicasCurtidas.add(musica);
    }

    public void descurtirMusica (int id, int idMusica){
        Usuario usuario = procurar(id);
        Musica musica = musicaGerenciador.procurar(idMusica);
        usuario.musicasCurtidas.remove(musica);
    }

    public void curtirFilme (int id, int idFilme){
        Usuario usuario = procurar(id);
        Filme filme = filmeGerenciador.procurar(idFilme);
        usuario.filmesCurtidos.add(filme);
    }

    public void descurtirFilme (int id, int idFilme){
        Usuario usuario = procurar(id);
        Filme filme = filmeGerenciador.procurar(idFilme);
        usuario.filmesCurtidos.remove(filme);
    }

    public void curtirSerie (int id, int idSerie){
        Usuario usuario = procurar(id);
        Serie serie = serieGerenciador.procurar(idSerie);
        usuario.seriesCurtidas.add(serie);
    }

    public void descurtirSerie (int id, int idSerie){
        Usuario usuario = procurar(id);
        Serie serie = serieGerenciador.procurar(idSerie);
        usuario.seriesCurtidas.remove(serie);
    }

    public void curtirJogo (int id, int idJogo){
        Usuario usuario = procurar(id);
        Jogo jogo = jogoGerenciador.procurar(idJogo);
        usuario.jogosCurtidos.add(jogo);
    }

    public void descurtirJogo (int id, int idJogo){
        Usuario usuario = procurar(id);
        Jogo jogo = jogoGerenciador.procurar(idJogo);
        usuario.jogosCurtidos.remove(jogo);
    }

    public void curtirEsporte (int id, int idEsporte){
        Usuario usuario = procurar(id);
        Esporte esporte = esporteGerenciador.procurar(idEsporte);
        usuario.esportesCurtidos.add(esporte);
    }

    public void descurtirEsporte (int id, int idEsporte){
        Usuario usuario = procurar(id);
        Esporte esporte = esporteGerenciador.procurar(idEsporte);
        usuario.esportesCurtidos.remove(esporte);
    }

    // public void definirCuriosidade

    public List<Musica> listarMusicasCurtidas (int id){
        Usuario usuario = procurar(id);
        return usuario.musicasCurtidas;
    }

    public List<Filme> listarFilmesCurtidos (int id){
        Usuario usuario = procurar(id);
        return usuario.filmesCurtidos;
    }

    public List<Serie>  listarSeriesCurtidas (int id){
        Usuario usuario = procurar(id);
        return usuario.seriesCurtidas;
    }

    public List<Jogo> listarJogosCurtidos (int id){
        Usuario usuario = procurar(id);
        return usuario.jogosCurtidos;
    }

    public List<Esporte> listarEsportesCurtidos (int id){
        Usuario usuario = procurar(id);
        return usuario.esportesCurtidos;
    }

    public List<Curiosidade> listarCuriosidades (int id){
        Usuario usuario = procurar(id);
        return usuario.curiosidades;
    }

}



