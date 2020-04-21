package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.MusicaBanco;
import br.com.cwi.tinderevolution.dominio.Musica;
import br.com.cwi.tinderevolution.gerenciador.MusicaGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")

public class MusicaRest {

    public MusicaGerenciador musicaGerenciador = new MusicaGerenciador();
    public MusicaBanco banco = new MusicaBanco();

    @GetMapping
    public List<Musica> listarTodas() {
        return musicaGerenciador.listar();
    }

    @GetMapping("{id}")
    public Musica listarUma (@PathVariable("id") int id) {
        return musicaGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Musica editar(@PathVariable("id") int id, @RequestBody Musica musica) {
        return musicaGerenciador.editar(id, musica);
    }

    @PostMapping
    public Musica criar (@Validated @RequestBody Musica novaMusica) {
        return musicaGerenciador.salvar(novaMusica);
    }

    @DeleteMapping("{id}")
    public boolean deletar (@PathVariable("id") int id){
        return musicaGerenciador.deletar(id);
    }

}