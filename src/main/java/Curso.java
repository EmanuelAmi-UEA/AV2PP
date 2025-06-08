import java.util.ArrayList;

public class Curso{
  private String nome;
  private String cargaHoraria;
  private String ementa;
  private Professor professor;
  private ArrayList<Turma> turmas;

  public Curso(String nome, String cargaHoraria, String ementa){
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.ementa = ementa;
    this.turmas = new ArrayList<Turma>();
  }

  /////////////// Metodos de manipulação de turmas ///////////////////
  public void adicionarTurma(Turma turma){
    this.turmas.add(turma);
  }
  public void removerTurma(Turma turma){
    this.turmas.remove(turma);
  }
  
  /////////////// Metodos getters e setters ///////////////////
  public ArrayList<Turma> getTurmas(){
    return this.turmas;
  }    
  
  public Professor getProfessor() {
    return this.professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public String getNome(){
    return this.nome;
  }
  public String getCargaHoraria(){
    return this.cargaHoraria;
  }
  public String getEmenta(){
    return this.ementa;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setCargaHoraria(String cargaHoraria){
    this.cargaHoraria = cargaHoraria;
  }
  public void setEmenta(String ementa){
    this.ementa = ementa;
  }
}