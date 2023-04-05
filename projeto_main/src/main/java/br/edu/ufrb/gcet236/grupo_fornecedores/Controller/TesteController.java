package br.edu.ufrb.gcet236.teste.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufrb.gcet236.teste.Fornecedor;
import br.edu.ufrb.gcet236.teste.ListaFornecedor;

@RestController
@RequestMapping(value = "/fornecedores")
public class TesteController {

  ListaFornecedor lista = new ListaFornecedor();

  @PostMapping(value = "/add")
  public void setFornecedor(@RequestBody Fornecedor fornecedor) {
    lista.addFornecedor(fornecedor);
  }
  
  @GetMapping
  public ArrayList<Fornecedor> getall() { 
    return lista.getListaDeFornecedores();
  }
}