package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Esporte;

import java.util.ArrayList;
import java.util.List;

public class EsporteBanco {

    int contador = 1;
    final List<Esporte> esportes = new ArrayList<>();

    public Esporte salvar(Esporte esporte) {
        esporte.id = contador++;
        esportes.add(esporte);
        return esporte;
    }

    public Esporte editar(Esporte esporteExistente, Esporte esporteEditado) {
        esporteExistente.nome = esporteEditado.nome;
        return esporteExistente;
    }

    public List<Esporte> listar() {
        return esportes;
    }

    public Esporte procurar(int id) {
        for (Esporte esporte : esportes) {
            if (esporte.id == id) {
                return esporte;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Esporte esporteParaDeletar = procurar(id);
        if (esporteParaDeletar != null) {
            return esportes.remove(esporteParaDeletar);
        }
        return false;


    }
}
