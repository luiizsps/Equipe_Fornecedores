package br.edu.ufrb.gcet236.equipe_fornecedores;

import java.util.ArrayList;

public class ListaFornecedor {

  private ArrayList<Fornecedor> listaDeFornecedores = new ArrayList<>();
  private ArrayList<String> listaDeNomesECNPJs = new ArrayList<>();
  
  private Fornecedor fornecedor_nulo = new Fornecedor();

  public ArrayList<Fornecedor> getListaDeFornecedores() {
    return this.listaDeFornecedores;
  }

  public void addFornecedor(Fornecedor fornecedor) {
    listaDeFornecedores.add(fornecedor);
  }

  // ********** BUSCA ************ //

  // Função de busca por CNPJ
  public ArrayList<String> listNameAndCnpj() {
    for(Fornecedor fornecedor : listaDeFornecedores) {
      String nomeECNPJ = "Nome: "+fornecedor.getNome()+" CNPJ: "+fornecedor.getCnpj();
      listaDeNomesECNPJs.add(nomeECNPJ);
    }
    return listaDeNomesECNPJs;
  }


  public Fornecedor buscaPorCNPJ(String cnpj) {

    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getCnpj().replace(" ", "").equalsIgnoreCase(cnpj.replace(" ", ""))) {
        return fornecedor;
      }
    }

  return fornecedor_nulo;
  }

  // Função de busca por nome
  public Fornecedor buscaPorNome(String nome) {
    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getNome().replace(" ", "").equalsIgnoreCase(nome.replace(" ", ""))) {
        return fornecedor;
      }
    }
    return fornecedor_nulo;
  }

  // Função de busca por parte do nome
  public ArrayList<Fornecedor> buscaPorParteDoNome(String parteDoNome) {
    ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    String parteNome = parteDoNome.replace(" ", "");
    int size = parteNome.length();
    
    for(Fornecedor fornecedor : listaDeFornecedores) {
      String nome = fornecedor.getNome().replace(" ", "");
      if(nome.length() >= size) {
        String part = nome.substring(0, size);
        if(part.equalsIgnoreCase(parteNome)) {
          fornecedores.add(fornecedor);
        }
      }
    }

    return fornecedores;
  }


  // ********** REMOVER ************ //

  // Busca por cnpj e retorna posição
  public int buscaPorCNPJEPosicao(String cnpj) {
    int i=0;
    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getCnpj().replace(" ", "").equalsIgnoreCase(cnpj.replace(" ", ""))) {
        return i;
      }
      i++;
    }
    return -1;
  }
//Teste
  public void removeByIndex(int index) {
    if(index != -1) listaDeFornecedores.remove(index);
  }
}