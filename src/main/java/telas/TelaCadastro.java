package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaCadastro {

    public void exibirTelaCadastro() {
        // Carrega a fonte "Poppins"
        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(14f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);

            // Define a fonte "Poppins" como padrão
            UIManager.put("Label.font", poppins);
            UIManager.put("Button.font", poppins);
            UIManager.put("TextField.font", poppins);
            UIManager.put("PasswordField.font", poppins);
            UIManager.put("OptionPane.font", poppins);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Cria o frame
        JFrame frame = new JFrame("Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela

        // Cria o painel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Usa GridBagLayout para centralizar
        frame.add(panel);

        configurarComponentes(panel, frame);

        // Torna a janela visível
        frame.setVisible(true);
    }

    private void configurarComponentes(JPanel panel, JFrame frame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Margens entre componentes
        gbc.weightx = 1.0; // Faz com que os componentes ocupem o espaço disponível

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) (screenSize.width * 0.3); // 30% da largura da tela
        int altura = 40; // Altura padrão para os botões

        // Título aumentado em 200%
        JLabel titulo = new JLabel("<html><span style='font-size:200%;font-family:Poppins'>CADASTRE-SE</span></html>");
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza horizontalmente

        // Configurações de layout para o título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // O título ocupa duas colunas
        gbc.insets = new Insets(30, 10, 30, 10); // Aumenta a margem superior e inferior para distanciamento
        panel.add(titulo, gbc);

        // Rótulo de usuário
        JLabel rotuloUsuario = new JLabel("LOGIN");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Reseta a largura do grid para um
        gbc.insets = new Insets(10, 10, 2, 10); // Ajusta margens
        gbc.weightx = 0; // Desativa o ajuste de largura
        panel.add(rotuloUsuario, gbc);

        // Campo de texto para o nome de usuário
        JTextField campoUsuario = new JTextField();
        campoUsuario.setPreferredSize(new Dimension(largura, altura)); // Define a largura do campo
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0; // Faz com que o campo ocupe o espaço disponível
        panel.add(campoUsuario, gbc);

        // Rótulo de senha
        JLabel rotuloSenha = new JLabel("SENHA");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0; // Desativa o ajuste de largura
        panel.add(rotuloSenha, gbc);

        // Campo de senha
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setPreferredSize(new Dimension(largura, altura)); // Define a largura do campo
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0; // Faz com que o campo ocupe o espaço disponível
        panel.add(campoSenha, gbc);

        // Rótulo de confirmar senha
        JLabel rotuloConfirmaSenha = new JLabel("CONFIRMAR SENHA");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0; // Desativa o ajuste de largura
        panel.add(rotuloConfirmaSenha, gbc);

        // Campo de confirmação de senha
        JPasswordField campoConfirmaSenha = new JPasswordField();
        campoConfirmaSenha.setPreferredSize(new Dimension(largura, altura)); // Define a largura do campo
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0; // Faz com que o campo ocupe o espaço disponível
        panel.add(campoConfirmaSenha, gbc);

        // Botão de cadastro
        JButton botaoCadastro = new JButton("CADASTRAR");
        botaoCadastro.setPreferredSize(new Dimension(largura, altura)); // Define a largura do botão
        botaoCadastro.setBackground(Color.BLACK);
        botaoCadastro.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.insets = new Insets(20, 10, 10, 10); // Ajusta a margem inferior para distanciamento
        panel.add(botaoCadastro, gbc);

        // Ação do botão de cadastro
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                String confirmaSenha = new String(campoConfirmaSenha.getPassword());

                // Verifica se as senhas coincidem
                if (!senha.equals(confirmaSenha)) {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem. Tente novamente.");
                    return;
                }

                // Se o cadastro for bem-sucedido, volte para a tela de login
                JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido!");
                frame.dispose(); // Fecha a tela de cadastro
                TelaLogin.main(new String[]{}); // Volta para a tela de login
            }
        });
    }
}
