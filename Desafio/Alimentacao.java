package Desafio;

public class Alimentacao extends Loja{

    private Data dataAlvara;

    //Construtor

    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, Data dataAlvara, int quantidadeMaxima){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaxima);
        this.dataAlvara = dataAlvara;
    }

    //Métodos de Acesso

    public Data getDataAlvara() {
        return dataAlvara;
    }
    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    //Método toString

    @Override
    public String toString(){
        return super.toString() + "Data do Alvará: " + dataAlvara;
    }
}
