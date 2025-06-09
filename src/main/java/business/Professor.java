package business;

import java.util.ArrayList;

public class Professor extends Pessoa {
	private String especilidade;
	private String id;
	private ArrayList<Curso> cursos;

	public Professor(String nome, int idade, String especilidade, String id){
	    super(nome, idade);
	    this.especilidade = especilidade;
	    this.id = id;
	    this.cursos = new ArrayList<Curso>();

	}

	public void adicionarCurso(Curso curso) {
	    this.cursos.add(curso);
	  }

	  public void removerCurso(Curso curso) {
	    this.cursos.remove(curso);
	    curso.adicionarCurso(null);
	  }

	  /////////////// metodos getters e setters ///////////////////
	  public ArrayList<Curso> getCursos() {
	    return this.cursos;
	  }

	  // Método para compatibilidade com código existente
	  public ArrayList<Professor> getProfessores() {
	    ArrayList<Professor> lista = new ArrayList<>();
	    lista.add(this);
	    return lista;
	  }


	  public String getEspecilidade(){
	    return this.especilidade;
	  }
	  public String getId(){
	    return this.id;
	  }

	  public void setEspecilidade(String especilidade){
	    this.especilidade = especilidade;
	  }
	  public void setId(String id){
	    this.id = id;
	  }
}