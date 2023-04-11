package br.edu.ufrb.gcet236.equipe_fornecedores_final;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListaFornecedor {

  private ArrayList<Fornecedor> listaDeFornecedores = new ArrayList<>();
  private ArrayList<String> listaDeNomesECNPJs = new ArrayList<>();
  private static String FORNECEDOR_NAO_ENCONTRADO = "O fornecedor procurado não se encontra no banco de dados";

  public ArrayList<Fornecedor> getListaDeFornecedores() {
    return this.listaDeFornecedores;
  }
// Adiciona o fornecedor caso ele já não se encontre na lista
  public void addFornecedor(Fornecedor fornecedor) {
    if(!pertenceALista(fornecedor)) listaDeFornecedores.add(fornecedor);
  }
//Compara se o cnpj do fornecedor encontra-se na lista
  public boolean pertenceALista(Fornecedor fornecedor) {
    for(Fornecedor fornecedor_aux : listaDeFornecedores) {
      if(compareStrings(fornecedor_aux.getCnpj(), fornecedor.getCnpj())) return true;
    }

    return false;
  }

  // ********** BUSCA ************ //

  //Busca por Nome e Cnpj
  public ArrayList<String> listNameAndCnpj() {
    listaDeNomesECNPJs.clear();
    for(Fornecedor fornecedor : listaDeFornecedores) {
      String nomeECNPJ = "Nome: "+fornecedor.getNome()+"; CNPJ: "+fornecedor.getCnpj();
      listaDeNomesECNPJs.add(nomeECNPJ);
    }

    return listaDeNomesECNPJs;
  }

  // Função de busca por CNPJ
  public Object buscaPorCNPJ(String cnpj) {

    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(compareStrings(fornecedor.getCnpj(), cnpj)) {
        return fornecedor;
      }
    }

    return FORNECEDOR_NAO_ENCONTRADO;
  }

  // Função de busca por nome
  public Object buscaPorNome(String nome) {
    for(Fornecedor fornecedor : listaDeFornecedores) {
      if(compareStrings(fornecedor.getNome(), nome)) {
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
 
  public Fornecedor removeporCnpj(String cnpj) {
    ListIterator<Fornecedor> it = listaDeFornecedores.listIterator();
    Fornecedor fornecedor_removido = new Fornecedor();

    while(it.hasNext()) {
      Fornecedor fornecedor = it.next();
      fornecedor_removido = fornecedor;
      if(compareStrings(fornecedor.getCnpj(), cnpj)) {
        it.remove();
        break;
      }
    }

    return fornecedor_removido;
  }

  // Função de remoção por nome
  public Fornecedor removePorNome(String nome) {
    ListIterator<Fornecedor> it = listaDeFornecedores.listIterator();
    Fornecedor fornecedor_removido = new Fornecedor();

    while(it.hasNext()) {
      Fornecedor fornecedor = it.next();
      fornecedor_removido = fornecedor;
      if(compareStrings(fornecedor.getNome(), nome)) {
        it.remove();
        break;
      }
    }

    return fornecedor_removido;
  }

  // ********** ATUALIZAR ************ //

  //atualização por cnpj
  public void updatePorCnpj(String cnpj, Fornecedor novoFornecedor){
    ListIterator<Fornecedor> it = listaDeFornecedores.listIterator();

    while(it.hasNext()) {
      Fornecedor fornecedor = it.next();
      if(compareStrings(fornecedor.getCnpj(), cnpj)) {
        it.set(novoFornecedor);
      }
    }
  }
//atualização por nome
  public void updatePorNome(String nome, Fornecedor novoFornecedor){
    ListIterator<Fornecedor> it = listaDeFornecedores.listIterator();

    while(it.hasNext()) {
      Fornecedor fornecedor = it.next();
      if(compareStrings(fornecedor.getNome(), nome)){
        it.set(novoFornecedor);
      }
    }
  }

  // ********** REUTILIZAVEIS ************ //

  public boolean compareStrings(String string1, String string2) {
    return string1.replace(" ", "").equalsIgnoreCase(string2.replace(" ",""));
  }
}