package model;

public abstract class Produto{
    protected static int TIPO;
    protected String descricao;
    protected boolean status = false;
    protected double valor;


    public Produto(String descricao, double valor){
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getTipo(){
        return TIPO;
    }

    
    
}
