package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.CuriosidadeBanco;
import br.com.cwi.tinderevolution.dominio.Curiosidade;
import br.com.cwi.tinderevolution.gerenciador.CuriosidadeGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curiosidade")

public class CuriosidadeRest {

    public CuriosidadeGerenciador curiosidadeGerenciador = new CuriosidadeGerenciador();
    public CuriosidadeBanco banco = new CuriosidadeBanco();

    @GetMapping
    public List<Curiosidade> listarTodas() {
        return curiosidadeGerenciador.listar();
    }

    @GetMapping("{id}")
    public Curiosidade listarUma(@PathVariable("id") int id) {
        return curiosidadeGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Curiosidade editar(@PathVariable("id") int id, @RequestBody Curiosidade curiosidade) {
        return curiosidadeGerenciador.editar(id, curiosidade);
    }

    @PostMapping
    public Curiosidade criar(@Validated @RequestBody Curiosidade novaCuriosidade) {
        return curiosidadeGerenciador.salvar(novaCuriosidade);
    }

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") int id) {
        return curiosidadeGerenciador.deletar(id);
    }
}
