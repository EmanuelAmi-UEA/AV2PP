
public class PerformanceReport {
    private Aluno aluno;
    private Turma turma;

    public PerformanceReport(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    public double calculateMediaPonderada() {
        double totalNotas = 0.0;
        double totalPesos = 0.0;

        for (Submission submission : aluno.getSubmissions()) {
            Assessment a = submission.getAssessment();
            if (a.getTurma().equals(turma)) {
                totalNotas += submission.getNota() * a.getPeso();
                totalPesos += a.getPeso();
            }
        }
        return totalPesos == 0 ? 0 : totalNotas / totalPesos;
    }

    public double calculaAproveitamento() {
        double totalGanho = 0.0;
        double totalPossivel = 0.0;

        for (Submission submission : aluno.getSubmissions()) {
            Assessment a = submission.getAssessment();
            if (a.getTurma().equals(turma)) {
                totalGanho += submission.getNota() * a.getPeso();
                totalPossivel += a.getNotaMaxima() * a.getPeso();
            }
        }
        return totalPossivel == 0 ? 0 : (totalGanho / totalPossivel) * 100;
    }
}
