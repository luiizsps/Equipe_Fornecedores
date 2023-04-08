package br.edu.ufrb.gcet236.equipe_fornecedores.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
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
  public ArrayList<Fornecedor> getAll() { 
    return lista.getListaDeFornecedores();
  }

  @PostMapping(value = "/search/cnpj")
  public Object searchByCNPJ(@RequestBody String cnpj) {
    Object resultado = lista.buscaPorCNPJ(cnpj);

    return resultado;
  }

  @GetMapping(value = "/nameandcnpj")
  public ArrayList<String> nameAndCNPJ() {
    return lista.listNameAndCnpj();
  }

  @PostMapping(value = "/search/name")
  public Object searchByName(@RequestBody String name) {
    Object resultado = lista.buscaPorNome(name);

    return resultado;
  }

  @PostMapping(value = "/search/part")
  public ArrayList<Fornecedor> searchByPartOfName(@RequestBody String name) {
    return lista.buscaPorParteDoNome(name);
  }

 /* @DeleteMapping(value = "/remove/cnpj")
  public ArrayList<Fornecedor> deleteByCNPJ(@PathVariable String cnpj) {
    int index = lista.buscaPorCNPJEPosicao(cnpj);
    lista.removeByIndex(index);

    return lista.getListaDeFornecedores();
  }
*/
}
