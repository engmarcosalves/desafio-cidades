package br.com.geekcode.marcos.desafio.dao;

import br.com.geekcode.marcos.desafio.exception.NotExistDaoException;
import br.com.geekcode.marcos.desafio.model.Cidade;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CidadeDaoImpl implements CidadeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Cidade cidade) {
        entityManager.persist(cidade);
    }

    @Override
    public void update(Cidade cidade) {
        entityManager.merge(cidade);
    }

    @Override
    public void delete(Long ibgeId) {
        try {
            entityManager.remove(entityManager.getReference(Cidade.class, ibgeId));
        } catch (EntityNotFoundException ex) {
            throw new NotExistDaoException("Cidade não encontrada para o ibgeId = " + ibgeId + ".");
        }
    }

    @Override
    public Cidade findById(Long ibgeId) {
        Cidade cidade = entityManager.find(Cidade.class, ibgeId);

        if (cidade == null) {
            throw new NotExistDaoException("Cidade não encontrada para o ibgeID = " + ibgeId + ".");
        }

        return cidade;
    }

    @Override
    public List<Cidade> findAll() {
        return entityManager.createQuery("select c from Cidade c", Cidade.class)
                .getResultList();
    }

    @Override
    public List<Cidade> findByCapitalOrderByNomeAsc(boolean capital) {
        return entityManager.createQuery("select c from Cidade c where c.capital = " + capital + " order by c.nome", Cidade.class)
                .getResultList();
    }
}
