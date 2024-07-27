
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelaCliente {

    // Lista para armazenar produtos no carrinho
    private static List<Produto> carrinho = new ArrayList<>();

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
        JFrame frame = new JFrame("Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para o tamanho do desktop

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Alinha componentes verticalmente
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Botão Comprar Produto
        JButton botaoComprarProduto = new JButton("COMPRAR PRODUTO");
        botaoComprarProduto.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoComprarProduto.setBackground(Color.BLACK);
        botaoComprarProduto.setForeground(Color.WHITE);
        botaoComprarProduto.setFocusPainted(false);
        botaoComprarProduto.setPreferredSize(new Dimension(200, 50));
        botaoComprarProduto.setMaximumSize(new Dimension(200, 50));

        botaoComprarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaComprarProduto comprarProduto = new TelaComprarProduto(carrinho);
                comprarProduto.exibirTelaComprarProduto();
            }
        });

        // Botão Carrinho
        JButton botaoCarrinho = new JButton("CARRINHO");
        botaoCarrinho.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCarrinho.setBackground(Color.BLACK);
        botaoCarrinho.setForeground(Color.WHITE);
        botaoCarrinho.setFocusPainted(false);
        botaoCarrinho.setPreferredSize(new Dimension(200, 50));
        botaoCarrinho.setMaximumSize(new Dimension(200, 50));

        botaoCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCarrinho telaCarrinho = new TelaCarrinho(carrinho);
                telaCarrinho.exibirTelaCarrinho();
            }
        });

        // Botão Acompanhar Compra
        JButton botaoAcompanharCompra = new JButton("ACOMPANHAR COMPRA");
        botaoAcompanharCompra.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoAcompanharCompra.setBackground(Color.BLACK);
        botaoAcompanharCompra.setForeground(Color.WHITE);
        botaoAcompanharCompra.setFocusPainted(false);
        botaoAcompanharCompra.setPreferredSize(new Dimension(200, 50));
        botaoAcompanharCompra.setMaximumSize(new Dimension(200, 50));

        botaoAcompanharCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAcompanharCompra acompanharCompra = new TelaAcompanharCompra();
                acompanharCompra.exibirTelaAcompanharCompra();
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
        panel.add(botaoComprarProduto);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoCarrinho);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botaoAcompanharCompra);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botaoSair);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }
}
