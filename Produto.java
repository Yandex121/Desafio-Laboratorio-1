package Desafio;

public class Produto {
    
    private String nome;
    private int preco;
    private Data dataValidade;

    public Produto(String nome, int preco, Data dataValidade) {
        this.dataValidade = dataValidade;
        this.nome = nome;
        this.preco = preco;
    }

    //get

    public String getNome(){
        return nome;
    }
    public int getPreco(){
        return preco;
    }
    public Data getDataValidade() {
        return dataValidade;
    }

    //set

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(int preco){
        this.preco = preco;
    }
    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    //metodo toString

    @Override
    public String toString() {
        return "Produto: " + nome +
               "\nPreço: " + preco +             
               "\nData de Validade: " + dataValidade;
    }

    //metodo estaVencido

    public Boolean estaVencido(Data dataAtual){
        if (this.dataValidade.getAno() < dataAtual.getAno()) {
            return true;
        } else if (this.dataValidade.getAno() == dataAtual.getAno()) {
            if (this.dataValidade.getMes() < dataAtual.getMes()) {
                return true;
            } else if (this.dataValidade.getMes() == dataAtual.getMes()) {
                if (this.dataValidade.getDia() < dataAtual.getDia()) {
                    return true;
                }
            }
        }
        return false;
    }
}