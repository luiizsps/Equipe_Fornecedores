package br.edu.ufrb.gcet236.equipe_fornecedores.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ArrayList<Fornecedor> getAll() { 
    return lista.getListaDeFornecedores();
  }

  @GetMapping(value = "/search/cnpj:{cnpj}")
  public Fornecedor searchByCNPJ(@PathVariable String cnpj) {
    Fornecedor resultado = lista.buscaPorCNPJ(cnpj);

    return resultado;
  }

  @GetMapping(value = "/nameandcnpj")
  public ArrayList<String> nameAndCNPJ() {
    return lista.listNameAndCnpj();
  }

  @GetMapping(value = "/search/name:{name}")
  public Fornecedor searchByName(@PathVariable String name) {
    Fornecedor resultado = lista.buscaPorNome(name);

    return resultado;
  }

  @GetMapping(value = "/search/part:{name}")
  public ArrayList<Fornecedor> searchByPartOfName(@PathVariable String name) {
    return lista.buscaPorParteDoNome(name);
  }

  @DeleteMapping(value = "/remove/cnpj:{cnpj}")
  public ArrayList<Fornecedor> deleteByCNPJ(@PathVariable String cnpj) {
    int index = lista.buscaPorCNPJEPosicao(cnpj);
    lista.removeByIndex(index);

    return lista.getListaDeFornecedores();
  }
}
