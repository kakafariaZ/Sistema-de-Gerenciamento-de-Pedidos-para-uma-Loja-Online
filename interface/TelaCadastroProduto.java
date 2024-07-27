
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaCadastroProduto {

    public void exibirTelaCadastroProduto() {
        // Configurações da fonte Poppins
        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(14f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);

            // Define a fonte "Poppins" como padrão
            UIManager.put("Label.font", poppins);
            UIManager.put("Button.font", poppins);
            UIManager.put("TextField.font", poppins);
            UIManager.put("TextArea.font", poppins);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Criação do frame
        JFrame frame = new JFrame("Cadastro de Produto");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para o tamanho do desktop

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Alinha componentes verticalmente
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Campos de entrada
        JTextField campoNome = new JTextField();
        JTextField campoQuantidade = new JTextField();
        JTextField campoValor = new JTextField();
        JTextArea campoDescricao = new JTextArea();
        campoDescricao.setLineWrap(true);
        campoDescricao.setWrapStyleWord(true);

        // Adiciona campos e rótulos ao painel
        panel.add(criarCampoComRotulo("Nome do Produto:", campoNome));
        panel.add(criarCampoComRotulo("Quantidade:", campoQuantidade));
        panel.add(criarCampoComRotulo("Valor:", campoValor));
        panel.add(criarCampoComRotulo("Descrição:", new JScrollPane(campoDescricao)));

        // Botão Salvar
        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSalvar.setBackground(Color.BLACK);
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setPreferredSize(new Dimension(200, 50));
        botaoSalvar.setMaximumSize(new Dimension(200, 50));

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para salvar o produto
                String nome = campoNome.getText();
                String quantidade = campoQuantidade.getText();
                String valor = campoValor.getText();
                String descricao = campoDescricao.getText();

                // Exemplo de mensagem de sucesso
                JOptionPane.showMessageDialog(frame, "Produto " + nome + " cadastrado com sucesso!");
                frame.dispose(); // Fecha a tela de cadastro
            }
        });

        // Adiciona o botão ao painel
        panel.add(Box.createVerticalGlue());
        panel.add(botaoSalvar);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }

    private JPanel criarCampoComRotulo(String rotulo, JComponent campo) {
        JPanel painelCampo = new JPanel();
        painelCampo.setLayout(new BoxLayout(painelCampo, BoxLayout.Y_AXIS));
        painelCampo.setBackground(Color.WHITE);

        JLabel label = new JLabel(rotulo);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, campo.getPreferredSize().height));

        painelCampo.add(label);
        painelCampo.add(campo);

        return painelCampo;
    }
}
