package business;

import java.util.ArrayList;

public class Curso{
  private String nome;
  private String cargaHoraria;
  private String ementa;
  private ArrayList <Professor> professores;
  private ArrayList<Turma> turmas;

  public Curso(String nome, String cargaHoraria, String ementa){
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.ementa = ementa;
    this.turmas = new ArrayList<Turma>();
    this.professores = new ArrayList<Professor>();
  }

  /////////////// Metodos de manipulação de turmas ///////////////////
  public void adicionarTurma(Turma turma){
    this.turmas.add(turma);
  }
  public void removerTurma(Turma turma){
    this.turmas.remove(turma);
  }
  public void adicionarProfessor(Professor professor){
    this.professores.add(professor);
  }

  /////////////// Metodos getters e setters ///////////////////
  public ArrayList<Turma> getTurmas(){
    return this.turmas;
  }    

  public ArrayList<Curso> getCursos(){
    return this.cursos;
  }

  public ArrayList<Professor> getProfessores(){
    return this.professores;
  }

  // retorna o nome de um dos professores
  public Professor getProfessor(String professor){
    for (Professor prof : this.professores){
      if(prof.getNome().equals(professor)){
        return prof;
      }
    }
    return null;
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