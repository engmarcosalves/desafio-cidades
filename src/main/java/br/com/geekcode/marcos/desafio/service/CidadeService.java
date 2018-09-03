package br.com.geekcode.marcos.desafio.service;

import br.com.geekcode.marcos.desafio.model.Cidade;

import java.util.List;

public interface CidadeService {

    void save(Cidade cidade);

    void update(Long ibgeId, Cidade cidade);

    void delete(Long ibgeId);

    Cidade findById(Long ibgeId);

    List<Cidade> findAll();

    String insertAllFromCSV();

    List<Cidade> listAllCapital(boolean isCapital);

    List<Object[]> getQtdCidadesEstado();
}
