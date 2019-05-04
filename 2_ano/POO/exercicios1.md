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

    ```
    4. CarroEletrico
    ```
1. Qual é o padrão utilizado para nomear os atributos? Cite um exemplo.
    > Deve seguir o padrão camelCase onde a primeira letra de cada palavra deve ser em maiúscula. Exemplo: dataEmissao
1. Qual opção apresenta corretamente o nome do atributo cor de fundo?
    1. CordeFundo
    1. CorDeFundo
    1. corDeFundo
    1. _cor_de_fundo
    1. _corDeFundo
    1. mCorDeFundo
    
    ```
    3. corDeFundo
    ```
1. Qual é o padrão utilizado para nomear os métodos? Cite um exemplo.
    > O nome deve especificar exatamente a ação executada pelo método, em alguns casos o nome do método deve iniciar por um verbo. Deve seguir o padrão camelCase. Exemplo: abrirJanela()
1. Qual opção apresenta corretamente o nome do método está vazio?
    1. estaVazio
    1. _estaVazio
    1. estavazio
    1. EstaVazio
    1. Estavazio
    1. Esta_vazio

    ``` 
    1. estaVazio
    ```
1. No contexto de orientação à objetos, o que é um objeto? Em que momento existe um objeto? Quando ele deixa de existir?
    > É uma instância de uma classe. Existe a partir do momento em que é instanciado a classe. Deixa de existir quando o programa é finalizado ou o objeto é excluído da memória.
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
1. Crie um exemplo de instanciação da classe Aluno. Utilize o construtor padrão
    ```java
    // Aluno.java
    public class Aluno {
        public String nome;
        public String matricula;

        public Aluno() {

        }
    }

    // Main.java
    public class Main {
        public static void main(String[] args) {
            public Aluno aluno = new Aluno();
        }
    }
    ```
1. O que é encapsulamento?
    > Encapsulamento vem de encapsular, ou seja, separar o programa em partes, o mais isolado possível. E, serve para controlar o acesso aos atributos e métodos de uma classe.
1. Qual é o objetivo do modificador de acesso public?
    > Possibilitar o acesso de algo (atributo, método, ...) de dentro de uma classe de forma pública.
1. Qual é o objetivo do modificador de acesso private?
    > Bloquear o acesso de algo (atributo, método, ...) de dentro de uma classe por outra classe externa.
1. Como é aplicado o encapsulamento em uma classe? Considere a classe Aluno com o atributo matrícula.
    > É colocado os atributos da classe de forma `private`, para que não haja acesso externo direto, e é criado métodos de acesso para alteração e busca (get e set).

    ```java
    public class Aluno {
        private String matricula;

        public String getMatricula() {
            return this.matricula;
        }
        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }
    }
    ```
1. Qual o objetivo dos métodos getters? Crie um exemplo
    > Criar um meio de acesso para visualização do conteúdo de um atributo privado. Exemplo:
    ```java
    public class Aluno {
        private String matricula;

        public String getMatricula() {
            return this.matricula;
        }
    }
    ```
1. Qual o objetivo dos métodos setters? Crie um exemplo.
    > Criar um meio de acesso para alteração do conteúdo de um atributo privado. Exemplo:
    ```java
    public class Aluno {
        private String matricula;

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }
    }
    ```
1. O diagrama de classe UML é composto por 3 partes. O que vai em cada parte?
    - Nome da classe
    - Atributos
    - Métodos
1. Qual é o padrão utilizado para representar um atributo no diagrama de classe UML? Crie um exemplo.
    > Utiliza-se o padrão de trazer a visibilidade (modificador de acesso) seguido pelo nome do atributo em camelCase.

    | Nome da classe |
    | -------------- |
    | - nome         |

1. Qual é o padrão utilizado para representar um método no diagrama de classe UML? Crie um exemplo.
    > Utiliza-se o padrão de trazer a visibilidade (modificador de acesso) seguido pelo nome do método em camelCase e os parenteses.
    
    | Nome da classe |
    | -------------- |
    | - nome         |
    | + getNome() <br> + setNome() |
1. Como o construtor de uma classe pode ser diferenciado no diagrama de classe UML? Crie um exemplo.
    > Utilizando o nome da classe.

    | Aluno                                       |
    | ------------------------------------------- |
    | - nome                                      |
    | + Aluno() <br> + getNome() <br> + setNome() |

    > Ou utilizando o nome `constructor`

    | Aluno                                             |
    | ------------------------------------------------- |
    | - nome                                            |
    | + constructor() <br> + getNome() <br> + setNome() |
    
1. Quais são os símbolos utilizados no diagrama de classe UML para representar os modificadores de acessos ao atributos e métodos? Crie um exemplo.
    > Os modificadores de acessos são: \
    > \+ público: visível em qualquer classe \
    > \# protegido: visivel para as classes filhas \
    > \- privado: visível somente dentro da classe \
    > \~ default: Modificador de acesso padrão, usado quando nenhum for definido. Visível para todas as classes dentro do pacote

    | Aluno                                |
    | ------------------------------------ |
    | - nome <br> + matricula <br> # idade |
1. Considere a classe Cliente, com os atributos nome, email e telefone com os respectivos métodos getters e setters. Desenvolva o diagrama de classe UML.
    | Cliente                                                                                                 |
    | ------------------------------------------------------------------------------------------------------- |
    | - nome <br> - email <br> - telefone                                                                     |
    | + getNome() <br> + setNome() <br> + getEmail() <br> + setEmail() <br> + getTelefone() <br> + setNome()  |
1. Considere a classe Cliente apresentado no Problema 29, e desenvolva o código Java correspondente.
    ```java
    public class Cliente {
        private String nome;
        private String email;
        private String telefone;

        public String getNome() {
            return this.nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getEmail() {
            return this.email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getTelefone() {
            return this.telefone;
        }
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    }
    ```