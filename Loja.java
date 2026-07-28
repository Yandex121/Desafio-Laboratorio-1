package Desafio;

public class Loja { 
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    //construtores

    public Loja (String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int quantidadeMaxima){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeMaxima];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int quantidadeMaxima) {
        this(nome, quantidadeFuncionarios, -1, endereco, dataFundacao, quantidadeMaxima);
    }

    //get

    public String getNome(){
        return nome;
    }
    public int getQuantidadeFuncionarios(){
        return quantidadeFuncionarios;
    }
    public double getSalarioBaseFuncionario(){
        return salarioBaseFuncionario;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public Data getDataFundacao() {
        return dataFundacao;
    }    
    public Produto[] getEstoqueProdutos(){
        return estoqueProdutos;
    }
  
    //set

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios){
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }   
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario){
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }       
    public void setEstoqueProdutos(Produto[] estoqueProdutos){
        this.estoqueProdutos = estoqueProdutos;
    }
    
    //metodo toString

    @Override
    public String toString(){
        StringBuilder produtos = new StringBuilder();
        for (Produto produto : estoqueProdutos){
            if (produto != null) {
                produtos.append(produto).append("\n");
            }
        }
    
        return "Loja \n" +
               "Nome: " + nome + "\n" +
               "Funcionários: " + quantidadeFuncionarios + "\n" +
               "Salário Base: " + (salarioBaseFuncionario == -1 ? "Não definido" : salarioBaseFuncionario) + "\n" +
               "Endereço: " + endereco + "\n" +
               "Fundação: " + dataFundacao + "\n" +
               "Estoque de Produtos: " + 
               (produtos.length() > 0 ? produtos.toString() : "Sem produtos no estoque") + 
               "\n";
    }
    
    //metodo gastosComSalario

    public double gastosComSalario(){
        if (salarioBaseFuncionario == -1){
            return -1;
        }
        return quantidadeFuncionarios * salarioBaseFuncionario;    
    }

    //metodo tamanhoDaLoja

    public char tamanhoDaLoja(){
        if (quantidadeFuncionarios < 10){
            return 'P';
        } else if (quantidadeFuncionarios <= 30){
            return 'M';
        } else{
            return 'G';
        }    
    }

    //Método imprimeProdutos

    public void imprimeProdutos(){
        System.out.println("Produtos no estoque:");
        for (Produto produto : estoqueProdutos) {
            if (produto != null) {
                System.out.println(produto);
            }
        }
    }
    //Método insereProduto

    public boolean insereProduto(Produto produto){
        for (int i = 0; i < estoqueProdutos.length; i++){
            if (estoqueProdutos[i] == null){
                estoqueProdutos[i] = produto;
                return true;
            } 
        }
        return false;
    }
     
    //Método removeProduto
   
    public boolean removeProduto(String nomeProduto){
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nomeProduto)) {
                estoqueProdutos[i] = null; 
                return true; 
            }
        }
        return false;
    }
}

