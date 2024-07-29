package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Estoque implements GerirEstoque {
    private HashMap<Produto, Integer> produtos = new HashMap<>();

    public Estoque(){

    }

    
    public void getProdutos(){
        Iterator<Map.Entry<Produto, Integer>> iterador = produtos.entrySet().iterator();
        while (iterador.hasNext()){
            Map.Entry<Produto, Integer> entry = iterador.next();
            System.out.println("Produto: " + entry.getKey() + ", Quantidade: " + entry.getValue());
        }
    }
    
    public void adicionarProduto(Produto produto, int quantidade){
        if(produtos.containsKey(produto)){
            int quantidadeProduto = produtos.get(produto);
            produtos.put(produto, quantidade + quantidadeProduto);
        }else{
            produtos.put(produto, quantidade);
        }
    }
   
    public void removerProduto(Produto produto, int quantidade){
        if (produtos.containsKey(produto)){
            int quantidadeDisponivel = produtos.get(produto);
            if(quantidade >= quantidadeDisponivel){
                produtos.remove(produto);
            }else{
                produtos.replace(produto, quantidade);  
            }
        }
    }
    
    @Override
    public int getQuantidadeProduto(Produto produto) {
        System.out.println(produtos.getOrDefault(produto, 0));
        return produtos.getOrDefault(produto, 0);
      
    }

    
    @Override
    public double getValor(Produto produto) {
        return produto.getValor();
        
    }


   
    public String getDescricao(Produto produto) {
        return produto.getDescricao();
    }


    
    @Override
    public int getQuantidadePorTipo(int tipo) {
        if(tipo<=3 && tipo>=0){
            int quantidadeTotal = 0;
            for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
                Produto produto = entry.getKey();
                if (produto.getTipo() == tipo) {
                    quantidadeTotal += entry.getValue();  
                }}
            System.out.println(quantidadeTotal);        
            return quantidadeTotal;
            }
        else{
            System.out.println(0);   
            return 0;
        }    
    }


    @Override
    public int getQuantidadeTotal() {
        int quantidadeTotal = 0;
        for (int quantidade : produtos.values()) {
            quantidadeTotal += quantidade;
        }
        System.out.println(quantidadeTotal);
        return quantidadeTotal;
    }


    @Override
    public double getValorProduto(Produto produto) {
       int quantidade =  produtos.getOrDefault(produto, 0);
       return (produto.getValor() * quantidade);
    }


    @Override
    public double getValorPorTipo(int tipo) {
        double valorTotal = 0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto produto = entry.getKey();
            if (produto.getTipo() == tipo) {
                valorTotal += produto.getValor();
                  
            }}
        System.out.println(valorTotal);        
        return valorTotal;
       
    }


   
    @Override
    public double getValorTotal() {
        double valorTotal = 0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            valorTotal += produto.getValor() * quantidade;
        }
        System.out.println(valorTotal);
        return valorTotal;
    }
}
