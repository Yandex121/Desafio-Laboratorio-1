package Desafio;

public class Cosmetico extends Loja{

    private double taxaComercializacao;

    //Construtor

    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, double taxaComercializacao, int quantidadeMaxima){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaxima);
        this.taxaComercializacao = taxaComercializacao;
    }

    //Métodos de Acesso

    public double getTaxaComercializacao(){
        return taxaComercializacao;
    }
    public void setTaxaComercializacao(double taxaComercializacao){
        this.taxaComercializacao = taxaComercializacao;
    }

    //Método toString

    @Override
    public String toString(){
        return super.toString() + "Taxa de Comercialização: " + taxaComercializacao;
    }
}
