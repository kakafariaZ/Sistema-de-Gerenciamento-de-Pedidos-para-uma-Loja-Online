package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVendedor {

    public void exibirTelaVendedor() {
        // Criação do frame
        JFrame frame = new JFrame("Tela Vendedor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Janela em tela cheia

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
                exibirGerirEstoque(); // Chama método para exibir a tela de gestão de estoque
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
        panel.add(botaoGerirEstoque);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço de 10 pixels entre os botões
        panel.add(botaoSair);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }

    private void exibirGerirEstoque() {
        // Exemplo de janela pop-up para gerir estoque
        JFrame frameEstoque = new JFrame("Gerir Estoque");
        frameEstoque.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEstoque.setSize(600, 400);
        frameEstoque.setLocationRelativeTo(null);

        // Criar painel e adicionar componentes relacionados ao estoque aqui
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelProdutos = new JLabel("Lista de Produtos:");
        panel.add(labelProdutos);

        // Lista de produtos de exemplo
        String[] produtos = {"Produto A", "Produto B", "Produto C"};
        JList<String> listaProdutos = new JList<>(produtos);
        panel.add(new JScrollPane(listaProdutos));

        // Botão de cadastro de produto
        JButton botaoCadastrarProduto = new JButton("Cadastrar Produto");
        botaoCadastrarProduto.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCadastrarProduto.setBackground(Color.BLACK);
        botaoCadastrarProduto.setForeground(Color.WHITE);

        botaoCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirCadastroProduto(); // Chama método para exibir a tela de cadastro de produto
            }
        });

        panel.add(botaoCadastrarProduto);
        frameEstoque.add(panel);
        frameEstoque.setVisible(true);
    }

    private void exibirCadastroProduto() {
        // Exemplo de janela pop-up para cadastro de produto
        JFrame frameCadastro = new JFrame("Cadastro de Produto");
        frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastro.setSize(400, 300);
        frameCadastro.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Nome:"));
        JTextField campoNome = new JTextField();
        panel.add(campoNome);

        panel.add(new JLabel("Quantidade:"));
        JTextField campoQuantidade = new JTextField();
        panel.add(campoQuantidade);

        panel.add(new JLabel("Descrição:"));
        JTextField campoDescricao = new JTextField();
        panel.add(campoDescricao);

        panel.add(new JLabel("Valor:"));
        JTextField campoValor = new JTextField();
        panel.add(campoValor);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBackground(Color.BLACK);
        botaoSalvar.setForeground(Color.WHITE);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar o produto aqui

                frameCadastro.dispose(); // Fecha a janela de cadastro após salvar
            }
        });

        panel.add(botaoSalvar);

        frameCadastro.add(panel);
        frameCadastro.setVisible(true);
    }
}
