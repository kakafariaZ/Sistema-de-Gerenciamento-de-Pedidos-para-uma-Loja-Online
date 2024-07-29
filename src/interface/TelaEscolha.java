
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaEscolha {

    public void exibirTelaEscolha() {
        // Criação do frame
        JFrame frame = new JFrame("Escolha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Janela em tela cheia

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
                TelaVendedor telaVendedor = new TelaVendedor();
                telaVendedor.exibirTelaVendedor();
                frame.dispose(); // Fecha a tela de escolha
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
                TelaCliente telaCliente = new TelaCliente();
                telaCliente.exibirTelaCliente();
                ((JFrame) SwingUtilities.getWindowAncestor(panel)).dispose(); // Fecha a tela de escolha
            }
        });

        // Adiciona os botões ao painel
        panel.add(Box.createVerticalGlue());
        panel.add(botaoVendedor);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoCliente);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }
}
