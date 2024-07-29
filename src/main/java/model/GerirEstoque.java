package model;

public interface GerirEstoque {
    public int getQuantidadeProduto(Produto produto); // Pega a quantidade de um produto específico
    public int getQuantidadePorTipo(int tipo);  //Pega a quantidade dos produtos de um tipo específico (alimentos, eletronicos ou roupas)
    public int getQuantidadeTotal(); //Pega a quantidade de produtos no estoque
    public double getValorProduto(Produto produto); // Pega a soma dos valores de cada produto desse em estoque
    public double getValorPorTipo(int tipo); // Pega a soma dos valores dos produtos de cada tipo (alimentos, eletronicos, roupas)
    public double getValorTotal(); // Pega a soma dos valores de todos os produtos em estoque 
    public double getValor(Produto produto); // Pega o valor de um produto em específico 
}
