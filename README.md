# Sistema de Gerenciamento de Shopping — Desafio Java (POO)

Uma aplicação em Java que simula o cadastro e o gerenciamento de um shopping e suas lojas. Projeto desenvolvido como desafio da disciplina Laboratório I (curso de Análise e Desenvolvimento de Sistemas), com foco em Programação Orientada a Objetos: herança, polimorfismo, encapsulamento e composição.

## Visão geral

O sistema modela as seguintes entidades principais:

- Shopping: agrega várias lojas e permite operações como inserir/remover lojas e consultar informações.
- Loja: superclasse que contém dados comuns a todas as lojas (nome, funcionários, salário-base, endereço, data de fundação e estoque de produtos).
- Especializações de Loja: Cosmetico, Vestuario, Bijuteria, Alimentacao e Informatica (cada uma com atributos específicos).
- Produto: representa um item do estoque, com nome, preço e data de validade.
- Endereco e Data: classes auxiliares para modelar endereço e validar/manipular datas.

O repositório inclui também uma classe `Principal` para execução interativa via console e `ValidadorEtapa4`, que executa uma bateria de testes manuais imprimindo `[OK]`/`[NOK]` no console.

## Principais funcionalidades

- Cadastro de lojas e produtos (arrays de capacidade fixa definidas na criação das instâncias).
- Remoção de lojas e produtos por nome.
- Classificação do tamanho da loja por número de funcionários (P/M/G).
- Cálculo de gastos com salários (com tratamento para salário não informado).
- Verificação de validade de produtos a partir de sua data de validade.
- Localização da loja de informática com o seguro de eletrônicos mais caro.

## Modelagem das classes

```mermaid
classDiagram
    class Endereco {
        -String nomeDaRua
        -String cidade
        -String estado
        -String pais
        -String cep
        -String numero
        -String complemento
        +toString() String
    }

    class Data {
        -int dia
        -int mes
        -int ano
        +verificaAnoBissexto() boolean
        -dataValida(dia, mes, ano) boolean
        +toString() String
    }

    class Produto {
        -String nome
        -int preco
        -Data dataValidade
        +estaVencido(Data dataAtual) Boolean
        +toString() String
    }

    class Loja {
        -String nome
        -int quantidadeFuncionarios
        -double salarioBaseFuncionario
        -Endereco endereco
        -Data dataFundacao
        -Produto[] estoqueProdutos
        +gastosComSalario() double
        +tamanhoDaLoja() char
        +insereProduto(Produto) boolean
        +removeProduto(String) boolean
        +imprimeProdutos() void
        +toString() String
    }

    class Cosmetico {
        -double taxaComercializacao
    }
    class Vestuario {
        -boolean produtosImportados
    }
    class Bijuteria {
        -double metaVendas
    }
    class Alimentacao {
        -Data dataAlvara
    }
    class Informatica {
        -double seguroEletronicos
    }

    class Shopping {
        -String nome
        -Endereco endereco
        -Loja[] lojas
        +insereLoja(Loja) boolean
        +removeLoja(String) boolean
        +quantidadeLojasPorTipo(String) int
        +lojaSeguroMaisCaro() Informatica
        +toString() String
    }

    Loja <|-- Cosmetico
    Loja <|-- Vestuario
    Loja <|-- Bijuteria
    Loja <|-- Alimentacao
    Loja <|-- Informatica

    Loja "1" *-- "1" Endereco
    Loja "1" *-- "1" Data
    Loja "1" *-- "0..*" Produto
    Produto "1" *-- "1" Data
    Shopping "1" *-- "1" Endereco
    Shopping "1" *-- "0..*" Loja
```

### Descrição das classes

| Classe | Responsabilidade |
|---|---|
| `Endereco` | Representa o endereço completo (rua, número, complemento, cidade, estado, país e CEP) de uma loja ou shopping. |
| `Data` | Representa uma data (dia/mês/ano) com validação e verificação de ano bissexto. Datas inválidas recebem `01/01/2000` por padrão. |
| `Produto` | Representa um produto do estoque, com nome, preço e data de validade; inclui método para verificar se está vencido. |
| `Loja` | Superclasse que contém dados comuns a qualquer loja e operações básicas sobre estoque e funcionários. |
| `Cosmetico` | Especialização de `Loja` com taxa de comercialização. |
| `Vestuario` | Especialização de `Loja` com indicador de produtos importados. |
| `Bijuteria` | Especialização de `Loja` com meta de vendas. |
| `Alimentacao` | Especialização de `Loja` com data do alvará sanitário. |
| `Informatica` | Especialização de `Loja` com valor do seguro de eletrônicos. |
| `Shopping` | Agrega várias lojas (array de tamanho fixo) e implementa consultas/operações sobre o conjunto de lojas. |
| `Principal` | Ponto de entrada interativo (menu via `Scanner`) para cadastrar lojas e produtos. |
| `ValidadorEtapa4` | Suíte de testes manuais que instancia e exercita métodos das classes, reportando `[OK]`/`[NOK]`. |

## Regras de negócio implementadas

- Datas inválidas (dia/mês fora do intervalo, considerando ano bissexto) recebem `01/01/2000`.
- Se o salário-base for omitido ao criar a loja, o valor será `-1` e exibido como "Não definido"; `gastosComSalario()` retorna `-1` nesse caso.
- `tamanhoDaLoja()` classifica a loja por número de funcionários: `P` (até 9), `M` (10 a 30), `G` (acima de 30).
- `insereProduto` e `insereLoja` retornam `false` quando o array atingiu sua capacidade (capacidade fixa). 
- `estaVencido` compara ano &rarr; mês &rarr; dia para determinar se um produto está vencido.
- `lojaSeguroMaisCaro` retorna a loja de `Informatica` com maior valor de seguro.

## Estrutura do projeto

```
Etapa_4/
└── Desafio/
    ├── Principal.java         # Menu interativo (cadastro de lojas e produtos)
    ├── ValidadorEtapa4.java   # Suíte de testes manuais de todas as classes
    ├── Shopping.java
    ├── Loja.java
    ├── Cosmetico.java
    ├── Vestuario.java
    ├── Bijuteria.java
    ├── Alimentacao.java
    ├── Informatica.java
    ├── Produto.java
    ├── Endereco.java
    └── Data.java
```

## Como compilar e executar

Requer JDK 8 ou superior.

```bash
# a partir da pasta Etapa_4
javac Desafio/*.java

# executar o menu interativo
java Desafio.Principal

# executar a suíte de validação/testes
java Desafio.ValidadorEtapa4
```

Dica: se preferir, abra a pasta `Etapa_4/Desafio` em uma IDE (Eclipse, IntelliJ, VS Code) e configure o projeto como aplicação Java para executar as classes `Principal` ou `ValidadorEtapa4` diretamente.

## Tecnologias

- Java (POO: herança, polimorfismo, encapsulamento, composição, sobrecarga de construtores)
- Entrada de dados via `java.util.Scanner`

## Contexto acadêmico

Repositório desenvolvido para fins educacionais como parte do desafio da disciplina Laboratório I do curso de Análise e Desenvolvimento de Sistemas.

## Contribuições

Contribuições não são necessárias, mas sugestões são bem-vindas para melhorar a clareza dos exemplos ou adicionar testes automatizados.

## Licença

Projeto de fins educacionais/acadêmicos.
