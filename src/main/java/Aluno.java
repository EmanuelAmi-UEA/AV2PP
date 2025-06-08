import java.util.ArrayList;

public class Aluno extends Pessoa{
	private String matricula;
	private String email;
	private ArrayList<Submission> submissions;
	
	
	public Aluno(String nome, int idade, String matricula, String email) {
		super(nome, idade);
	    this.matricula = matricula;
	    this.email = email;
	    this.submissions = new ArrayList<Submission>();
	}
	
/////////////// Metodos getters e setters ///////////////////
	  public String getMatricula(){
	    return this.matricula;
	  }
	  public String getEmail(){
		  return this.email;
	  }
	  public void setetMatricula(String matricula){
	    this.matricula = matricula;
	  }
	  public void setEmail(String email){
	    this.email = email;
	  }
	  public ArrayList<Submission> getSubmissions() {
	    return this.submissions;
	  }

	  /////////////// Metodos de manipulação de submissions ///////////////////
	  public void addSubmission(Submission submission){
	    this.submissions.add(submission);
	  }
	  public void removeSubmission(Submission submission){
	    this.submissions.remove(submission);
	  }

	  // Método para limpar todas as submissions ao deletar o aluno
	  public void deleteAluno() {

	    for (Submission submission : new ArrayList<Submission>(this.submissions)) {
	      Assessment assessment = submission.getAssessment();
	      // Remove submission da lista de assessment
	      assessment.getSubmissions().remove(submission);
	    }
	    // Limpa a lista de submissions do aluno
	    this.submissions.clear();
	  }

}
