
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaEscolha {

    public static void main(String[] args) {
        // Carrega a fonte "Poppins"
        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);

            // Define a fonte "Poppins" como padrão
            UIManager.put("Button.font", poppins);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Cria o frame
        JFrame frame = new JFrame("Escolha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para o tamanho da tela
        frame.setUndecorated(true); // Opcional: Remove a barra de título (pode ser removido se não desejado)

        // Cria o painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Alinha componentes verticalmente
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Botão Vendedor
        JButton botaoVendedor = new JButton("VENDEDOR");
        botaoVendedor.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoVendedor.setBackground(Color.BLACK);
        botaoVendedor.setForeground(Color.WHITE);
        botaoVendedor.setFocusPainted(false);
        botaoVendedor.setPreferredSize(new Dimension(200, 50));
        botaoVendedor.setMaximumSize(new Dimension(200, 50));

        botaoVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção Vendedor selecionada.");
                // Aqui você pode abrir a tela do vendedor
            }
        });

        // Botão Cliente
        JButton botaoCliente = new JButton("CLIENTE");
        botaoCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCliente.setBackground(Color.BLACK);
        botaoCliente.setForeground(Color.WHITE);
        botaoCliente.setFocusPainted(false);
        botaoCliente.setPreferredSize(new Dimension(200, 50));
        botaoCliente.setMaximumSize(new Dimension(200, 50));

        botaoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção Cliente selecionada.");
                // Aqui você pode abrir a tela do cliente
            }
        });

        // Adiciona um espaço entre os botões
        panel.add(Box.createVerticalGlue());
        panel.add(botaoVendedor);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoCliente);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }
}
