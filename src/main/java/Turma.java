import java.util.ArrayList;

public class Turma{
  private String codigo;
  private String periodo;
  private ArrayList<Aluno> listaDeAlunos;
  private ArrayList<Assessment> listaDeAvaliacoes;

  public Turma(String codigo, String periodo){
    this.codigo = codigo;
    this.periodo = periodo;
    this.listaDeAlunos = new ArrayList<Aluno>();
    this.listaDeAvaliacoes = new ArrayList<Assessment>();
  }
  /////////// Metodos getters e setters ///////////////////
  public String getCodigo(){
    return this.codigo;
  }
  public String getPeriodo(){
    return this.periodo;
  }
  public ArrayList<Aluno> getListaDeAlunos(){
    return this.listaDeAlunos;
  }
  public void setCodigo(String codigo){
    this.codigo = codigo;
  }
  public void setPeriodo(String periodo){
    this.periodo = periodo;
  }
  public ArrayList<Assessment> getListaDeAvaliacoes(){
    return this.listaDeAvaliacoes;
  }
  ///////// Metodos de manipulação de alunos /////////
  public void adicionarAluno(Aluno aluno){
    this.listaDeAlunos.add(aluno);
  }
  public void removerAluno(Aluno aluno){
    this.listaDeAlunos.remove(aluno);
  }
  ///////// Metodos de manipulação de avaliações /////////
  public void adicionarAvaliacao(Assessment avaliacao){
    this.listaDeAvaliacoes.add(avaliacao);
  }
  public void removerAvaliacao(Assessment avaliacao){
    this.listaDeAvaliacoes.remove(avaliacao);
  }
  
  
}
