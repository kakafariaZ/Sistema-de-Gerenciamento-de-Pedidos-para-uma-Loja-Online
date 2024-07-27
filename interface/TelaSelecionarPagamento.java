
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelaSelecionarPagamento {

    private Produto produtoSelecionado;
    private List<Produto> carrinho;

    public TelaSelecionarPagamento(Produto produtoSelecionado, List<Produto> carrinho) {
        this.produtoSelecionado = produtoSelecionado;
        this.carrinho = carrinho;
    }

    public void exibirTelaSelecionarPagamento() {
        // Configurações da fonte Poppins
        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(14f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);

            // Define a fonte "Poppins" como padrão
            UIManager.put("Label.font", poppins);
            UIManager.put("Button.font", poppins);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Criação do frame
        JFrame frame = new JFrame("Selecionar Pagamento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Botão PayPal
        JButton botaoPayPal = new JButton("PAGAR COM PAYPAL");
        botaoPayPal.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPayPal.setBackground(Color.BLACK);
        botaoPayPal.setForeground(Color.WHITE);
        botaoPayPal.setFocusPainted(false);
        botaoPayPal.setPreferredSize(new Dimension(200, 50));
        botaoPayPal.setMaximumSize(new Dimension(200, 50));

        botaoPayPal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Pagamento com PayPal realizado.");
                frame.dispose();
            }
        });

        // Botão Pix
        JButton botaoPix = new JButton("PAGAR COM PIX");
        botaoPix.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPix.setBackground(Color.BLACK);
        botaoPix.setForeground(Color.WHITE);
        botaoPix.setFocusPainted(false);
        botaoPix.setPreferredSize(new Dimension(200, 50));
        botaoPix.setMaximumSize(new Dimension(200, 50));

        botaoPix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Pagamento com Pix realizado.");
                frame.dispose();
            }
        });

        // Botão Cartão
        JButton botaoCartao = new JButton("PAGAR COM CARTÃO");
        botaoCartao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCartao.setBackground(Color.BLACK);
        botaoCartao.setForeground(Color.WHITE);
        botaoCartao.setFocusPainted(false);
        botaoCartao.setPreferredSize(new Dimension(200, 50));
        botaoCartao.setMaximumSize(new Dimension(200, 50));

        botaoCartao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Pagamento com Cartão realizado.");
                frame.dispose();
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(botaoPayPal);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botaoPix);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botaoCartao);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }
}
