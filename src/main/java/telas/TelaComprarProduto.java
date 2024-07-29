package telas;

import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelaComprarProduto {

    private List<Produto> carrinho;
    private JTable tabelaProdutos;

    public TelaComprarProduto(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public void exibirTelaComprarProduto() {
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
        JFrame frame = new JFrame("Comprar Produto");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Tabela de produtos
        String[] colunas = {"Produto", "Quantidade em Estoque", "Valor"};
        Object[][] dados = {
            {"Produto A", 10, 100.00},
            {"Produto B", 5, 50.00},
            {"Produto C", 20, 200.00}
        };
        tabelaProdutos = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Botão Comprar Produto
        JButton botaoComprar = new JButton("COMPRAR PRODUTO");
        botaoComprar.setBackground(Color.BLACK);
        botaoComprar.setForeground(Color.WHITE);
        botaoComprar.setFocusPainted(false);
        botaoComprar.setPreferredSize(new Dimension(200, 50));

        botaoComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaProdutos.getSelectedRow();
                if (selectedRow != -1) {
                    String nome = (String) tabelaProdutos.getValueAt(selectedRow, 0);
                    int quantidade = (int) tabelaProdutos.getValueAt(selectedRow, 1);
                    double valor = (double) tabelaProdutos.getValueAt(selectedRow, 2);

                    Produto produtoSelecionado = new Produto(nome, valor, "descricao", quantidade);

                    TelaSelecionarPagamento selecionarPagamento = new TelaSelecionarPagamento(produtoSelecionado, carrinho);
                    selecionarPagamento.exibirTelaSelecionarPagamento();
                    frame.dispose(); // Fecha a tela de compra após selecionar o produto
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione um produto.");
                }
            }
        });

        // Botão Por no Carrinho
        JButton botaoCarrinho = new JButton("POR NO CARRINHO");
        botaoCarrinho.setBackground(Color.BLACK);
        botaoCarrinho.setForeground(Color.WHITE);
        botaoCarrinho.setFocusPainted(false);
        botaoCarrinho.setPreferredSize(new Dimension(200, 50));

        botaoCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaProdutos.getSelectedRow();
                if (selectedRow != -1) {
                    String nome = (String) tabelaProdutos.getValueAt(selectedRow, 0);
                    int quantidade = (int) tabelaProdutos.getValueAt(selectedRow, 1);
                    double valor = (double) tabelaProdutos.getValueAt(selectedRow, 2);

                    Produto produtoSelecionado = new Produto(nome, valor, "descricao", quantidade);

                    carrinho.add(produtoSelecionado);
                    JOptionPane.showMessageDialog(frame, "Produto adicionado ao carrinho.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione um produto.");
                }
            }
        });

        buttonPanel.add(botaoComprar);
        buttonPanel.add(botaoCarrinho);

        // Torna a janela visível
        frame.setVisible(true);
    }
}
