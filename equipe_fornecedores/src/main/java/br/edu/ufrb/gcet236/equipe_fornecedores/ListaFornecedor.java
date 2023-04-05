package br.edu.ufrb.gcet236.equipe_fornecedores;

import java.util.ArrayList;

public class ListaFornecedor {

  private ArrayList<Fornecedor> listaDeFornecedores = new ArrayList<>();
  private Fornecedor fornecedor_nulo = new Fornecedor();

  public ArrayList<Fornecedor> getListaDeFornecedores() {
    return this.listaDeFornecedores;
  }

public void addFornecedor(Fornecedor fornecedor) {
  listaDeFornecedores.add(fornecedor);
}
  // ********** BUSCA ************ //

  // Função de busca por CNPJ
  public Fornecedor buscaPorCNPJ(String cnpj) {

    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getCnpj().equalsIgnoreCase(cnpj)) {
        return fornecedor;
      }
    }

  return fornecedor_nulo;
  }

  // Função de busca por nome
  public Fornecedor buscaPorNome(String nome) {

    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getNome() == nome) {
        return fornecedor;
      }
    }

    return fornecedor_nulo;
  }

  // Função de busca por parte do nome
  public ArrayList<Fornecedor> buscaPorParteDoNome(String parteDoNome) {
    ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    int size = parteDoNome.length();

    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getNome().substring(0, size) == parteDoNome) {
        fornecedores.add(fornecedor);
      }
    }

    return fornecedores;
  }

}