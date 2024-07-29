package model;

public class CartaoCredito implements Pagamento{
    private int parcelas;
    private String validade;
    private String numeroCartao;
    private String nomeCartao;
    private String codigoSeguranca;


    @Override
    public boolean processarPagamento() {
        return true;
       
    }

    public CartaoCredito(String validade, String numeroCartao, String nomeCartao, String codigoSeguranca){
        this.validade = validade;
        this.numeroCartao = numeroCartao;
        this.nomeCartao = nomeCartao;
        this.codigoSeguranca = codigoSeguranca;
    }
    
    


    

}
