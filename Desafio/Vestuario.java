package Desafio;

public class Vestuario extends Loja{

    private boolean produtosImportados;

    //Construtor

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, boolean produtosImportados, int quantidadeMaxima){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaxima);
        this.produtosImportados = produtosImportados;
    }

    //Métodos de Acesso

    public boolean getProdutosImportados(){
        return produtosImportados;
    }
    public void setProdutosImportados(boolean produtosImportados){
        this.produtosImportados = produtosImportados;
    }
    
    //Método toString

    @Override
    public String toString(){
        return super.toString() + "Produtos Importados: " + produtosImportados;
    }
}
