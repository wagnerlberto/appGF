package br.com.empresa.appGF.model;

public enum ProfessorSetor {
  TECNOLOGIA("tecnologia"), RH("rh"), DIRETORIA("diretoria");

  private String value;

  private ProfessorSetor(String value) {
      this.value = value;
  }

  public String getSetor() {
      return value;
  }

}
