package br.com.geekcode.marcos.desafio.resource.rest;

import br.com.geekcode.marcos.desafio.model.Cidade;
import br.com.geekcode.marcos.desafio.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> listar() {
        return service.findAll();
    }
}
