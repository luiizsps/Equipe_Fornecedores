package br.edu.ufrb.gcet236.equipe_fornecedores;
import java.util.ArrayList;

public class ListaFornecedor {

  private ArrayList<Fornecedor> listaDeFornecedores = new ArrayList<>();
  private ArrayList<String> listaDeNomesECNPJs = new ArrayList<>();
  private static String FORNECEDOR_NAO_ENCONTRADO = "O fornecedor procurado não se encontra no banco de dados";

  public ArrayList<Fornecedor> getListaDeFornecedores() {
    return this.listaDeFornecedores;
  }

  public void addFornecedor(Fornecedor fornecedor) {
    listaDeFornecedores.add(fornecedor);
  }

  // ********** BUSCA ************ //

  // Função de busca por CNPJ
  public ArrayList<String> listNameAndCnpj() {
    listaDeNomesECNPJs.clear();
    for(Fornecedor fornecedor : listaDeFornecedores) {
      String nomeECNPJ = "Nome: "+fornecedor.getNome()+" CNPJ: "+fornecedor.getCnpj();
      listaDeNomesECNPJs.add(nomeECNPJ);
    }
    return listaDeNomesECNPJs;
  }


  public Object buscaPorCNPJ(String cnpj) {

    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getCnpj().replace(" ", "").equalsIgnoreCase(cnpj.replace(" ", ""))) {
        return fornecedor;
      }
    }

  return FORNECEDOR_NAO_ENCONTRADO;
  }

  // Função de busca por nome
  public Object buscaPorNome(String nome) {
    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(fornecedor.getNome().replace(" ", "").equalsIgnoreCase(nome.replace(" ", ""))) {
        return fornecedor;
      }
    }
    return FORNECEDOR_NAO_ENCONTRADO;
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

  // Remoção por CNPJ sem retorno
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
  /* 
  public void removeporCnpj(String cnpj) {
    ListInterator<Fornecedor> it = listaDeFornecedores.listInterator();
    while(it.hasnext()){
      Fornecedor fornecedor = it.next();
      if(fornecedor.getCnpj().replace(" ", " ").equalsIgnoreCase(cnpj.replace(" ", " "))){
        it.remove();
      }
    }
  }
    */
    //Solicitar o CNPJ
  } 