package model;

import java.util.ArrayList;
import java.util.List;

enum EstadoPedido {
    NOVO,
    PROCESSANDO,
    ENVIADO,
    ENTREGUE
}

class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoTotal;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = produto.getPreco() * quantidade;
    }

    // Getters e Setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}

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
