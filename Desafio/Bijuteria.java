package Desafio;

public class Bijuteria extends Loja{

    private double metaVendas;

    //Construtor

    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,Data dataFundacao, double metaVendas, int quantidadeMaxima){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaxima);
        this.metaVendas = metaVendas;
    }

    //Métodos de Acesso

    public double getMetaVendas(){
        return metaVendas;
    }
    public void setMetaVendas(double metaVendas){
        this.metaVendas = metaVendas;
    }
    
    //Método toString

    @Override
    public String toString(){
        return super.toString() + "Meta de Vendas: " + metaVendas;
    }
}
