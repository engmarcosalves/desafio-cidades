package br.com.geekcode.marcos.desafio.service.impl;

import br.com.geekcode.marcos.desafio.dao.CidadeDao;
import br.com.geekcode.marcos.desafio.model.Cidade;
import br.com.geekcode.marcos.desafio.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeDao cidadeDao;

    @Override
    public void save(Cidade cidade) {
        
    }

    @Override
    public void update(Long ibgeId, Cidade cidade) {

    }

    @Override
    public void delete(Long ibgeId) {

    }

    @Override
    public Cidade findById(Long ibgeId) {
        return null;
    }

    @Override
    public List<Cidade> findAll() {
        return null;
    }
}
