# Exercicios Introdução à Programação Orientada à Objetos

1. O que é um objeto?
    > É uma representação de algo que possui características e comportamentos e uma identidade própria.
1. Identifique 3 características e 3 comportamentos de um carro.
    > Caracteristicas: marca, modelo, data de fabricação.\
    > Comportamentos: ligar, andar, parar
1. No contexto de Orientação a Objetos, as características e comportamentos são chamados respectivamente de?
    > Atributos e métodos
1. Qual é o objetivo da programação orientada à objetos?
    > Orientar a programação utilizando uma abstração do mundo real.
1. O que é abstração? Cite um exemplo.
    > É uma representação de algo se preocupando apenas com suas características principais, logo, uma abstração pode ser as características e comportamentos de um carro.
1. O que é classe?
    > É a representação das caracteristicas e comportamentos dos objetos abstraídos do mundo real
1. Qual é o padrão utilizado para nomear as classes? Cite um exemplo.
    > O nome da classe deve fazer referência total ao seu objeto (atributos e métodos contidos dentro da classe) e deverá seguir o padrão PascalCase, onde a primeira letra de cada palavra deverá ser maiuscula. Exemplo: Casa
1. Qual opção apresenta corretamente o nome da classe carro elétrico?
    1. carroeletrico
    1. carroEletrico
    1. Carroeletrico
    1. CarroEletrico
    1. carro_eletrico
    > 4. CarroEletrico
1. Qual é o padrão utilizado para nomear os atributos? Cite um exemplo.
    > Deve seguir o padrão camelCase onde a primeira letra de cada palavra deve ser em maiúscula. Exemplo: dataEmissao
1. Qual opção apresenta corretamente o nome do atributo cor de fundo?
    1. CordeFundo
    1. CorDeFundo
    1. corDeFundo
    1. _cor_de_fundo
    1. _corDeFundo
    1. mCorDeFundo
    > 3. corDeFundo
1. Qual é o padrão utilizado para nomear os métodos? Cite um exemplo.
    > O nome deve especificar exatamente a ação executada pelo método, em alguns casos o nome do método deve iniciar por um verbo. Deve seguir o padrão camelCase. Exemplo: abrirJanela()
1. Qual opção apresenta corretamente o nome do método está vazio?
    1. estaVazio
    1. _estaVazio
    1. estavazio
    1. EstaVazio
    1. Estavazio
    1. Esta_vazio
    > 1. estaVazio
1. No contexto de orientação à objetos, o que é um objeto? Em que momento existe um objeto? Quando ele deixa de existir?
    > É uma instância de uma classe. @TODO
1. Qual é o objetivo do operador `new`?
    > Instanciar um objeto de uma classe (chamar o método construtor).
1. O que é o construtor? Qual é o seu objetivo? Qual deve ser o seu nome? Cite um exemplo.
    > É o método inicializador de uma classe. É utilizado para iniciar variáveis, instanciar outros objetos necessários, disparar métodos de inicialização. Seu nome deve ser igual ao da classe. Exemplo:
    ```java
    public class Pessoa {
        private String nome;
        private int idade;
        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }
    }
    ```
1. Caso o construtor da classe Aluno não for declarado, qual será o seu construtor?
    > Será o construtor padrão, sem parâmetros.
    ```java
    public class Aluno {
        public Aluno() {
            
        }
    }
    ```