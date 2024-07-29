package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pedido {
    private final static int NOVO = 0;
    private final static int PROCESSANDO = 1;
    private final static int ENVIADO = 2;
    private final static int ENTREGUE = 3;
    private HashMap<Produto, Integer> produtos;
    private int status;
    private Pagamento formaPagamento;
    private double valorPedido;

    public Pedido(){

    }

    public int getStatus(){
        return this.status;
    }

    public Pagamento getFormaPagamento(){
        return this.formaPagamento;
    }

    public void setFormaPagamento(Pagamento pagamento){
        this.formaPagamento = pagamento;

    }

    public void setStatus(int status){
        switch (status){
            case 0:
                this.status = NOVO;
            case 1:
                this.status = PROCESSANDO;
            case 2:
                this.status = ENVIADO;
            case 3: 
                this.status = ENTREGUE;
            default:
                System.out.println("ERRO setStatus");
        }
    }
     public void getProdutos(){
        Iterator<Map.Entry<Produto, Integer>> iterador = produtos.entrySet().iterator();
        while (iterador.hasNext()){
            Map.Entry<Produto, Integer> entry = iterador.next();
            System.out.println("Produto: " + entry.getKey() + ", Quantidade: " + entry.getValue());
        }
    }
    public double getValorTotal(){
        double valorTotal = 0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            valorTotal += produto.getValor() * quantidade;
        }
        this.valorPedido = valorTotal;
       
        return valorPedido;
    }
    








}
