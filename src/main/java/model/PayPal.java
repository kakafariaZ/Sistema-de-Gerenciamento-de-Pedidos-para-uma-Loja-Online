package model;

public class PayPal implements Pagamento {
    private String emailPayPal;
    private String senhaPayPal;


    @Override
    public boolean processarPagamento() {
        return true;
        
    }

    public PayPal(String emailPayPal, String senhaPayPal){
        this.emailPayPal = emailPayPal;
        this.senhaPayPal = senhaPayPal;

    }


}
