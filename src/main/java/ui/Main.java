
package ui;

import java.util.ArrayList;
import business.*;
import persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestão Acadêmica ===");
        
        // Criar instância da classe de persistência
        Persistence relatorio = new Persistence();
        
        // Criar dados de exemplo
        ArrayList<Aluno> alunos = criarAlunosExemplo();
        ArrayList<Professor> professores = criarProfessoresExemplo();
        ArrayList<Curso> cursos = criarCursosExemplo(professores);
        ArrayList<Turma> turmas = criarTurmasExemplo(alunos);
        ArrayList<Assessment> assessments = criarAssessmentsExemplo(turmas, alunos);
        
        // Gerar relatórios usando a classe de persistência
        System.out.println("\nGerando relatórios...");
        
        relatorio.gerarRelatorioAlunos(alunos, "relatorio_exemplo");
        relatorio.gerarRelatorioProfessores(professores, "relatorio_exemplo");
        relatorio.gerarRelatorioCursos(cursos, "relatorio_exemplo");
        relatorio.gerarRelatorioTurmas(turmas, "relatorio_exemplo");
        relatorio.gerarRelatorioAssessments(assessments, "relatorio_exemplo");
        
        System.out.println("\nTodos os relatórios foram gerados com sucesso!");
    }
    
    private static ArrayList<Aluno> criarAlunosExemplo() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("João Silva", 20, "2021001", "joao.silva@email.com"));
        alunos.add(new Aluno("Maria Santos", 19, "2021002", "maria.santos@email.com"));
        alunos.add(new Aluno("Pedro Oliveira", 21, "2021003", "pedro.oliveira@email.com"));
        return alunos;
    }
    
    private static ArrayList<Professor> criarProfessoresExemplo() {
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor("Dr. Carlos Mendes", 45, "Programação", "PROF001"));
        professores.add(new Professor("Dra. Ana Costa", 38, "Matemática", "PROF002"));
        return professores;
    }
    
    private static ArrayList<Curso> criarCursosExemplo(ArrayList<Professor> professores) {
        ArrayList<Curso> cursos = new ArrayList<>();
        
        Curso curso1 = new Curso("Programação Java", "60 horas", "Introdução à programação orientada a objetos");
        curso1.setProfessor(professores.get(0));
        professores.get(0).adicionarCurso(curso1);
        
        Curso curso2 = new Curso("Cálculo I", "80 horas", "Fundamentos de cálculo diferencial e integral");
        curso2.setProfessor(professores.get(1));
        professores.get(1).adicionarCurso(curso2);
        
        cursos.add(curso1);
        cursos.add(curso2);
        return cursos;
    }
    
    private static ArrayList<Turma> criarTurmasExemplo(ArrayList<Aluno> alunos) {
        ArrayList<Turma> turmas = new ArrayList<>();
        
        Turma turma1 = new Turma("JAVA2024.1", "2024.1");
        turma1.adicionarAluno(alunos.get(0));
        turma1.adicionarAluno(alunos.get(1));
        
        Turma turma2 = new Turma("CALC2024.1", "2024.1");
        turma2.adicionarAluno(alunos.get(1));
        turma2.adicionarAluno(alunos.get(2));
        
        turmas.add(turma1);
        turmas.add(turma2);
        return turmas;
    }
    
    private static ArrayList<Assessment> criarAssessmentsExemplo(ArrayList<Turma> turmas, ArrayList<Aluno> alunos) {
        ArrayList<Assessment> assessments = new ArrayList<>();
        
        // Avaliação para turma de Java
        Assessment prova1 = new Assessment("Prova", 10.0, 0.7, turmas.get(0));
        Assessment trabalho1 = new Assessment("Trabalho", 10.0, 0.3, turmas.get(0));
        
        // Avaliação para turma de Cálculo
        Assessment prova2 = new Assessment("Prova", 10.0, 0.8, turmas.get(1));
        Assessment lista1 = new Assessment("Lista de Exercícios", 10.0, 0.2, turmas.get(1));
        
        // Adicionar avaliações às turmas
        turmas.get(0).adicionarAvaliacao(prova1);
        turmas.get(0).adicionarAvaliacao(trabalho1);
        turmas.get(1).adicionarAvaliacao(prova2);
        turmas.get(1).adicionarAvaliacao(lista1);
        
        // Criar algumas submissions de exemplo
        new Submission(alunos.get(0), prova1, 8.5, "2024-03-15", "Boa prova");
        new Submission(alunos.get(0), trabalho1, 9.0, "2024-03-20", "Excelente trabalho");
        new Submission(alunos.get(1), prova1, 7.5, "2024-03-15", "Prova regular");
        new Submission(alunos.get(1), prova2, 8.0, "2024-03-18", "Boa performance");
        
        assessments.add(prova1);
        assessments.add(trabalho1);
        assessments.add(prova2);
        assessments.add(lista1);
        
        return assessments;
    }
}
