package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.MusicaBanco;
import br.com.cwi.tinderevolution.dominio.Musica;
import br.com.cwi.tinderevolution.gerenciador.MusicaGerenciador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")

public class MusicaRest {

    public MusicaGerenciador musicaGerenciador = new MusicaGerenciador();
    public MusicaBanco banco = new MusicaBanco();

    @GetMapping
    public List<Musica> listar() {
        return banco.listar();
    }

    @GetMapping ("{id}")
    public Musica one (@PathVariable ("id") int id){
        return musicaGerenciador.procurar(id);
    }


    @de
    @PutMapping ("{id}")
    public Musica editar(@PathVariable ("id")int id)


}
