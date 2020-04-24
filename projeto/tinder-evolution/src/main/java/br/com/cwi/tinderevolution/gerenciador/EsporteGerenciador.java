package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.EsporteBanco;
import br.com.cwi.tinderevolution.dominio.Esporte;

import java.time.LocalDate;
import java.util.List;

public class EsporteGerenciador {


    public EsporteBanco banco = new EsporteBanco();

    public Esporte salvar(Esporte esporte) {
        List<Esporte> esportes = banco.listar();

        if (esporte.getNome().isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Esporte esporteExistente : esportes) {
            if (esporte.getNome().equals(esporteExistente.getNome())) {
                return esporteExistente;
            }
        }
        return banco.salvar(esporte);
    }

    public List<Esporte> listar() {
        return banco.listar();
    }

    public Esporte procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Esporte editar(int id, Esporte esporteAtualizado) {
        List<Esporte> esportes = banco.listar();
        Esporte esporteExistente = procurar(id);
        if (esporteExistente == null) {
            return null;
        }

        if (esporteAtualizado.getNome().isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Esporte esporte : esportes) {
                if (esporteAtualizado.getNome().equals(esporte.getNome()) && esporteAtualizado.getId() != esporte.getId()) {
                    return esporteExistente;
                }
            }
            return banco.editar(esporteExistente, esporteAtualizado);

        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }
}
