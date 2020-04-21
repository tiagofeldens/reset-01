package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.SerieBanco;
import br.com.cwi.tinderevolution.dominio.Serie;
import br.com.cwi.tinderevolution.gerenciador.SerieGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")

public class SerieRest {

    public SerieGerenciador serieGerenciador = new SerieGerenciador();
    public SerieBanco banco = new SerieBanco();

    @GetMapping
    public List<Serie> listarTodas() {
        return serieGerenciador.listar();
    }

    @GetMapping("{id}")
    public Serie listarUma(@PathVariable("id") int id) {
        return serieGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Serie editar(@PathVariable("id") int id, @RequestBody Serie serie) {
        return serieGerenciador.editar(id, serie);
    }

    @PostMapping
    public Serie criar(@Validated @RequestBody Serie novaSerie) {
        return serieGerenciador.salvar(novaSerie);
    }

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") int id) {
        return serieGerenciador.deletar(id);
    }
}

