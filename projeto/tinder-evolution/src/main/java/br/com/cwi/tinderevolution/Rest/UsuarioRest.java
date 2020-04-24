package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.UsuarioBanco;
import br.com.cwi.tinderevolution.dominio.*;
import br.com.cwi.tinderevolution.gerenciador.UsuarioGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioRest {

    public UsuarioGerenciador usuarioGerenciador = new UsuarioGerenciador();
    public UsuarioBanco banco = new UsuarioBanco();

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioGerenciador.listar();
    }

    @GetMapping("{id}")
    public Usuario listarUm(@PathVariable("id") int id) {
        return usuarioGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Usuario editar(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        return usuarioGerenciador.editar(id, usuario);
    }

    @PostMapping
    public Usuario criar(@Validated @RequestBody Usuario novoUsuario) {
        return usuarioGerenciador.salvar(novoUsuario);
    }

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") int id) {
        return usuarioGerenciador.deletar(id);
    }


    //LIKE E DISLIKE
    //Like e Dislike de Musica
    @PostMapping("/{idUsuario}/likes/musicas/{idMusica}")
    public void curtirMusica(@PathVariable("idMusica") int idMusica, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.curtirMusica(id, idMusica);
    }

    @DeleteMapping("/{idUsuario}/likes/musicas/{idMusica}")
    public void descurtirMusica(@PathVariable("idMusica") int idMusica, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.descurtirMusica(id, idMusica);
    }

    //Like e Dislike de Filme
    @PostMapping("/{idUsuario}/likes/filmes/{idFilme}")
    public void curtirFilme(@PathVariable("idFilme") int idFilme, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.curtirFilme(id, idFilme);
    }

    @DeleteMapping("/{idUsuario}/likes/filmes/{idFilme}")
    public void descurtirFilme(@PathVariable("idFilme") int idFilme, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.descurtirFilme(id, idFilme);
    }

    //Like e Dislike de Serie
    @PostMapping("/{idUsuario}/likes/series/{idSerie}")
    public void curtirSerie(@PathVariable("idSerie") int idSerie, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.curtirSerie(id, idSerie);
    }

    @DeleteMapping("/{idUsuario}/likes/series/{idSerie}")
    public void descurtirSerie(@PathVariable("idSerie") int idSerie, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.descurtirSerie(id, idSerie);
    }

    //Like e Dislike de Jogo
    @PostMapping("/{idUsuario}/likes/jogos/{idJogo}")
    public void curtirJogo(@PathVariable("idJogo") int idJogo, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.curtirJogo(id, idJogo);
    }

    @DeleteMapping("/{idUsuario}/likes/jogos/{idJogo}")
    public void descurtirJogo(@PathVariable("idJogo") int idJogo, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.descurtirJogo(id, idJogo);
    }

    //Like e Dislike de Esporte
    @PostMapping("/{idUsuario}/likes/esportes/{idEsporte}")
    public void curtirEsporte(@PathVariable("idEsporte") int idEsporte, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.curtirEsporte(id, idEsporte);
    }

    @DeleteMapping("/{idUsuario}/likes/esportes/{idEsporte}")
    public void descurtirEsporte(@PathVariable("idEsporte") int idEsporte, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.descurtirEsporte(id, idEsporte);
    }

    //Like e Dislike de Usuário
    @PostMapping("/{idUsuario}/likes/usuarios/{idUsuarioCurtido}")
    public void curtirUsuario (@PathVariable("idUsuarioCurtido") int idUsuarioCurtido, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.curtirUsuario(id, idUsuarioCurtido);
    }

    @DeleteMapping("/{idUsuario}/likes/usuarios/{idUsuarioDescurtido}")
    public void descurtirUsuario (@PathVariable("idUsuarioDescurtido") int idUsuarioDescurtido, @PathVariable("idUsuario") int id) {
        usuarioGerenciador.descurtirUsuario(id, idUsuarioDescurtido);
    }

    //LISTAR
    //Listar Curtidas

    @GetMapping("/{idUsuario}/likes/musicas")
    public List<Integer> listarMusicasCurtidas (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarMusicasCurtidas(id);
    }

    @GetMapping("/{idUsuario}/likes/filmes")
    public List<Integer> listarFilmesCurtidos (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarFilmesCurtidos(id);
    }

    @GetMapping("/{idUsuario}/likes/series")
    public List<Integer> listarSeriesCurtidas (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarSeriesCurtidas(id);
    }

    @GetMapping("/{idUsuario}/likes/jogos")
    public List<Integer> listarJogosCurtidas (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarJogosCurtidos(id);
    }

    @GetMapping("/{idUsuario}/likes/esportes")
    public List<Integer> listarEsportesCurtidos (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarEsportesCurtidos(id);
    }


    //Definir e Listar Curiosidades
    @PostMapping("/{idUsuario}/curiosidades")
    public void definirCuriosidade(@PathVariable("idUsuario") int id, @RequestBody Curiosidade curiosidade) {
        usuarioGerenciador.definirCuriosidade(id, curiosidade);
    }

    @GetMapping("/{idUsuario}/curiosidades")
    public List<Curiosidade> listarCuriosidades (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarCuriosidades(id);
    }

    //Listar Matches
    @GetMapping("/{idUsuario}/matches")
    public List<Integer> listarMatches (@PathVariable("idUsuario") int id) {
        return usuarioGerenciador.listarMatches(id);
    }



}