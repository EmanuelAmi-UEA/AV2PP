
import java.util.ArrayList;
import java.util.List;

public class Assessment {
    private String tipo;
    private double notaMaxima;
    private double peso;
    private Turma turma;
    private List<Assessment> assessments;
    private List<Submission> submissions;

    public Assessment(String tipo, double notaMaxima, double peso, Turma turma) {
        this.tipo = tipo;
        this.notaMaxima = notaMaxima;
        this.peso = peso;
        this.turma = turma;
        this.submissions = new ArrayList<Submission>();
    }

    public String getTipo() { 
        return this.tipo; 
    }
    public double getNotaMaxima() { 
        return this.notaMaxima; 
    }
    public double getPeso() { 
        return this.peso; 
    }
    public Turma getTurma() { 
        return this.turma; 
    }

    public List<Submission> getSubmissions() {
        return this.submissions;
    }

    public void addSubmission(Submission submission) {
        this.submissions.add(submission);
    }

    public void removeSubmission(Submission submission) {
        this.submissions.remove(submission);
    }    
    
    public void addAssessment(Assessment assessment){
        this.assessments.add(assessment);
    }

    public List<Assessment> getAssassment(){
        return this.assessments;
    }
}
