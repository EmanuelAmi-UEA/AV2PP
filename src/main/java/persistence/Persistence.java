
package persistence;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import business.*;

public class Persistence {

    public Persistence() {
    }

    public void gerarRelatorioAlunos(ArrayList<Aluno> alunos, String nomeArquivo) {
        if (alunos == null || alunos.isEmpty()) {
            System.out.println("Lista de alunos está vazia ou nula.");
            return;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_alunos.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE ALUNOS ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");

            for (Aluno aluno : alunos) {
                writer.write("Nome: " + aluno.getNome() + "\n");
                writer.write("Idade: " + aluno.getIdade() + "\n");
                writer.write("Matrícula: " + aluno.getMatricula() + "\n");
                writer.write("Email: " + aluno.getEmail() + "\n");
                writer.write("Número de Submissions: " + aluno.getSubmissions().size() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Relatório de alunos gerado: " + nomeArquivo + "_alunos.txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de alunos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            fecharWriter(writer);
        }
    }

    public void gerarRelatorioProfessores(ArrayList<Professor> professores, String nomeArquivo) {
        if (professores == null || professores.isEmpty()) {
            System.out.println("Lista de professores está vazia ou nula.");
            return;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_professores.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE PROFESSORES ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");

            for (Professor professor : professores) {
                writer.write("Nome: " + professor.getNome() + "\n");
                writer.write("Idade: " + professor.getIdade() + "\n");
                writer.write("ID: " + professor.getId() + "\n");
                writer.write("Especialidade: " + professor.getEspecilidade() + "\n");
                writer.write("Número de Cursos: " + professor.getCursos().size() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Relatório de professores gerado: " + nomeArquivo + "_professores.txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de professores: " + e.getMessage());
            e.printStackTrace();
        } finally {
            fecharWriter(writer);
        }
    }

    public void gerarRelatorioTurmas(ArrayList<Turma> turmas, String nomeArquivo) {
        if (turmas == null || turmas.isEmpty()) {
            System.out.println("Lista de turmas está vazia ou nula.");
            return;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_turmas.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE TURMAS ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");

            for (Turma turma : turmas) {
                writer.write("Código: " + turma.getCodigo() + "\n");
                writer.write("Período: " + turma.getPeriodo() + "\n");
                writer.write("Número de Alunos: " + turma.getListaDeAlunos().size() + "\n");
                writer.write("Número de Avaliações: " + turma.getListaDeAvaliacoes().size() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Relatório de turmas gerado: " + nomeArquivo + "_turmas.txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de turmas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            fecharWriter(writer);
        }
    }

    public void gerarRelatorioCursos(ArrayList<Curso> cursos, String nomeArquivo) {
        if (cursos == null || cursos.isEmpty()) {
            System.out.println("Lista de cursos está vazia ou nula.");
            return;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_cursos.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE CURSOS ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");

            for (Curso curso : cursos) {
                writer.write("Nome: " + curso.getNome() + "\n");
                writer.write("Carga Horária: " + curso.getCargaHoraria() + "\n");
                writer.write("Ementa: " + curso.getEmenta() + "\n");
                ArrayList<Professor> professores = curso.getProfessores();
                for (Professor professor : professores){
                    writer.write("Professor: " + professor.getNome() + "\n");
                }
                writer.write("Número de Turmas: " + curso.getTurmas().size() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Relatório de cursos gerado: " + nomeArquivo + "_cursos.txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de cursos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            fecharWriter(writer);
        }
    }

    public void gerarRelatorioAssessments(ArrayList<Assessment> assessments, String nomeArquivo) {
        if (assessments == null || assessments.isEmpty()) {
            System.out.println("Lista de avaliações está vazia ou nula.");
            return;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_assessments.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE AVALIAÇÕES ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");

            for (Assessment assessment : assessments) {
                writer.write("Tipo: " + assessment.getTipo() + "\n");
                writer.write("Nota Máxima: " + assessment.getNotaMaxima() + "\n");
                writer.write("Peso: " + assessment.getPeso() + "\n");
                writer.write("Turma: " + assessment.getTurma().getCodigo() + "\n");
                writer.write("Número de Submissions: " + assessment.getSubmissions().size() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Relatório de avaliações gerado: " + nomeArquivo + "_assessments.txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de avaliações: " + e.getMessage());
            e.printStackTrace();
        } finally {
            fecharWriter(writer);
        }
    }

    private void fecharWriter(BufferedWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o writer: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
