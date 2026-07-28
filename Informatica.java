package Desafio;

public class Informatica extends Loja{

    private double seguroEletronicos;

    //Construtor

    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int quantidadeMaxima, double seguroEletronicos){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaxima);
        this.seguroEletronicos = seguroEletronicos;
    }
    
    //Métodos de Acesso

    public double getSeguroEletronicos(){
        return seguroEletronicos;
    }
    public void setSeguroEletronicos(double seguroEletronicos){
        this.seguroEletronicos = seguroEletronicos;
    }

    //Método toString

    @Override
    public String toString(){
        return super.toString() + "Seguro Eletrônicos: " + seguroEletronicos;
    }
}
