package ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.*;
import persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    // criar scanner  
    Scanner scanner = new Scanner(System.in);

    // Criar Professor
    Professor professor = new Professor("Dr. Silva",50, "Ciência da Computação", "PROF001");
    Professor professor2 = new Professor("Me. Souza",50, "Licenciatura da Computação", "PROF002");
    Professor professor3 = new Professor("Pe. Souza",50, "Licenciatura da Computação", "PROF002");    

    // Criar Curso
    Curso curso = new Curso("Programação Java", "60h", "POO, Collections, Exception Handling");
    Curso curso2 = new Curso("Algoritmos e Estruturas de Dados", "60h", "Estruturas de Dados, Algoritmos de Ordenação");

    // Associar Professor ao Curso
    professor.adicionarCurso(curso);
    curso.adicionarProfessor(professor);
    professor2.adicionarCurso(curso2); 
    curso2.adicionarProfessor(professor2);
    professor3.adicionarCurso(curso);
    curso.adicionarProfessor(professor3);

    // Criar Turmas
    Turma turma1 = new Turma("T1-2025", "2025.1");
    Turma turma2 = new Turma("T2-2025", "2025.1");

    // Adicionar Turmas ao Curso
    curso.adicionarTurma(turma1);
    curso2.adicionarTurma(turma2);

    // Criar e adicionar alunos à Turma 1
    turma1.adicionarAluno(new Aluno("João Silva",20, "2023001", "joao@email.com"));
    turma1.adicionarAluno(new Aluno("Maria Santos",20, "2023002", "maria@email.com"));
    turma1.adicionarAluno(new Aluno("Pedro Costa",20, "2023003", "pedro@email.com"));
    turma1.adicionarAluno(new Aluno("Ana Oliveira",20, "2023004", "ana@email.com"));
    turma1.adicionarAluno(new Aluno("Lucas Pereira",20, "2023005", "lucas@email.com"));
    turma1.adicionarAluno(new Aluno("Carlos Souza",20, "2023006", "carlos@email.com"));
    turma1.adicionarAluno(new Aluno("Julia Lima",20, "2023007", "julia@email.com"));

    // Criar e adicionar alunos à Turma 2
    turma2.adicionarAluno(new Aluno("Carlos Souza",21, "2023006", "carlos@email.com")); // repetido
    turma2.adicionarAluno(new Aluno("Julia Lima",21, "2023007", "julia@email.com")); // repetido
    turma2.adicionarAluno(new Aluno("Rafael Martins",21, "2023008", "rafael@email.com")); 
    turma2.adicionarAluno(new Aluno("Beatriz Alves",21, "2023009", "beatriz@email.com")); 
    turma2.adicionarAluno(new Aluno("Gabriel Santos",21, "2023010", "gabriel@email.com")); 
    turma2.adicionarAluno(new Aluno("Ana Oliveira",21, "2023004", "ana@email.com")); // repetido
    turma2.adicionarAluno(new Aluno("Lucas Pereira",21, "2023005", "lucas@email.com")); // repetido


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

        ArrayList<Professor> professores = cursoEscolhido.getProfessores();

        // Menu de opções
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Exibir informações dos Professores");
        System.out.println("2 - Exibir informações das Turmas");
        System.out.println("3 - Exibir Submissões de uma Turma");
        System.out.println("4 - Exibir Relatório de Desempenho de um Aluno");
        System.out.println("5 - Gerar arquivo de relatório");
        System.out.println("6 - Adicionar Aluno");
        System.out.println("7 - Adicionar Professor");
        System.out.println("8 - Adicionar Turma");
        System.out.println("9 - Adicionar Avaliação");
        System.out.println("10 - Adicionar Submission");
        System.out.println("11 - Deletar Aluno");

        int escolhaMenu = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer do Scanner

        // Switch para cada opção
        switch (escolhaMenu) {
            case 1:
                // Exibir informações dos professores
                if (professores.isEmpty()) {
                    System.out.println("Nenhum professor encontrado para este curso.");
                    break;
                }
                
                // Se há apenas um professor, mostra diretamente
                if (professores.size() == 1) {
                    Professor prof = professores.get(0);
                    System.out.println("\n=== INFORMAÇÕES DO PROFESSOR ===");
                    System.out.println("Curso: " + cursoEscolhido.getNome());
                    System.out.println("Professor: " + prof.getNome());
                    System.out.println("Idade: " + prof.getIdade());
                    System.out.println("ID: " + prof.getId());
                    System.out.println("Especialidade: " + prof.getEspecilidade());
                    break;
                }
                
                // Se há múltiplos professores, mostra lista para seleção
                System.out.println("\nProfessores do curso " + cursoEscolhido.getNome() + ":");
                for (int i = 0; i < professores.size(); i++) {
                    System.out.println((i + 1) + " - " + professores.get(i).getNome());
                }
                System.out.print("Selecione o professor (número): ");
                
                int escolhaProfessor = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                if (escolhaProfessor >= 1 && escolhaProfessor <= professores.size()) {
                    Professor profSelecionado = professores.get(escolhaProfessor - 1);
                    System.out.println("\n=== INFORMAÇÕES DO PROFESSOR ===");
                    System.out.println("Curso: " + cursoEscolhido.getNome());
                    System.out.println("Professor: " + profSelecionado.getNome());
                    System.out.println("Idade: " + profSelecionado.getIdade());
                    System.out.println("ID: " + profSelecionado.getId());
                    System.out.println("Especialidade: " + profSelecionado.getEspecilidade());
                    System.out.println("Outros cursos do professor:");
                    for (Curso c : profSelecionado.getCursos()) {
                        if (!c.getNome().equals(cursoEscolhido.getNome())) {
                            System.out.println("  - " + c.getNome());
                        }
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 2:
                // Exibir informações das turmas
                System.out.println("\nInformações da turma: " + cursoEscolhido.getNome());
                if (professores.size()==1){
                    System.out.println("Professor: " + professores.get(0).getNome());
                } else{
                    for (Professor prof : professores){
                        System.out.println("Professor: " + prof.getNome());
                    }
                }
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
                System.out.println("\nEscolha uma turma para ver as submissões:");
                for (int i = 0; i < cursoEscolhido.getTurmas().size(); i++){
                    System.out.println((i + 1) + " - " + cursoEscolhido.getTurmas().get(i).getCodigo());
                }
                int escolhaTurma = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                Turma turmaEscolhida = cursoEscolhido.getTurmas().get(escolhaTurma - 1);
                System.out.println("\nSubmissões da turma: " + turmaEscolhida.getCodigo());
                for (Assessment a : turmaEscolhida.getListaDeAvaliacoes()) {
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
                System.out.println("Você quer gerar o relatório de qual entidade?");
                System.out.println("1 - Alunos");
                System.out.println("2 - Professores");
                System.out.println("3 - Turmas");
                System.out.println("4 - Curso");
                System.out.println("5 - Avaliações");
                int escolhaRelatorio = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer do Scanner
                Persistence persistence = new Persistence();
                switch (escolhaRelatorio){
                    case 1:
                        System.out.println("Escolha uma opção:");
                        System.out.println("1 - Relatório individual de um aluno");
                        System.out.println("2 - Relatório de todos os alunos");
                        int opcaoAluno = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer
                        
                        switch (opcaoAluno) {
                            case 1:
                                // Mostrar lista de alunos da primeira turma do curso escolhido
                                Turma turmaSelecionada = cursoEscolhido.getTurmas().get(0);
                                ArrayList<Aluno> alunosTurma = turmaSelecionada.getListaDeAlunos();
                                
                                if (alunosTurma.isEmpty()) {
                                    System.out.println("Nenhum aluno encontrado na turma.");
                                    break;
                                }
                                
                                System.out.println("\nAlunos da turma " + turmaSelecionada.getCodigo() + ":");
                                for (int i = 0; i < alunosTurma.size(); i++) {
                                    System.out.println((i + 1) + " - " + alunosTurma.get(i).getNome() + 
                                                     " (Matrícula: " + alunosTurma.get(i).getMatricula() + ")");
                                }
                                
                                System.out.print("Selecione o aluno (número): ");
                                int escolhaAlunoIndividual = scanner.nextInt();
                                scanner.nextLine(); // Limpar buffer
                                
                                if (escolhaAlunoIndividual >= 1 && escolhaAlunoIndividual <= alunosTurma.size()) {
                                    Aluno alunoSelecionado = alunosTurma.get(escolhaAlunoIndividual - 1);
                                    persistence.gerarRelatorioPerformanceAluno(alunoSelecionado, turmaSelecionada, cursoEscolhido.getNome());
                                } else {
                                    System.out.println("Opção inválida.");
                                }
                                break;
                                
                            case 2:
                                // Relatório de performance de todos os alunos
                                Turma turmaTodos = cursoEscolhido.getTurmas().get(0);
                                persistence.gerarRelatorioPerformanceTodosAlunos(turmaTodos.getListaDeAlunos(), turmaTodos, cursoEscolhido.getNome());
                                break;
                            
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;
                    case 2:
                        persistence.gerarRelatorioProfessores(cursoEscolhido.getProfessores(), cursoEscolhido.getNome());
                        break;
                    case 3:
                        persistence.gerarRelatorioTurmas(cursoEscolhido.getTurmas(), cursoEscolhido.getNome());
                        break;
                        case 4:
                            persistence.gerarRelatorioCurso(cursoEscolhido, cursoEscolhido.getNome());
                        break;
                        case 5:
                            persistence.gerarRelatorioAssessments(turma1.getListaDeAvaliacoes(), cursoEscolhido.getNome());
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                        
                }
                break;
            case 6:
                System.out.println("Adicionar aluno");
                System.out.println("Digite o nome do aluno:");
                String nomeAlunoAdicionar = scanner.nextLine();
                System.out.println("Digite a idade do aluno:");
                int idadeAlunoAdicionar = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                System.out.println("Digite a matrícula do aluno:");
                String matriculaAlunoAdicionar = scanner.nextLine();
                System.out.println("Digite o email do aluno:");
                String emailAlunoAdicionar = scanner.nextLine();
                Aluno novoAluno = new Aluno(nomeAlunoAdicionar, idadeAlunoAdicionar, matriculaAlunoAdicionar, emailAlunoAdicionar);
                System.out.println("Escolha uma turma:");
                for (int i = 0; i < cursoEscolhido.getTurmas().size(); i++){
                    System.out.println((i + 1) + " - " + cursoEscolhido.getTurmas().get(i).getCodigo());
                }
                int escolhaTurma2 = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                cursoEscolhido.getTurmas().get(escolhaTurma2 - 1).adicionarAluno(novoAluno);
                System.out.println("Aluno adicionado com sucesso.");
                break;
            case 7:
                System.out.println("Adicionar professor");
                System.out.println("Digite o nome do professor:");
                String nomeProfessorAdicionar = scanner.nextLine();
                System.out.println("Digite a idade do professor:");
                int idadeProfessorAdicionar = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                System.out.println("Digite a especialidade do professor:");
                String especialidadeProfessorAdicionar = scanner.nextLine();
                System.out.println("Digite o ID do professor:");
                String idProfessorAdicionar = scanner.nextLine();
                Professor novoProfessor = new Professor(nomeProfessorAdicionar, idadeProfessorAdicionar, especialidadeProfessorAdicionar, idProfessorAdicionar);
                cursoEscolhido.adicionarProfessor(novoProfessor);
                System.out.println("Professor adicionado com sucesso.");
                break;
            case 8:
                System.out.println("Adicionar turma");
                System.out.println("Digite o código da turma:");
                String codigoTurmaAdicionar = scanner.nextLine();
                System.out.println("Digite o período da turma:");
                String periodoTurmaAdicionar = scanner.nextLine();
                Turma novaTurma = new Turma(codigoTurmaAdicionar, periodoTurmaAdicionar);
                cursoEscolhido.adicionarTurma(novaTurma);
                System.out.println("Turma adicionada com sucesso.");
                break;
            case 9:
                System.out.println("Adicionar avaliação");
                System.out.println("Digite o tipo da avaliação:");
                String tipoAvaliacaoAdicionar = scanner.nextLine();
                System.out.println("Digite a nota máxima da avaliação:");
                double notaMaximaAvaliacaoAdicionar = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                System.out.println("Digite o peso da avaliação:");
                double pesoAvaliacaoAdicionar = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                System.out.println("Escolha uma turma:");
                for (int i = 0; i < cursoEscolhido.getTurmas().size(); i++){
                    System.out.println((i + 1) + " - " + cursoEscolhido.getTurmas().get(i).getCodigo());
                }
                int escolhaTurmaAvaliacao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                   Assessment novaAvaliacao = new Assessment(tipoAvaliacaoAdicionar, notaMaximaAvaliacaoAdicionar, pesoAvaliacaoAdicionar, cursoEscolhido.getTurmas().get(escolhaTurmaAvaliacao - 1));
                    cursoEscolhido.getTurmas().get(escolhaTurmaAvaliacao - 1).adicionarAvaliacao(novaAvaliacao);
                    System.out.println("Avaliação adicionada com sucesso.");
                    break;
                case 10:
                    System.out.println("Adicionar submission");
                    System.out.println("Escolha uma turma:");
                    for (int i = 0; i < cursoEscolhido.getTurmas().size(); i++){
                        System.out.println((i + 1) + " - " + cursoEscolhido.getTurmas().get(i).getCodigo());
                    }
                    int escolhaTurmaSubmission = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    Turma turmaSubmission = cursoEscolhido.getTurmas().get(escolhaTurmaSubmission - 1);
                    System.out.println("Escolha um aluno:");
                    for (int i = 0; i < turmaSubmission.getListaDeAlunos().size(); i++){
                        System.out.println((i + 1) + " - " + turmaSubmission.getListaDeAlunos().get(i).getNome());
                    }
                    int escolhaAlunoSubmission = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    Aluno alunoSubmission = turmaSubmission.getListaDeAlunos().get(escolhaAlunoSubmission - 1);
                    System.out.println("Escolha uma avaliação:");
                    for (int i = 0; i < turmaSubmission.getListaDeAvaliacoes().size(); i++){
                        System.out.println((i + 1) + " - " + turmaSubmission.getListaDeAvaliacoes().get(i).getTipo());
                    }
                    int escolhaAvaliacaoSubmission = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    Assessment avaliacaoSubmission = turmaSubmission.getListaDeAvaliacoes().get(escolhaAvaliacaoSubmission - 1);
                    System.out.println("Digite a nota da submission:");
                    double notaSubmission = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite a data de entrega da submission:");
                    String dataEntregaSubmission = scanner.nextLine();
                    System.out.println("Digite os comentários da submission:");
                    String comentariosSubmission = scanner.nextLine();
                    Submission novaSubmission = new Submission(alunoSubmission, avaliacaoSubmission, notaSubmission, dataEntregaSubmission, comentariosSubmission);
                    //alunoSubmission.addSubmission(novaSubmission);
                    System.out.println("Submission adicionada com sucesso.");
                    break;
                
                
            case 11:
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


