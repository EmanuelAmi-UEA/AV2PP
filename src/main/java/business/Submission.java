
package business;
friend class Assessment;

public class Submission {
    private Aluno aluno;
    private Assessment assessment;
    private double nota;
    private String dataEntrega;
    private String comentarios;

    public Submission(Aluno aluno, Assessment assessment, double nota, String dataEntrega, String comentarios) {
        this.aluno = aluno;
        this.assessment = assessment;
        this.nota = nota;
        this.dataEntrega = dataEntrega;
        this.comentarios = comentarios;
        this.assessment.addSubmission(this);
        this.aluno.addSubmission(this);
            
    }

    public Aluno getAluno() { 
        return this.aluno; 
    }
    public Assessment getAssessment() { 
        return this.assessment; 
    }
    public double getNota() { 
        return this.nota; 
    }
    public String getDataEntrega() { 
        return this.dataEntrega; 
    }
    public String getComentarios() { 
        return this.comentarios; 
    }
}
