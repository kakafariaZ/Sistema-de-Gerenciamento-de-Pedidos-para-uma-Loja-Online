package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCliente {

    public void exibirTelaCliente() {
        // Criação do frame
        JFrame frame = new JFrame("Tela Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Janela em tela cheia

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
                exibirComprarProduto(); // Chama método para exibir a tela de comprar produto
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
                exibirAcompanharCompra(); // Chama método para exibir a tela de acompanhamento de compra
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
                exibirCarrinho(); // Chama método para exibir o carrinho de compras
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
                frame.dispose(); // Fecha a aplicação ao clicar em "Sair"
            }
        });

        // Adiciona os botões ao painel
        panel.add(Box.createVerticalGlue());
        panel.add(botaoComprarProduto);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoAcompanharCompra);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoCarrinho);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoSair);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }

    private void exibirComprarProduto() {
        // Exemplo de janela pop-up para comprar produto
        JFrame frameCompra = new JFrame("Comprar Produto");
        frameCompra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCompra.setSize(600, 400);
        frameCompra.setLocationRelativeTo(null);

        // Criar painel e adicionar componentes relacionados à compra de produtos aqui
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelProdutos = new JLabel("Lista de Produtos:");
        panel.add(labelProdutos);

        // Lista de produtos de exemplo
        String[] produtos = {"Produto X", "Produto Y", "Produto Z"};
        JList<String> listaProdutos = new JList<>(produtos);
        panel.add(new JScrollPane(listaProdutos));

        // Botão Comprar Produto
        JButton botaoComprar = new JButton("Comprar Produto");
        botaoComprar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoComprar.setBackground(Color.BLACK);
        botaoComprar.setForeground(Color.WHITE);

        botaoComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirFormasDePagamento(); // Chama método para exibir formas de pagamento
            }
        });

        // Botão Por no Carrinho
        JButton botaoPorNoCarrinho = new JButton("Por no Carrinho");
        botaoPorNoCarrinho.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPorNoCarrinho.setBackground(Color.BLACK);
        botaoPorNoCarrinho.setForeground(Color.WHITE);

        botaoPorNoCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona lógica para colocar o produto no carrinho
                JOptionPane.showMessageDialog(frameCompra, "Produto adicionado ao carrinho.");
            }
        });

        panel.add(botaoComprar);
        panel.add(botaoPorNoCarrinho);
        frameCompra.add(panel);
        frameCompra.setVisible(true);
    }

    private void exibirFormasDePagamento() {
        // Exemplo de janela pop-up para formas de pagamento
        JFrame framePagamento = new JFrame("Formas de Pagamento");
        framePagamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePagamento.setSize(400, 300);
        framePagamento.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton botaoPaypal = new JButton("PayPal");
        botaoPaypal.setBackground(Color.BLACK);
        botaoPaypal.setForeground(Color.WHITE);
        panel.add(botaoPaypal);

        JButton botaoPix = new JButton("Pix");
        botaoPix.setBackground(Color.BLACK);
        botaoPix.setForeground(Color.WHITE);
        panel.add(botaoPix);

        JButton botaoCartao = new JButton("Cartão de Crédito");
        botaoCartao.setBackground(Color.BLACK);
        botaoCartao.setForeground(Color.WHITE);
        panel.add(botaoCartao);

        framePagamento.add(panel);
        framePagamento.setVisible(true);
    }

    private void exibirAcompanharCompra() {
        // Exemplo de janela pop-up para acompanhar compra
        JFrame frameAcompanhamento = new JFrame("Acompanhar Compra");
        frameAcompanhamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAcompanhamento.setSize(400, 300);
        frameAcompanhamento.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelStatus = new JLabel("Status da Compra:");
        panel.add(labelStatus);

        String[] status = {"Novo", "Processando", "Enviado", "Entregue"};
        JList<String> listaStatus = new JList<>(status);
        panel.add(new JScrollPane(listaStatus));

        frameAcompanhamento.add(panel);
        frameAcompanhamento.setVisible(true);
    }

    private void exibirCarrinho() {
        // Exemplo de janela pop-up para o carrinho de compras
        JFrame frameCarrinho = new JFrame("Carrinho de Compras");
        frameCarrinho.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCarrinho.setSize(600, 400);
        frameCarrinho.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelCarrinho = new JLabel("Produtos no Carrinho:");
        panel.add(labelCarrinho);

        // Lista de produtos no carrinho de exemplo
        String[] carrinho = {"Produto X", "Produto Y"};
        JList<String> listaCarrinho = new JList<>(carrinho);
        panel.add(new JScrollPane(listaCarrinho));

        JButton botaoFecharCompra = new JButton("Fechar Compra");
        botaoFecharCompra.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoFecharCompra.setBackground(Color.BLACK);
        botaoFecharCompra.setForeground(Color.WHITE);

        botaoFecharCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirFormasDePagamento(); // Chama método para exibir formas de pagamento
            }
        });

        panel.add(botaoFecharCompra);
        frameCarrinho.add(panel);
        frameCarrinho.setVisible(true);
    }
}
