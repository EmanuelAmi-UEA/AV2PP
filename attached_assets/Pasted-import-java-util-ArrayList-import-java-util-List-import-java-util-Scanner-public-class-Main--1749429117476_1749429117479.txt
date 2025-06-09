import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // criar scanner  
    Scanner scanner = new Scanner(System.in);

    // Criar Professor
    Professor professor = new Professor("Dr. Silva", "Ciência da Computação", "PROF001");
    Professor professor2 = new Professor("Me. Souza", "Licenciatura da Computação", "PROF002");

    // Criar Curso
    Curso curso = new Curso("Programação Java", "60h", "POO, Collections, Exception Handling");
    Curso curso2 = new Curso("Algoritmos e Estruturas de Dados", "60h", "Estruturas de Dados, Algoritmos de Ordenação");

    // Associar Professor ao Curso
    professor.adicionarCurso(curso);
    professor2.adicionarCurso(curso2);

    // Criar Turmas
    Turma turma1 = new Turma("T1-2025", "2025.1");
    Turma turma2 = new Turma("T2-2025", "2025.1");

    // Adicionar Turmas ao Curso
    curso.adicionarTurma(turma1);
    curso2.adicionarTurma(turma2);

    // Criar e adicionar alunos à Turma 1
    turma1.adicionarAluno(new Aluno("João Silva", "2023001", "joao@email.com"));
    turma1.adicionarAluno(new Aluno("Maria Santos", "2023002", "maria@email.com"));
    turma1.adicionarAluno(new Aluno("Pedro Costa", "2023003", "pedro@email.com"));
    turma1.adicionarAluno(new Aluno("Ana Oliveira", "2023004", "ana@email.com"));
    turma1.adicionarAluno(new Aluno("Lucas Pereira", "2023005", "lucas@email.com"));
    turma1.adicionarAluno(new Aluno("Carlos Souza", "2023006", "carlos@email.com"));
    turma1.adicionarAluno(new Aluno("Julia Lima", "2023007", "julia@email.com"));

    // Criar e adicionar alunos à Turma 2
    turma2.adicionarAluno(new Aluno("Carlos Souza", "2023006", "carlos@email.com")); // repetido
    turma2.adicionarAluno(new Aluno("Julia Lima", "2023007", "julia@email.com")); // repetido
    turma2.adicionarAluno(new Aluno("Rafael Martins", "2023008", "rafael@email.com")); 
    turma2.adicionarAluno(new Aluno("Beatriz Alves", "2023009", "beatriz@email.com")); 
    turma2.adicionarAluno(new Aluno("Gabriel Santos", "2023010", "gabriel@email.com")); 
    turma2.adicionarAluno(new Aluno("Ana Oliveira", "2023004", "ana@email.com")); // repetido
    turma2.adicionarAluno(new Aluno("Lucas Pereira", "2023005", "lucas@email.com")); // repetido


    // criar avaliações

    Assessment av1Turma1 = new Assessment("Prova 1", 10.0, 0.4, turma1);
    Assessment av2Turma1 = new Assessment("Prova 2", 10.0, 0.6, turma1);
    Assessment av3Turma1 = new Assessment("prova 3", 10.0, 1.0, turma1);
    Assessment av1Turma2 = new Assessment("Teste", 5.0, 0.3, turma2);
    Assessment av2Turma2 = new Assessment("Trabalho Prático", 10.0, 0.7, turma2);
    Assessment av3Turma2 = new Assessment("Projeto", 10.0, 0.5, turma2);

    // adicionar avaliações
    turma1.adicionarAvaliacao(av1Turma1);
    turma1.adicionarAvaliacao(av2Turma1);
    turma1.adicionarAvaliacao(av3Turma1);
    turma2.adicionarAvaliacao(av1Turma2);
    turma2.adicionarAvaliacao(av2Turma2);
    turma2.adicionarAvaliacao(av3Turma2);

    // criar submissions Turma 1
    new Submission(turma1.getListaDeAlunos().get(0), av1Turma1, 8.5, "2025-05-01", "Parabens!");
    turma1.getListaDeAlunos().get(0).addSubmission(new Submission(turma1.getListaDeAlunos().get(0), av2Turma1, 9.0, "2025-05-15", "Parabens!")); 
    turma1.getListaDeAlunos().get(0).addSubmission(new Submission(turma1.getListaDeAlunos().get(0), av3Turma1, 7.5, "2025-05-30", "Parabens!"));
    turma1.getListaDeAlunos().get(1).addSubmission(new Submission(turma1.getListaDeAlunos().get(1), av1Turma1, 6.0, "2025-05-01", "Parabens!"));
    turma1.getListaDeAlunos().get(1).addSubmission(new Submission(turma1.getListaDeAlunos().get(1), av2Turma1, 7.5, "2025-05-15", "Parabens!"));
    turma1.getListaDeAlunos().get(1).addSubmission(new Submission(turma1.getListaDeAlunos().get(1), av3Turma1, 8.0, "2025-05-30", "Parabens!"));
    turma1.getListaDeAlunos().get(2).addSubmission(new Submission(turma1.getListaDeAlunos().get(2), av1Turma1, 9.5, "2025-05-01", "Parabens!"));
    turma1.getListaDeAlunos().get(2).addSubmission(new Submission(turma1.getListaDeAlunos().get(2), av2Turma1, 8.0, "2025-05-15", "Parabens!"));
    turma1.getListaDeAlunos().get(2).addSubmission(new Submission(turma1.getListaDeAlunos().get(2), av3Turma1, 9.0, "2025-05-30", "Parabens!"));
    turma1.getListaDeAlunos().get(3).addSubmission(new Submission(turma1.getListaDeAlunos().get(3), av1Turma1, 7.0, "2025-05-01", "Parabens!"));
    turma1.getListaDeAlunos().get(3).addSubmission(new Submission(turma1.getListaDeAlunos().get(3), av2Turma1, 8.5, "2025-05-15", "Parabens!"));
    turma1.getListaDeAlunos().get(3).addSubmission(new Submission(turma1.getListaDeAlunos().get(3), av3Turma1, 8.5, "2025-05-30", "Parabens!"));
    turma1.getListaDeAlunos().get(4).addSubmission(new Submission(turma1.getListaDeAlunos().get(4), av1Turma1, 8.0, "2025-05-01", "Parabens!"));
    turma1.getListaDeAlunos().get(4).addSubmission(new Submission(turma1.getListaDeAlunos().get(4), av2Turma1, 9.0, "2025-05-15", "Parabens!"));
    turma1.getListaDeAlunos().get(4).addSubmission(new Submission(turma1.getListaDeAlunos().get(4), av3Turma1, 8.0, "2025-05-30", "Parabens!"));

    //criar submissions Turma 2
    turma2.getListaDeAlunos().get(0).addSubmission(new Submission(turma2.getListaDeAlunos().get(0), av1Turma2, 4.5, "2025-05-01", "Parabens!"));
    turma2.getListaDeAlunos().get(0).addSubmission(new Submission(turma2.getListaDeAlunos().get(0), av2Turma2, 9.0, "2025-05-15", "Parabens!"));
    turma2.getListaDeAlunos().get(0).addSubmission(new Submission(turma2.getListaDeAlunos().get(0), av3Turma2, 8.5, "2025-05-30", "Parabens!"));
    turma2.getListaDeAlunos().get(1).addSubmission(new Submission(turma2.getListaDeAlunos().get(1), av1Turma2, 3.0, "2025-05-01", "Parabens!"));
    turma2.getListaDeAlunos().get(1).addSubmission(new Submission(turma2.getListaDeAlunos().get(1), av2Turma2, 7.5, "2025-05-15", "Parabens!"));
    turma2.getListaDeAlunos().get(1).addSubmission(new Submission(turma2.getListaDeAlunos().get(1), av3Turma2, 8.0, "2025-05-30", "Parabens!"));
    turma2.getListaDeAlunos().get(2).addSubmission(new Submission(turma2.getListaDeAlunos().get(2), av1Turma2, 4.5, "2025-05-01", "Parabens!"));
    turma2.getListaDeAlunos().get(2).addSubmission(new Submission(turma2.getListaDeAlunos().get(2), av2Turma2, 8.0, "2025-05-15", "Parabens!"));
    turma2.getListaDeAlunos().get(2).addSubmission(new Submission(turma2.getListaDeAlunos().get(2), av3Turma2, 9.0, "2025-05-30", "Parabens!"));
    turma2.getListaDeAlunos().get(3).addSubmission(new Submission(turma2.getListaDeAlunos().get(3), av1Turma2, 4.0, "2025-05-01", "Parabens!"));
    turma2.getListaDeAlunos().get(3).addSubmission(new Submission(turma2.getListaDeAlunos().get(3), av2Turma2, 8.5, "2025-05-15", "Parabens!"));
    turma2.getListaDeAlunos().get(3).addSubmission(new Submission(turma2.getListaDeAlunos().get(3), av3Turma2, 8.5, "2025-05-30", "Parabens!"));
    turma2.getListaDeAlunos().get(4).addSubmission(new Submission(turma2.getListaDeAlunos().get(4), av1Turma2, 4.0, "2025-05-01", "Parabens!"));
    turma2.getListaDeAlunos().get(4).addSubmission(new Submission(turma2.getListaDeAlunos().get(4), av2Turma2, 9.0, "2025-05-15", "Parabens!"));
    turma2.getListaDeAlunos().get(4).addSubmission(new Submission(turma2.getListaDeAlunos().get(4), av3Turma2, 8.0, "2025-05-30", "Parabens!"));


    ///Escolha de curso
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha um curso:");
            System.out.println("1 - " + curso.getNome());
            System.out.println("2 - " + curso2.getNome());
            System.out.println("0 - Sair");
            System.out.print("Digite o número do curso: ");

            int escolhaCurso = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do Scanner

            if (escolhaCurso == 0) {
                System.out.println("Programa encerrado.");
                continuar = false;
                continue;
            }

            if (escolhaCurso < 1 || escolhaCurso > 2) {
                System.out.println("Curso inválido.");
                continue;
            }

        Curso cursoEscolhido = (escolhaCurso == 1) ? curso : curso2;

        // Menu de opções
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Exibir informações dos Professores");
        System.out.println("2 - Exibir informações das Turmas");
        System.out.println("3 - Exibir Submissões de uma Turma");
        System.out.println("4 - Exibir Relatório de Desempenho de um Aluno");
        System.out.println("5 - Deletar Aluno");

        int escolhaMenu = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer do Scanner

        // Switch para cada opção
        switch (escolhaMenu) {
            case 1:
                // Exibir informações dos professores
                System.out.println("\nInformações do Professor da turma: " + cursoEscolhido.getNome());
                System.out.println("Professor: " + cursoEscolhido.getProfessor().getNome());
                break;
            case 2:
                // Exibir informações das turmas
                System.out.println("\nInformações da turma: " + cursoEscolhido.getNome());
                System.out.println("Professor: " + cursoEscolhido.getProfessor().getNome());
                for (Turma turma : cursoEscolhido.getTurmas()){
                    System.out.println("Turma: " + turma.getCodigo());
                    System.out.println("Período: " + turma.getPeriodo());
                    System.out.println("Alunos:");
                    for (Aluno aluno : turma.getListaDeAlunos()) {
                        System.out.println("- " + aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ")");
                    }
                System.out.println("Avaliações:");
                for (Assessment avaliacao : turma.getListaDeAvaliacoes()){
                    System.out.println("- " + avaliacao.getTipo() + " (Peso: " + avaliacao.getPeso()  + ")");
                }
                }
                break;
            case 3:
                // Exibir submissões de uma turma
                System.out.println("\nSubmissões da turma: " + cursoEscolhido.getNome());
                for (Assessment a : cursoEscolhido.getTurmas().get(0).getListaDeAvaliacoes()) {
                    System.out.println("\nAvaliação: " + a.getTipo());
                    List<Submission> submissions = a.getSubmissions();
                    if (submissions.isEmpty()) {
                        System.out.println("  Nenhuma submissao registrada.");
                    } else {
                        for (Submission s : submissions) {
                            System.out.println("  Aluno: " + s.getAluno().getNome() +
                                    " | Nota: " + s.getNota() +
                                    " | Entrega: " + s.getDataEntrega() +
                                    " | Comentários: " + s.getComentarios());
                            
                        }
                    }
                }
                break;
            case 4:
                System.out.println("\nDigite o nome do aluno:");
                String nomeAluno = scanner.nextLine();

                boolean achou = false;
                Turma turmaAtual = cursoEscolhido.getTurmas().get(0);

                for (Aluno aluno : turmaAtual.getListaDeAlunos()) {
                    if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                        PerformanceReport relatorio = new PerformanceReport(aluno, turmaAtual);

                        System.out.println("\nRelatório de desempenho para " + aluno.getNome() + 
                                         " na turma " + turmaAtual.getCodigo());

                        for (Assessment a : turmaAtual.getListaDeAvaliacoes()) {
                            for (Submission s : a.getSubmissions()) {
                                if (s.getAluno().equals(aluno)) {
                                    System.out.println("- " + a.getTipo() + ": " + 
                                                     s.getNota() + "/" + a.getNotaMaxima());
                                }
                            }
                        }

                        System.out.println("Média ponderada: " + relatorio.calculateMediaPonderada());
                        System.out.printf("Aproveitamento: %.2f%%\n", relatorio.calculaAproveitamento());
                        achou = true;
                        break;
                    }
                }

                if (!achou) {
                    System.out.println("Aluno não encontrado ou sem submissões.");
                }
                break;
            case 5:
                System.out.println("Deletar aluno");
                System.out.println("Digite o nome do aluno:");
                String nomeAlunoDeletar = scanner.nextLine();
                for (Turma turma : cursoEscolhido.getTurmas()){
                    for (Aluno aluno : turma.getListaDeAlunos()) {
                        if (aluno.getNome().equalsIgnoreCase(nomeAlunoDeletar)) {
                            aluno.deleteAluno();
                            turma.removerAluno(aluno);
                            System.out.println("Aluno deletado com sucesso.");
                            break;
                        }
                    }
                }
                break;

          default:
              System.out.println("Opção inválida.");
              break;
      }
    }
    scanner.close();
    }
}
  

