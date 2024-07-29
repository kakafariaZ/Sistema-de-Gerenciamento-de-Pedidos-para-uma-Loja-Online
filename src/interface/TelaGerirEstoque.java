
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaGerirEstoque {

    public void exibirTelaGerirEstoque() {
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
        JFrame frame = new JFrame("Gerir Estoque");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para o tamanho do desktop

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Tabela de produtos
        String[] colunas = {"Produto", "Quantidade", "Valor"};
        Object[][] dados = {
            {"Produto A", 10, "R$ 100,00"},
            {"Produto B", 5, "R$ 50,00"},
            {"Produto C", 20, "R$ 200,00"}
        };
        JTable tabelaProdutos = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão Cadastrar Produto
        JButton botaoCadastrarProduto = new JButton("CADASTRAR PRODUTO");
        botaoCadastrarProduto.setBackground(Color.BLACK);
        botaoCadastrarProduto.setForeground(Color.WHITE);
        botaoCadastrarProduto.setFocusPainted(false);
        botaoCadastrarProduto.setPreferredSize(new Dimension(200, 50));

        botaoCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroProduto cadastroProduto = new TelaCadastroProduto();
                cadastroProduto.exibirTelaCadastroProduto();
            }
        });

        // Painel inferior para o botão
        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(Color.WHITE);
        painelInferior.add(botaoCadastrarProduto);
        panel.add(painelInferior, BorderLayout.SOUTH);

        // Torna a janela visível
        frame.setVisible(true);
    }
}
