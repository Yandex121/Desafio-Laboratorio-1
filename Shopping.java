package Desafio;

public class Shopping{

    private String nome;
    private Endereco endereco;
    private Loja[] lojas;
    
    //Construtor

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }
    
    //Get

    public String getNome(){
        return nome;
    }
    public Endereco getEndereco(){
        return endereco;
    }
    public Loja[] getLojas(){
        return lojas;
    }
   
    //Set
   
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public void setLojas(Loja[] lojas){
        this.lojas = lojas;
    }

    //Método toString

    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Endereco: ").append(endereco).append("\n");
        sb.append("Lojas: \n");
        for (Loja loja : lojas){
            if (loja != null){
                sb.append(loja).append("\n");
            }
        }
    return sb.toString();
    }

    //Método insereLoja

    public boolean insereLoja(Loja loja){
        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] == null){
                lojas[i] = loja;
                return true;
            } 
        }
        return false;
    }

    //Método removeLoja
   
    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null; 
                return true; 
            }
        }
        return false; 
    }

    //Método quantidadeLojasPorTipo

    public int quantidadeLojasPorTipo(String tipoLoja){
        int contagem = 0;

        for (Loja loja : lojas){
            if (loja != null){
                switch (tipoLoja){
                    case "Cosmético":
                        if (loja instanceof Cosmetico) contagem ++;
                        break;
                    case "Vestuário":
                        if (loja instanceof Vestuario) contagem ++;
                        break;
                    case "Bijuteria":
                        if (loja instanceof Bijuteria) contagem ++;
                        break;
                    case "Alimentação":
                        if (loja instanceof Alimentacao) contagem ++;
                        break;
                    case "Informática":
                        if (loja instanceof Informatica) contagem ++;
                        break; 
                    default:
                        return -1;       
                }
            }
        }
        return contagem;
    }

    //Método lojaSeguroMaisCaro

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorSeguro = -1;
        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica informatica = (Informatica) loja;
                if (informatica.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = informatica.getSeguroEletronicos();
                    lojaMaisCara = informatica;
                }
            }
        }
        return lojaMaisCara;
    }
}
