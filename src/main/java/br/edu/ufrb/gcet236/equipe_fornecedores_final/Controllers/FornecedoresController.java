package br.edu.ufrb.gcet236.equipe_fornecedores_final.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrb.gcet236.equipe_fornecedores_final.Fornecedor;
import br.edu.ufrb.gcet236.equipe_fornecedores_final.ListaFornecedor;

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
  public Object searchByCNPJ(@PathVariable String cnpj) {
    Object resultado = lista.buscaPorCNPJ(cnpj);

    return resultado;
  }

  @GetMapping(value = "/search/name:{name}")
  public Object searchByName(@PathVariable String name) {
    Object resultado = lista.buscaPorNome(name);

    return resultado;
  }

  @GetMapping(value = "/search/part:{name}")
  public ArrayList<Fornecedor> searchByPartOfName(@PathVariable String name) {
    return lista.buscaPorParteDoNome(name);
  }

  @GetMapping(value = "/nameandcnpj")
  public ArrayList<String> nameAndCNPJ() {
    return lista.listNameAndCnpj();
  }

  @DeleteMapping(value = "/remove/cnpj:{cnpj}")
  public Object deleteByCNPJ(@PathVariable String cnpj) {
    Object fornecedor = lista.buscaPorCNPJ(cnpj);
    lista.removeporCnpj(cnpj);

    return fornecedor;
  }

  @DeleteMapping(value = "/remove/nome:{nome}")
  public Fornecedor deleteByName(@PathVariable String nome) {
    Fornecedor fornecedor_removido = lista.removePorNome(nome);

    return fornecedor_removido;
  }

  @PutMapping(value = "/update/cnpj:{cnpj}")
  public void atualizarFornecedorPorCNPJ(@PathVariable String cnpj, @RequestBody Fornecedor fornecedor) {
    lista.updatePorCnpj(cnpj, fornecedor);
  }

  @PutMapping(value = "/update/nome:{nome}")
  public void atualizarFornecedorPorNome(@PathVariable String nome, @RequestBody Fornecedor fornecedor) {
    lista.updatePorNome(nome, fornecedor);
  }
}