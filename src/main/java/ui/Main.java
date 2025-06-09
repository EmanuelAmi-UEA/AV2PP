
package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import business.*;

public class Main extends JFrame {
    private ArrayList<Curso> cursos;
    private Curso cursoSelecionado;
    private JComboBox<String> comboCursos;
    private JTextArea textAreaResultados;
    private JButton btnProfessores, btnTurmas, btnSubmissoes, btnRelatorio, btnDeletarAluno;

    public Main() {
        inicializarDados();
        configurarInterface();
    }

    private void inicializarDados() {
        cursos = new ArrayList();

        // Criar Professores
        Professor professor = new Professor("Dr. Silva", 45, "Ciência da Computação", "PROF001");
        Professor professor2 = new Professor("Me. Souza", 38, "Licenciatura da Computação", "PROF002");

        // Criar Cursos
        Curso curso = new Curso("Programação Java", "60h", "POO, Collections, Exception Handling");
        Curso curso2 = new Curso("Algoritmos e Estruturas de Dados", "60h", "Estruturas de Dados, Algoritmos de Ordenação");

        // Associar Professor ao Curso
        curso.setProfessor(professor);
        curso2.setProfessor(professor2);
        professor.adicionarCurso(curso);
        professor2.adicionarCurso(curso2);

        // Criar Turmas
        Turma turma1 = new Turma("T1-2025", "2025.1");
        Turma turma2 = new Turma("T2-2025", "2025.1");

        // Adicionar Turmas ao Curso
        curso.adicionarTurma(turma1);
        curso2.adicionarTurma(turma2);

        // Criar e adicionar alunos à Turma 1
        turma1.adicionarAluno(new Aluno("João Silva", 20, "2023001", "joao@email.com"));
        turma1.adicionarAluno(new Aluno("Maria Santos", 19, "2023002", "maria@email.com"));
        turma1.adicionarAluno(new Aluno("Pedro Costa", 21, "2023003", "pedro@email.com"));
        turma1.adicionarAluno(new Aluno("Ana Oliveira", 20, "2023004", "ana@email.com"));
        turma1.adicionarAluno(new Aluno("Lucas Pereira", 22, "2023005", "lucas@email.com"));
        turma1.adicionarAluno(new Aluno("Carlos Souza", 19, "2023006", "carlos@email.com"));
        turma1.adicionarAluno(new Aluno("Julia Lima", 21, "2023007", "julia@email.com"));

        // Criar e adicionar alunos à Turma 2
        turma2.adicionarAluno(new Aluno("Carlos Souza", 19, "2023006", "carlos@email.com"));
        turma2.adicionarAluno(new Aluno("Julia Lima", 21, "2023007", "julia@email.com"));
        turma2.adicionarAluno(new Aluno("Rafael Martins", 20, "2023008", "rafael@email.com"));
        turma2.adicionarAluno(new Aluno("Beatriz Alves", 19, "2023009", "beatriz@email.com"));
        turma2.adicionarAluno(new Aluno("Gabriel Santos", 22, "2023010", "gabriel@email.com"));
        turma2.adicionarAluno(new Aluno("Ana Oliveira", 20, "2023004", "ana@email.com"));
        turma2.adicionarAluno(new Aluno("Lucas Pereira", 22, "2023005", "lucas@email.com"));

        // Criar avaliações
        Assessment av1Turma1 = new Assessment("Prova 1", 10.0, 0.4, turma1);
        Assessment av2Turma1 = new Assessment("Prova 2", 10.0, 0.6, turma1);
        Assessment av3Turma1 = new Assessment("Prova 3", 10.0, 1.0, turma1);
        Assessment av1Turma2 = new Assessment("Teste", 5.0, 0.3, turma2);
        Assessment av2Turma2 = new Assessment("Trabalho Prático", 10.0, 0.7, turma2);
        Assessment av3Turma2 = new Assessment("Projeto", 10.0, 0.5, turma2);

        // Adicionar avaliações
        turma1.adicionarAvaliacao(av1Turma1);
        turma1.adicionarAvaliacao(av2Turma1);
        turma1.adicionarAvaliacao(av3Turma1);
        turma2.adicionarAvaliacao(av1Turma2);
        turma2.adicionarAvaliacao(av2Turma2);
        turma2.adicionarAvaliacao(av3Turma2);

        // Criar submissions Turma 1
        new Submission(turma1.getListaDeAlunos().get(0), av1Turma1, 8.5, "2025-05-01", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(0), av2Turma1, 9.0, "2025-05-15", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(0), av3Turma1, 7.5, "2025-05-30", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(1), av1Turma1, 6.0, "2025-05-01", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(1), av2Turma1, 7.5, "2025-05-15", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(1), av3Turma1, 8.0, "2025-05-30", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(2), av1Turma1, 9.5, "2025-05-01", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(2), av2Turma1, 8.0, "2025-05-15", "Parabéns!");
        new Submission(turma1.getListaDeAlunos().get(2), av3Turma1, 9.0, "2025-05-30", "Parabéns!");

        // Criar submissions Turma 2
        new Submission(turma2.getListaDeAlunos().get(0), av1Turma2, 4.5, "2025-05-01", "Parabéns!");
        new Submission(turma2.getListaDeAlunos().get(0), av2Turma2, 9.0, "2025-05-15", "Parabéns!");
        new Submission(turma2.getListaDeAlunos().get(0), av3Turma2, 8.5, "2025-05-30", "Parabéns!");
        new Submission(turma2.getListaDeAlunos().get(1), av1Turma2, 3.0, "2025-05-01", "Parabéns!");
        new Submission(turma2.getListaDeAlunos().get(1), av2Turma2, 7.5, "2025-05-15", "Parabéns!");
        new Submission(turma2.getListaDeAlunos().get(1), av3Turma2, 8.0, "2025-05-30", "Parabéns!");

        cursos.add(curso);
        cursos.add(curso2);
    }

    private void configurarInterface() {
        setTitle("Sistema de Gestão Acadêmica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));

        // Painel superior - Seleção de curso
        JPanel painelSuperior = new JPanel(new FlowLayout());
        painelSuperior.setBorder(new EmptyBorder(10, 10, 10, 10));
        painelSuperior.add(new JLabel("Selecione um curso:"));

        String[] nomesCursos = cursos.stream().map(Curso::getNome).toArray(String[]::new);
        comboCursos = new JComboBox<>(nomesCursos);
        comboCursos.addActionListener(e -> {
            cursoSelecionado = cursos.get(comboCursos.getSelectedIndex());
            habilitarBotoes(true);
        });
        painelSuperior.add(comboCursos);

        // Painel central - Botões de ação
        JPanel painelCentral = new JPanel(new GridLayout(2, 3, 10, 10));
        painelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));

        btnProfessores = new JButton("Informações dos Professores");
        btnTurmas = new JButton("Informações das Turmas");
        btnSubmissoes = new JButton("Submissões da Turma");
        btnRelatorio = new JButton("Relatório de Desempenho");
        btnDeletarAluno = new JButton("Deletar Aluno");

        btnProfessores.addActionListener(e -> exibirInformacoesProfessores());
        btnTurmas.addActionListener(e -> exibirInformacoesTurmas());
        btnSubmissoes.addActionListener(e -> exibirSubmissoes());
        btnRelatorio.addActionListener(e -> exibirRelatorioDesempenho());
        btnDeletarAluno.addActionListener(e -> deletarAluno());

        painelCentral.add(btnProfessores);
        painelCentral.add(btnTurmas);
        painelCentral.add(btnSubmissoes);
        painelCentral.add(btnRelatorio);
        painelCentral.add(btnDeletarAluno);

        habilitarBotoes(false);

        // Área de resultados
        textAreaResultados = new JTextArea();
        textAreaResultados.setEditable(false);
        textAreaResultados.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textAreaResultados);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));

        add(painelSuperior, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        // Selecionar primeiro curso por padrão
        if (!cursos.isEmpty()) {
            cursoSelecionado = cursos.get(0);
            habilitarBotoes(true);
        }
    }

    private void habilitarBotoes(boolean habilitar) {
        btnProfessores.setEnabled(habilitar);
        btnTurmas.setEnabled(habilitar);
        btnSubmissoes.setEnabled(habilitar);
        btnRelatorio.setEnabled(habilitar);
        btnDeletarAluno.setEnabled(habilitar);
    }

    private void exibirInformacoesProfessores() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INFORMAÇÕES DO PROFESSOR ===\n\n");
        sb.append("Curso: ").append(cursoSelecionado.getNome()).append("\n");
        sb.append("Professor: ").append(cursoSelecionado.getProfessor().getNome()).append("\n");
        sb.append("Especialidade: ").append(cursoSelecionado.getProfessor().getEspecilidade()).append("\n");
        textAreaResultados.setText(sb.toString());
    }

    private void exibirInformacoesTurmas() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INFORMAÇÕES DAS TURMAS ===\n\n");
        sb.append("Curso: ").append(cursoSelecionado.getNome()).append("\n");
        sb.append("Professor: ").append(cursoSelecionado.getProfessor().getNome()).append("\n\n");

        for (Turma turma : cursoSelecionado.getTurmas()) {
            sb.append("Turma: ").append(turma.getCodigo()).append("\n");
            sb.append("Período: ").append(turma.getPeriodo()).append("\n");
            sb.append("Alunos:\n");
            for (Aluno aluno : turma.getListaDeAlunos()) {
                sb.append("  - ").append(aluno.getNome())
                  .append(" (Matrícula: ").append(aluno.getMatricula()).append(")\n");
            }
            sb.append("Avaliações:\n");
            for (Assessment avaliacao : turma.getListaDeAvaliacoes()) {
                sb.append("  - ").append(avaliacao.getTipo())
                  .append(" (Peso: ").append(avaliacao.getPeso()).append(")\n");
            }
            sb.append("\n");
        }
        textAreaResultados.setText(sb.toString());
    }

    private void exibirSubmissoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SUBMISSÕES DA TURMA ===\n\n");
        sb.append("Curso: ").append(cursoSelecionado.getNome()).append("\n\n");

        for (Turma turma : cursoSelecionado.getTurmas()) {
            sb.append("Turma: ").append(turma.getCodigo()).append("\n");
            for (Assessment a : turma.getListaDeAvaliacoes()) {
                sb.append("\nAvaliação: ").append(a.getTipo()).append("\n");
                List<Submission> submissions = a.getSubmissions();
                if (submissions.isEmpty()) {
                    sb.append("  Nenhuma submissão registrada.\n");
                } else {
                    for (Submission s : submissions) {
                        sb.append("  Aluno: ").append(s.getAluno().getNome())
                          .append(" | Nota: ").append(s.getNota())
                          .append(" | Entrega: ").append(s.getDataEntrega())
                          .append(" | Comentários: ").append(s.getComentarios()).append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        textAreaResultados.setText(sb.toString());
    }

    private void exibirRelatorioDesempenho() {
        String nomeAluno = JOptionPane.showInputDialog(this, "Digite o nome do aluno:");
        if (nomeAluno == null || nomeAluno.trim().isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        boolean encontrou = false;

        for (Turma turma : cursoSelecionado.getTurmas()) {
            for (Aluno aluno : turma.getListaDeAlunos()) {
                if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                    PerformanceReport relatorio = new PerformanceReport(aluno, turma);

                    sb.append("=== RELATÓRIO DE DESEMPENHO ===\n\n");
                    sb.append("Aluno: ").append(aluno.getNome()).append("\n");
                    sb.append("Turma: ").append(turma.getCodigo()).append("\n\n");

                    for (Assessment a : turma.getListaDeAvaliacoes()) {
                        for (Submission s : a.getSubmissions()) {
                            if (s.getAluno().equals(aluno)) {
                                sb.append("- ").append(a.getTipo()).append(": ")
                                  .append(s.getNota()).append("/").append(a.getNotaMaxima()).append("\n");
                            }
                        }
                    }

                    sb.append("\nMédia ponderada: ").append(String.format("%.2f", relatorio.calculateMediaPonderada())).append("\n");
                    sb.append("Aproveitamento: ").append(String.format("%.2f%%", relatorio.calculaAproveitamento())).append("\n");
                    encontrou = true;
                    break;
                }
            }
            if (encontrou) break;
        }

        if (!encontrou) {
            sb.append("Aluno não encontrado ou sem submissões.");
        }

        textAreaResultados.setText(sb.toString());
    }

    private void deletarAluno() {
        String nomeAluno = JOptionPane.showInputDialog(this, "Digite o nome do aluno a ser deletado:");
        if (nomeAluno == null || nomeAluno.trim().isEmpty()) {
            return;
        }

        boolean encontrou = false;
        for (Turma turma : cursoSelecionado.getTurmas()) {
            for (int i = 0; i < turma.getListaDeAlunos().size(); i++) {
                Aluno aluno = turma.getListaDeAlunos().get(i);
                if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                    aluno.deleteAluno();
                    turma.removerAluno(aluno);
                    JOptionPane.showMessageDialog(this, "Aluno deletado com sucesso!");
                    textAreaResultados.setText("Aluno " + nomeAluno + " foi deletado do sistema.");
                    encontrou = true;
                    break;
                }
            }
            if (encontrou) break;
        }

        if (!encontrou) {
            JOptionPane.showMessageDialog(this, "Aluno não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new SwingGUI().setVisible(true);
        });
    }
}
