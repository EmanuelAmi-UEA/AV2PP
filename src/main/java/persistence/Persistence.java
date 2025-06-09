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

    // recebe como parametro um objeto do tipo curso e faz um relatorio dele
    public void gerarRelatorioCurso(Curso curso, String nomeArquivo) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_curso.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DO CURSO ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");


            writer.write("Nome: " + curso.getNome() + "\n");
            writer.write("Carga Horária: " + curso.getCargaHoraria() + "\n");
            writer.write("Ementa: " + curso.getEmenta() + "\n");
            ArrayList<Professor> professores = curso.getProfessores();
            for (Professor professor : professores){
                writer.write("Professor: " + professor.getNome() + "\n");
            }
            writer.write("Número de Turmas: " + curso.getTurmas().size() + "\n");
            writer.write("------------------------\n");

        } catch (IOException e) {
                System.out.println("Erro ao gerar relatório de cursos: " + e.getMessage());
                e.printStackTrace();
            } finally {
                System.out.println("Relatório do curso gerado: " + nomeArquivo + "_curso.txt");
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

    public void gerarRelatorioPerformanceAluno(Aluno aluno, Turma turma, String nomeArquivo) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_performance_" + aluno.getNome().replace(" ", "_") + ".txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE PERFORMANCE DO ALUNO ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n\n");

            writer.write("Nome: " + aluno.getNome() + "\n");
            writer.write("Idade: " + aluno.getIdade() + "\n");
            writer.write("Matrícula: " + aluno.getMatricula() + "\n");
            writer.write("Email: " + aluno.getEmail() + "\n");
            writer.write("Turma: " + turma.getCodigo() + "\n\n");

            PerformanceReport relatorio = new PerformanceReport(aluno, turma);

            writer.write("=== DESEMPENHO ===\n");
            writer.write("Média Ponderada: " + String.format("%.2f", relatorio.calculateMediaPonderada()) + "\n");
            writer.write("Aproveitamento: " + String.format("%.2f", relatorio.calculaAproveitamento()) + "%\n\n");

            writer.write("=== DETALHES DAS AVALIAÇÕES ===\n");
            for (Assessment assessment : turma.getListaDeAvaliacoes()) {
                boolean encontrouSubmissao = false;
                for (Submission submission : assessment.getSubmissions()) {
                    if (submission.getAluno().equals(aluno)) {
                        writer.write("Avaliação: " + assessment.getTipo() + "\n");
                        writer.write("Nota: " + submission.getNota() + "/" + assessment.getNotaMaxima() + "\n");
                        writer.write("Peso: " + assessment.getPeso() + "\n");
                        writer.write("Data de Entrega: " + submission.getDataEntrega() + "\n");
                        writer.write("Comentários: " + submission.getComentarios() + "\n");
                        writer.write("------------------------\n");
                        encontrouSubmissao = true;
                        break;
                    }
                }
                if (!encontrouSubmissao) {
                    writer.write("Avaliação: " + assessment.getTipo() + " - SEM SUBMISSÃO\n");
                    writer.write("------------------------\n");
                }
            }

            System.out.println("Relatório de performance gerado: " + nomeArquivo + "_performance_" + aluno.getNome().replace(" ", "_") + ".txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de performance: " + e.getMessage());
            e.printStackTrace();
        } finally {
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

    public void gerarRelatorioPerformanceTodosAlunos(ArrayList<Aluno> alunos, Turma turma, String nomeArquivo) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(nomeArquivo + "_performance_todos_alunos.txt"), StandardCharsets.UTF_8));

            writer.write("=== RELATÓRIO DE PERFORMANCE DE TODOS OS ALUNOS ===\n");
            writer.write("Data: " + java.time.LocalDateTime.now() + "\n");
            writer.write("Turma: " + turma.getCodigo() + "\n\n");

            for (Aluno aluno : alunos) {
                PerformanceReport relatorio = new PerformanceReport(aluno, turma);

                writer.write("======================================\n");
                writer.write("ALUNO: " + aluno.getNome() + "\n");
                writer.write("======================================\n");
                writer.write("Matrícula: " + aluno.getMatricula() + "\n");
                writer.write("Email: " + aluno.getEmail() + "\n");
                writer.write("Média Ponderada: " + String.format("%.2f", relatorio.calculateMediaPonderada()) + "\n");
                writer.write("Aproveitamento: " + String.format("%.2f", relatorio.calculaAproveitamento()) + "%\n\n");

                writer.write("--- Detalhes das Avaliações ---\n");
                for (Assessment assessment : turma.getListaDeAvaliacoes()) {
                    boolean encontrouSubmissao = false;
                    for (Submission submission : assessment.getSubmissions()) {
                        if (submission.getAluno().equals(aluno)) {
                            writer.write("• " + assessment.getTipo() + ": " + submission.getNota() + "/" + assessment.getNotaMaxima() + 
                                       " (Peso: " + assessment.getPeso() + ")\n");
                            encontrouSubmissao = true;
                            break;
                        }
                    }
                    if (!encontrouSubmissao) {
                        writer.write("• " + assessment.getTipo() + ": SEM SUBMISSÃO\n");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Relatório de performance de todos os alunos gerado: " + nomeArquivo + "_performance_todos_alunos.txt");

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de performance: " + e.getMessage());
            e.printStackTrace();
        } finally {
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

}