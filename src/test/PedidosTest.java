package test;

import model.EstadoPedido;
import model.ItemPedido;
import model.Pedidos;
import model.Produto;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PedidosTest {

    private Pedidos pedidos;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void setUp() {
        pedidos = new Pedidos();
        produto1 = new Produto("Produto 1", 100.0, "Descrição do Produto 1", 10);
        produto2 = new Produto("Produto 2", 50.0, "Descrição do Produto 2", 20);
    }

    @Test
    public void testAdicionarItem() {
        pedidos.adicionarItem(produto1, 2);
        pedidos.adicionarItem(produto2, 1);

        List<ItemPedido> itens = pedidos.getItens();
        assertEquals(2, itens.size());

        ItemPedido item1 = itens.get(0);
        assertEquals(produto1, item1.getProduto());
        assertEquals(2, item1.getQuantidade());
        assertEquals(200.0, item1.getPrecoTotal());

        ItemPedido item2 = itens.get(1);
        assertEquals(produto2, item2.getProduto());
        assertEquals(1, item2.getQuantidade());
        assertEquals(50.0, item2.getPrecoTotal());

        assertEquals(250.0, pedidos.getPrecoTotal());
    }

    @Test
    public void testEstadoInicial() {
        assertEquals(EstadoPedido.NOVO, pedidos.getEstado());
    }

    @Test
    public void testSetEstado() {
        pedidos.setEstado(EstadoPedido.PROCESSANDO);
        assertEquals(EstadoPedido.PROCESSANDO, pedidos.getEstado());
    }

}
