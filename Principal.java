package Desafio;

import java.util.Scanner;

public class Principal{ 
   
    //Método Main
    public static void main(String [] args){
    
        //Scanner

        Scanner sc = new Scanner(System.in);
    
        //Variáveis Main

        Loja loja = null;
        Produto produto = null;
        int opcao;
        int tipo;
        
        //Menu

        do{          
            System.out.println("\n--- Menu ---");
            System.out.println();
            System.out.println(" 1 - Criar Loja ");
            System.out.println(" 2 - Criar Produto ");
            System.out.println(" 3 - Sair ");
            System.out.println();
            System.out.println(" Escolha uma Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            //Inserir dados

            switch (opcao) {
                
                //Dados da loja

                case 1:
                    System.out.println("\n--- Cadastro da Loja --- ");
                    System.out.println();
                    System.out.println("Digite as informações");
                    System.out.println("\nNome da loja: ");
                    String nomeLoja = sc.nextLine();

                    System.out.println("Quantidade de funcionários: ");
                    int qtdFunc = sc.nextInt();

                    System.out.println("Salário base dos funcionários: ");
                    double salarioBaseFuncionario = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("-- Endereço --");
                    System.out.println("Rua: ");
                    String rua = sc.nextLine();

                    System.out.println("Número: ");
                    String numero = sc.nextLine();

                    System.out.println("Complemento: ");
                    String complemento = sc.nextLine();

                    System.out.println("Cidade: ");
                    String cidade = sc.nextLine();

                    System.out.println("Estado: ");
                    String estado = sc.nextLine();

                    System.out.println("País: ");
                    String pais = sc.nextLine();

                    System.out.println("CEP: ");
                    String cep = sc.nextLine();

                    System.out.println("-- Data de fundação --");
                    System.out.println("Dia: ");
                    int diaFund = sc.nextInt();

                    System.out.println("Mês: ");
                    int mesFund = sc.nextInt();

                    System.out.println("Ano: ");
                    int anoFund = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Quantidade máxima de produtos no estoque: ");
                    int quantidadeMaxima = sc.nextInt();
                    sc.nextLine();
                    
                    Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);
                    Data dataFundacao = new Data(diaFund, mesFund, anoFund);

                    System.out.println("Tipo de Loja:");
                    System.out.println();
                    System.out.println(" 1 - Cosmético ");
                    System.out.println(" 2 - Vestuário ");
                    System.out.println(" 3 - Bijuteria ");
                    System.out.println(" 4 - Alimentação ");
                    System.out.println(" 5 - Informática ");
                    System.out.println();
                    System.out.println(" Escolha uma Opção: ");
                    tipo = sc.nextInt();
                    sc.nextLine();

                    String tipoStr = null;

                    switch (tipo) {
    
                    case 1: // Cosmético
                        System.out.print("Taxa de comercialização (%): ");
                        double taxaComercializacao = sc.nextDouble();
                        sc.nextLine();
                        loja = new Cosmetico(nomeLoja, qtdFunc, salarioBaseFuncionario, endereco, dataFundacao, taxaComercializacao, quantidadeMaxima);
                        break;

                    case 2: // Vestuário
                        System.out.print("Produtos importados? (true/false): ");
                        boolean produtosImportados = sc.nextBoolean();
                        sc.nextLine();
                        loja = new Vestuario(nomeLoja, qtdFunc, salarioBaseFuncionario, endereco, dataFundacao, produtosImportados, quantidadeMaxima);
                        break;

                    case 3: // Bijuteria
                        System.out.print("Meta de vendas: ");
                        double metaVendas = sc.nextDouble();
                        loja = new Bijuteria(nomeLoja, qtdFunc, salarioBaseFuncionario, endereco, dataFundacao, metaVendas, quantidadeMaxima);
                        break;

                    case 4: // Alimentação
                        System.out.println("-- Data do Alvará Sanitário --");
                        System.out.print("Dia: ");
                        int diaAlvara = sc.nextInt();
                        System.out.print("Mês: ");
                        int mesAlvara = sc.nextInt();
                        System.out.print("Ano: ");
                        int anoAlvara = sc.nextInt();
                        sc.nextLine();
                        Data dataAlvara = new Data(diaAlvara, mesAlvara, anoAlvara);
                        loja = new Alimentacao(nomeLoja, qtdFunc, salarioBaseFuncionario, endereco, dataFundacao, dataAlvara, quantidadeMaxima);
                        break;

                    case 5: // Informática
                        System.out.print("Valor do seguro de eletrônicos: ");
                        double seguroEletronicos = sc.nextDouble();
                        sc.nextLine();
                        loja = new Informatica(nomeLoja, qtdFunc, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaxima, seguroEletronicos);
                        break;

                    default:
                        System.out.println("Tipo inválido.");
                        return;
                }
                
                System.out.println("Loja cadastrada com sucesso!");

                break;
               
                //Dados do Produto

                case 2:
                    System.out.println("\n--- Cadastro do Produto ---");
                    System.out.println("Nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.println("Preço: ");
                    int preco = sc.nextInt();

                    System.out.println("Data de validade:");
                    System.out.println("Dia: ");
                    int diaVal = sc.nextInt();

                    System.out.println("Mês: ");
                    int mesVal = sc.nextInt();

                    System.out.println("Ano: ");
                    int anoVal = sc.nextInt();
                    sc.nextLine();

                    Data validade = new Data(diaVal, mesVal, anoVal);
                    produto = new Produto(nomeProduto, preco, validade);
                    System.out.println("Produto criado com sucesso!!");
                    
                    break;
                
                case 3:
                    System.out.println("Saindo do programa");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        
        } while (opcao != 3);
    
        //Teste Produto Vencido

        if (loja != null && produto != null) {
            Data dataReferencia = new Data(20, 10, 2023);

            System.out.println("\n--- RESULTADO FINAL ---");
            if (produto.estaVencido(dataReferencia)) {
                System.out.println("PRODUTO VENCIDO");
            } else {
                System.out.println("PRODUTO NÃO VENCIDO");
            }
            
            //Imprime informações da loja

            System.out.println("\nInformações da Loja:");
            System.out.println("----------");
            System.out.println(loja);
            System.out.println("----------");
            System.out.println("Endereço: ");
            System.out.println("----------");
            System.out.println(loja.getEndereco());
            System.out.println("----------");
            System.out.println("Fundação: ");
            System.out.println("----------");
            System.out.println(loja.getDataFundacao());
        }
        sc.close();
    }
}