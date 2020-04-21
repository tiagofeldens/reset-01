package br.com.cwi.tinderevolution.Rest;


import br.com.cwi.tinderevolution.Banco.EsporteBanco;
import br.com.cwi.tinderevolution.dominio.Esporte;
import br.com.cwi.tinderevolution.gerenciador.EsporteGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esporte")

public class EsporteRest {

    public EsporteGerenciador esporteGerenciador = new EsporteGerenciador();
    public EsporteBanco banco = new EsporteBanco();

    @GetMapping
    public List<Esporte> listarTodos() {
        return esporteGerenciador.listar();
    }

    @GetMapping("{id}")
    public Esporte listarUm(@PathVariable("id") int id) {
        return esporteGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Esporte editar(@PathVariable("id") int id, @RequestBody Esporte esporte) {
        return esporteGerenciador.editar(id, esporte);
    }

    @PostMapping
    public Esporte criar(@Validated @RequestBody Esporte novoEsporte) {
        return esporteGerenciador.salvar(novoEsporte);
    }

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") int id) {
        return esporteGerenciador.deletar(id);
    }
}

