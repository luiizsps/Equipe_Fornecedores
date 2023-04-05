package br.edu.ufrb.gcet236.teste;

public class Fornecedor {
  private long cnpj;
  private String nome;
  private String endereço;
  private long telefone;
  private String email;

  public long getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(long cnpj) {
    this.cnpj = cnpj;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereço() {
    return this.endereço;
  }

  public void setEndereço(String endereço) {
    this.endereço = endereço;
  }
  
  public long getTelefone() {
    return this.telefone;
  }

  public void setTelefone(long telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
