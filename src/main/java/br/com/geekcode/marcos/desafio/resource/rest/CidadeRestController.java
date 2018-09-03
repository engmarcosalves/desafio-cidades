package br.com.geekcode.marcos.desafio.resource.rest;

import br.com.geekcode.marcos.desafio.model.Cidade;
import br.com.geekcode.marcos.desafio.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/cidades",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class CidadeRestController {

    @Autowired
    private CidadeService service;

    @GetMapping("/carregarcsv")
    @ResponseStatus(HttpStatus.OK)
    public String cargaCSV(){
        return service.insertAllFromCSV();
    }

    @GetMapping("/capitais")
    public List<Cidade> getCapitais(){
        return service.listAllCapital(true);
    }

    @GetMapping("/estadomaiormenor")
    public ResponseEntity<String> getMaiorMenorUF(){
        List<Object[]> qtdCity = service.getQtdCidadesEstado();
        String retorno = "";
        Object[] first = qtdCity.get(0);

        long maior = (long) first[1];
        long menor = (long) first[1];

        Cidade esMaior = (Cidade)first[0];
        Cidade esMenor = (Cidade)first[0];
        for(Object[] x : qtdCity){
            Cidade estadoAtu = (Cidade)x[0];
            long atual = (long) x[1];
            //maior
            if(atual > maior){
                maior = atual;
                esMaior = estadoAtu;
            }
            //menor
            if(atual < menor){
                menor = atual;
                esMenor = estadoAtu;
            }

        }
        retorno = "O maior estado é " + esMaior.getUf() + " e o menor é " + esMenor.getUf();
        return ResponseEntity.ok(retorno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> listar() {
        return service.findAll();
    }
}
