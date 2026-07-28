package Desafio;

public class Data {

    private int dia, mes, ano;

    //construtor

    public Data(int dia, int mes, int ano){
        if (dataValida(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else{
            System.out.println("Data Inválida! Data padrão atribuída: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    //get

    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAno() {
        return ano;
    }

    //set

    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    //metodo toString

    @Override
    public String toString(){
        return "[" + dia + "/" + mes + "/" + ano + "]";
    }

    //metodo verificaAnoBissexto

    public boolean verificaAnoBissexto(){
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    //metodo dataValida

    private boolean dataValida(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12 ) return false;
        int[] diasPorMes = {31, verificaAnoBissexto() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return dia > 0 && dia <= diasPorMes[mes - 1];
    }
}
