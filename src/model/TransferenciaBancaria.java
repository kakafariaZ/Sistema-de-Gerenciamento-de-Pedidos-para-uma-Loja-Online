package model;


public class TransferenciaBancaria implements Pagamento{
    private String numeroConta;
    private String agencia;
    private String banco;


    @Override
    public boolean processarPagamento() {
        return true;
       
    }

    public TransferenciaBancaria(String numeroConta, String agencia, String banco){
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.banco = banco;
    }



}
