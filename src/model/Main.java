package model;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        Pagamento Cartao = new CartaoCredito("2025", "5555666", "Jubileu Tavares", "222");
        pedido.setFormaPagamento(Cartao);
        
      
        
    }

}
