package com.gs7;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CadastrarPaciente {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new JFrame("Cadastro de Paciente");
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setLayout(new BorderLayout(10, 10));

            JTextField campoNome = new JTextField(20);
            JTextField campoCpf = new JTextField(20);
            JComboBox<String> campoEspecialidade = new JComboBox<>(new String[] {
                    "Selecione uma especialidade",
                    "Clínica Geral",
                    "Cardiologia",
                    "Dermatologia",
                    "Ginecologia",
                    "Neurologia",
                    "Ortopedia",
                    "Pediatria"
            });

            JPanel formulario = new JPanel(new GridLayout(3, 2, 8, 8));
            formulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
            formulario.add(new JLabel("Nome completo:"));
            formulario.add(campoNome);
            formulario.add(new JLabel("CPF:"));
            formulario.add(campoCpf);
            formulario.add(new JLabel("Especialidade médica:"));
            formulario.add(campoEspecialidade);

            JButton botaoCadastrar = new JButton("Cadastrar Paciente");
            botaoCadastrar.addActionListener(event -> {
                String nome = campoNome.getText().trim();
                String cpf = campoCpf.getText().trim();

                if (nome.isEmpty() || cpf.isEmpty() || campoEspecialidade.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(
                            janela,
                            "Preencha todos os campos.",
                            "Campos obrigatórios",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String especialidade = (String) campoEspecialidade.getSelectedItem();
                JOptionPane.showMessageDialog(
                        janela,
                        "Paciente " + nome + " cadastrado com sucesso para atendimento na especialidade " + especialidade,
                        "Cadastro realizado",
                        JOptionPane.INFORMATION_MESSAGE);

                campoNome.setText("");
                campoCpf.setText("");
                campoEspecialidade.setSelectedIndex(0);
                campoNome.requestFocusInWindow();
            });

            JButton botaoLimpar = new JButton("Limpar");
            botaoLimpar.addActionListener(event -> {
                campoNome.setText("");
                campoCpf.setText("");
                campoEspecialidade.setSelectedIndex(0);
                campoNome.requestFocusInWindow();
            });

            JPanel painelBotao = new JPanel();
            painelBotao.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
            painelBotao.add(botaoLimpar);
            painelBotao.add(botaoCadastrar);

            janela.add(formulario, BorderLayout.CENTER);
            janela.add(painelBotao, BorderLayout.SOUTH);
            janela.pack();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }
}
