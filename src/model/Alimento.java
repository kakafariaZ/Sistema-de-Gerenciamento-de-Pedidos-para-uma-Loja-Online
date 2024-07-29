package model;

public class Alimento extends Produto{
    private static final int TIPO = 2;
    public Alimento(String descricao, double valor) {
        super(descricao, valor);
    }
    @Override
    public String getDescricao() {
        return this.descricao;
    }
    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public boolean getStatus() {
        return this.status;
    }
    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public double getValor() {
        return this.valor;
    }
    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public int getTipo(){
        return TIPO;
    }
    
}
