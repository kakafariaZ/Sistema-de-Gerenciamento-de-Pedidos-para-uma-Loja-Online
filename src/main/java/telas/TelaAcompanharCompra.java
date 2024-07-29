package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TelaAcompanharCompra {

    public void exibirTelaAcompanharCompra() {
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
        JFrame frame = new JFrame("Acompanhar Compra");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // Estágios da compra
        String[] estagios = {"Novo", "Processando", "Enviado", "Entregue"};
        JList<String> listaEstagios = new JList<>(estagios);
        listaEstagios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaEstagios.setSelectedIndex(0);
        JScrollPane scrollPane = new JScrollPane(listaEstagios);
        panel.add(scrollPane);

        // Botão Voltar
        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoVoltar.setBackground(Color.BLACK);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setPreferredSize(new Dimension(200, 50));
        botaoVoltar.setMaximumSize(new Dimension(200, 50));

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a tela de acompanhamento e volta para a tela principal
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(botaoVoltar);
        panel.add(Box.createVerticalGlue());

        // Torna a janela visível
        frame.setVisible(true);
    }
}
