package br.com.geekcode.marcos.desafio.service;

import br.com.geekcode.marcos.desafio.dao.CidadeDao;
import br.com.geekcode.marcos.desafio.exception.NotValidIdServiceException;
import br.com.geekcode.marcos.desafio.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
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

    @Override
    public String insertAllFromCSV() {
        String caminho = "D:\\Dev\\desafio-cidades\\desafio-cidades.csv";
        BufferedReader br = null;
        String cidade = "";
        try {
            br = new BufferedReader(new FileReader(caminho));
            cidade = br.readLine();// pular o cabeçalho
            while ((cidade = br.readLine()) != null) {
                String[] arrayCidades = cidade.split(",");

                Cidade cidadeInserir = new Cidade();
                cidadeInserir.setIbgeId(Long.parseLong(arrayCidades[0]));
                cidadeInserir.setUf(arrayCidades[1]);
                cidadeInserir.setNome(arrayCidades[2]);
                cidadeInserir.setCapital(new Boolean(arrayCidades[3]));
                cidadeInserir.setLongitude(Double.parseDouble(arrayCidades[4]));
                cidadeInserir.setLatitude(Double.parseDouble(arrayCidades[5]));
                cidadeInserir.setSemAcentos(arrayCidades[6]);
                cidadeInserir.setNomeAlternativo(arrayCidades[7]);
                cidadeInserir.setMigroRegiao(arrayCidades[8]);
                cidadeInserir.setMesoRegiao(arrayCidades[9]);

                this.save(cidadeInserir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Arquivo CSV populado com sucesso!";
    }

    private Long idValido(Long ibgeId) {
        if (ibgeId <= 0) {
            throw new NotValidIdServiceException("Valor do campo ibgeId está inválido. " +
                    "Deve ser um valor inteiro maior que zero.");
        }
        return ibgeId;
    }
}
