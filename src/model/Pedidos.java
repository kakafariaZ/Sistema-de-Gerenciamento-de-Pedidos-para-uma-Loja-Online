package model;

import java.util.ArrayList;
import java.util.List;


public class Pedidos {
    private List<ItemPedido> itens;
    private double precoTotal;
    private EstadoPedido estado;

    public Pedidos() {
        this.itens = new ArrayList<>();
        this.estado = EstadoPedido.NOVO;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
        calcularPrecoTotal();
    }

    private void calcularPrecoTotal() {
        this.precoTotal = itens.stream().mapToDouble(ItemPedido::getPrecoTotal).sum();
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
