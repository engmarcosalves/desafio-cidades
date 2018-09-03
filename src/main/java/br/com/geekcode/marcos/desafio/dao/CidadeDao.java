package br.com.geekcode.marcos.desafio.dao;

import br.com.geekcode.marcos.desafio.model.Cidade;

import java.util.List;

public interface CidadeDao {

    void save(Cidade cidade);

    void update(Cidade cidade);

    void delete(Long ibgeId);

    Cidade findById(Long ibgeId);

    List<Cidade> findAll();

    List<Cidade> findByCapitalOrderByNomeAsc(boolean capital);
}
