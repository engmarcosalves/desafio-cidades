package br.com.geekcode.marcos.desafio.service;

import br.com.geekcode.marcos.desafio.dao.CidadeDao;
import br.com.geekcode.marcos.desafio.exception.NotValidIdServiceException;
import br.com.geekcode.marcos.desafio.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeDao cidadeDao;

    @Override
    public void save(Cidade cidade) {
        cidadeDao.save(cidade);
    }

    @Override
    public void update(Long ibgeId, Cidade cidade) {
        cidade.setIbgeId(idValido(ibgeId));
        cidadeDao.findById(ibgeId);
        cidadeDao.update(cidade);
    }


    @Override
    public void delete(Long ibgeId) {
        cidadeDao.delete(idValido(ibgeId));
    }

    @Override
    @Transactional(readOnly = true)
    public Cidade findById(Long ibgeId) {
        return cidadeDao.findById(idValido(ibgeId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cidade> findAll() {
        return cidadeDao.findAll();
    }

    private Long idValido(Long ibgeId) {
        if (ibgeId <= 0) {
            throw new NotValidIdServiceException("Valor do campo ibgeId está inválido. " +
                    "Deve ser um valor inteiro maior que zero.");
        }
        return ibgeId;
    }
}
