package br.edu.ufrb.gcet236.equipe_fornecedores.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrb.gcet236.equipe_fornecedores.Fornecedor;
import br.edu.ufrb.gcet236.equipe_fornecedores.ListaFornecedor;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedoresController {
  ListaFornecedor lista = new ListaFornecedor();

  @PostMapping(value = "/add")
  public void setFornecedor(@RequestBody Fornecedor fornecedor) {
    lista.addFornecedor(fornecedor);
  }
  
  @GetMapping(value = "/all")
  public ArrayList<Fornecedor> getall() { 
    return lista.getListaDeFornecedores();
  }
}
