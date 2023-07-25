package br.com.empresa.appGF.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nome;
  private String email;
  private String cargo;
  private BigDecimal salario;

  @Enumerated(EnumType.STRING)
  private ProfessorSetor setor;

  public void setSetor(ProfessorSetor setor) {
    this.setor = setor;
  }

  public Professor() {
  }

  public Professor(int id, String nome, String email, String cargo, BigDecimal salario, ProfessorSetor setor) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.cargo = cargo;
    this.salario = salario;
    this.setor = setor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public ProfessorSetor getSetor() {
    return setor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Professor other = (Professor) obj;
    return id == other.id;
  }

}