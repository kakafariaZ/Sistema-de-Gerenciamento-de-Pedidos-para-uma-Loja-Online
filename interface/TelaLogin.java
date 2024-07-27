
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaLogin {

    public static void main(String[] args) {
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
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela

        // Cria o painel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Usa GridBagLayout para centralizar
        frame.add(panel);

        configurarComponentes(panel);

        // Torna a janela visível
        frame.setVisible(true);
    }

    private static void configurarComponentes(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Margens entre componentes
        gbc.weightx = 1.0; // Faz com que os componentes ocupem o espaço disponível

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) (screenSize.width * 0.3); // 30% da largura da tela
        int altura = 40; // Altura padrão para os botões

        // Título aumentado em 200%
        JLabel titulo = new JLabel("<html><span style='font-size:200%;font-family:Poppins'><font color='black'>Gere</font><font color='blue'>+</font><font color='black'>Vendas</font></span></html>");
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

        // Botão de login
        JButton botaoLogin = new JButton("LOGIN");
        botaoLogin.setPreferredSize(new Dimension(largura, altura)); // Define a largura do botão
        botaoLogin.setBackground(Color.BLACK);
        botaoLogin.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.insets = new Insets(20, 10, 10, 10); // Ajusta a margem inferior para distanciamento
        panel.add(botaoLogin, gbc);

        // Botão de cadastro
        JButton botaoCadastro = new JButton("CADASTRE-SE");
        botaoCadastro.setPreferredSize(new Dimension(largura, altura)); // Define a largura do botão
        botaoCadastro.setBackground(Color.BLACK);
        botaoCadastro.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.insets = new Insets(10, 10, 10, 10); // Ajusta a margem inferior para distanciamento
        panel.add(botaoCadastro, gbc);

        // Ação do botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                // Validação de credenciais (apenas exemplo)
                if (usuario.equals("admin") && senha.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    System.out.println("Login bem-sucedido!"); // Mensagem de depuração

                    // Cria e exibe a TelaEscolha
                    TelaEscolha telaEscolha = new TelaEscolha();
                    telaEscolha.exibirTelaEscolha();

                    // Fecha a tela de login
                    ((JFrame) SwingUtilities.getWindowAncestor(panel)).dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
                    System.out.println("Credenciais inválidas."); // Mensagem de depuração
                }
            }
        });

        // Ação do botão de cadastro
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a tela de cadastro
                TelaCadastro cadastro = new TelaCadastro();
                cadastro.exibirTelaCadastro();
                ((JFrame) SwingUtilities.getWindowAncestor(panel)).dispose(); // Fecha a tela de login
            }
        });
    }
}
