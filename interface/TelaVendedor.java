
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaVendedor {

    public static void main(String[] args) {
        // Configurações da fonte Poppins
        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);

            // Define a fonte "Poppins" como padrão
            UIManager.put("Label.font", poppins);
            UIManager.put("Button.font", poppins);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Criação do frame
        JFrame frame = new JFrame("Vendedor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para o tamanho do desktop

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Alinha componentes verticalmente
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Botão Gerir Estoque
        JButton botaoGerirEstoque = new JButton("GERIR ESTOQUE");
        botaoGerirEstoque.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoGerirEstoque.setBackground(Color.BLACK);
        botaoGerirEstoque.setForeground(Color.WHITE);
        botaoGerirEstoque.setFocusPainted(false);
        botaoGerirEstoque.setPreferredSize(new Dimension(200, 50));
        botaoGerirEstoque.setMaximumSize(new Dimension(200, 50));

        botaoGerirEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaGerirEstoque gerirEstoque = new TelaGerirEstoque();
                gerirEstoque.exibirTelaGerirEstoque();
            }
        });

        // Botão Sair
        JButton botaoSair = new JButton("SAIR");
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setBackground(Color.BLACK);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFocusPainted(false);
        botaoSair.setPreferredSize(new Dimension(200, 50));
        botaoSair.setMaximumSize(new Dimension(200, 50));

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a aplicação
            }
        });

        // Adiciona um espaço entre os botões
        panel.add(Box.createVerticalGlue());
        panel.add(botaoGerirEstoque);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoSair);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }
}
