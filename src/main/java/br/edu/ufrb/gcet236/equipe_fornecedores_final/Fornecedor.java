package br.edu.ufrb.gcet236.equipe_fornecedores_final;

public class Fornecedor {
  private String cnpj;
  private String nome;
  private String endereço;
  private String telefone;
  private String email;

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
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
  
  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
