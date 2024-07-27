
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelaCarrinho {

    private List<Produto> carrinho;
    private JTable tabelaCarrinho;

    public TelaCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public void exibirTelaCarrinho() {
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
        JFrame frame = new JFrame("Carrinho");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Tabela do carrinho
        String[] colunas = {"Selecionar", "Produto", "Quantidade", "Valor"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        tabelaCarrinho = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaCarrinho);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Preencher tabela com dados do carrinho
        for (Produto produto : carrinho) {
            model.addRow(new Object[]{false, produto.getNome(), produto.getQuantidade(), produto.getValor()});
        }

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Botão Fechar Compra
        JButton botaoFecharCompra = new JButton("FECHAR COMPRA");
        botaoFecharCompra.setBackground(Color.BLACK);
        botaoFecharCompra.setForeground(Color.WHITE);
        botaoFecharCompra.setFocusPainted(false);
        botaoFecharCompra.setPreferredSize(new Dimension(200, 50));

        botaoFecharCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorTotal = 0.0;
                for (int i = 0; i < tabelaCarrinho.getRowCount(); i++) {
                    boolean isSelected = (boolean) tabelaCarrinho.getValueAt(i, 0);
                    if (isSelected) {
                        double valor = (double) tabelaCarrinho.getValueAt(i, 3);
                        valorTotal += valor;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Valor Total: R$ " + valorTotal);

                TelaSelecionarPagamento selecionarPagamento = new TelaSelecionarPagamento(null, carrinho);
                selecionarPagamento.exibirTelaSelecionarPagamento();
                frame.dispose(); // Fecha a tela de carrinho após fechar a compra
            }
        });

        // Botão Voltar
        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBackground(Color.BLACK);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setPreferredSize(new Dimension(200, 50));

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a tela de carrinho e volta para a tela principal
            }
        });

        buttonPanel.add(botaoFecharCompra);
        buttonPanel.add(botaoVoltar);

        // Torna a janela visível
        frame.setVisible(true);
    }
}
