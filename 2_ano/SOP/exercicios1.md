# Exercicios terminal Linux

1. Utilize o comando echo para imprimir seu nome no terminal.
```bash
echo "Sergio Eduardo Flores Junior"
```

2. Utilize o comando echo para salvar seu nome em um arquivo chamado cliente01.txt. Confira o resultado com o comando less.
```bash
echo "Sergio Eduardo Flores Junior" > cliente01.txt
less cliente01.txt
```

3. Utilize o comando echo para salvar o nome da cidade em que você nasceu no final do arquivo cliente01.txt.
```bash
echo "Santo Ângelo" >> cliente01.txt
```

4. Crie um novo diretório chamado clientes com o comando mkdir. Confira o resultado com o comando ls.
```bash
mkdir clientes
ls
```

5. Mova o arquivo cliente01.txt para o diretório clientes. Confira o resultado com os comandos ls e cd.
```bash
mv cliente01.txt clientes/cliente01.txt
ls
cd clientes
```

6. Crie uma cópia do arquivo cliente01.txt com o comando cp chamado cliente01.txt.bkp. Confira o resultado.
```bash
cp cliente01.txt cliente01.txt.bkp
ls
less cliente01.txt.bkp
```

7. Remova o arquivo cliente01.txt com o comando rm. Confira o resultado.
```bash
rm cliente01.txt
ls
```

8. Crie um arquivo chamado de cliente.script com todos os comandos utilizados acima, na mesma ordem de execução.
```bash
cd ..
echo "echo \"Sergio Eduardo Flores Junior\"" > cliente.script && echo "echo \"Sergio Eduardo Flores Junior\" > cliente01.txt" >> cliente.script && echo "less cliente01.txt" >> cliente.script && echo "echo \"Santo Ângelo\" >> cliente01.txt" >> cliente.script && echo "mkdir clientes" >> cliente.script && echo "ls" >> cliente.script && echo "mv cliente01.txt clientes/cliente01.txt" >> cliente.script && echo "ls" >> cliente.script && echo "cd clientes" >> cliente.script && echo "cp cliente01.txt cliente01.txt.bkp" >> cliente.script && echo "ls" >> cliente.script && echo "less cliente01.txt.bkp" >> cliente.script && echo "rm cliente01.txt" >> cliente.script && echo "ls" >> cliente.script
```

9. Modifique o arquivo cliente.script com o comando chmod para se tornar um arquivo executável. Execute o arquivo e confira o resultado. Para executar utilize o comando ./cliente.script. Obs: exclua a pasta clientes antes de executar o script para garantir que está funcionando corretamente.
```bash
chmod +x cliente.script
rmdir clientes
./cliente.script
```

10. Execute o comando cal. Observe o resultado. Execute o comando echo|cal > hoje.txt. Utilize o comandos ls e less para conferir o resultado. O que ocorreu? Qual a função do operador | ?
```bash
cal
echo | cal > hoje.txt
ls
less hoje.txt
```
```
O operador | (pipe) envia o resultado do comando anterior ao próximo.
```

11. Utilize o comando wget para baixar o arquivo cidades_sc.txt no endereço https://gist.githubusercontent.com/leandersonandre/c8cba982f42262591be628e5397d1c3f/raw/bd13a3e13823708e477f99f9285f845b292714c6/cidades_sc.txt.
```bash
wget https://gist.githubusercontent.com/leandersonandre/c8cba982f42262591be628e5397d1c3f/raw/bd13a3e13823708e477f99f9285f845b292714c6/cidades_sc.txt
```

12. Execute o comando grep Balneario cidades_sc.txt. Qual é o resultado?
```bash
~$ grep Balneario cidades_sc.txt
```
```
Balneario Arroio do Silva
Balneario Barra do Sul
Balneario Camboriu
Balneario Gaivota
```
R:
```
O resultado do grep será os textos(cidades) que possuem a palavra Balneario. 
```

13. Execute o comando grep balneario cidades_sc.txt. Qual é o resultado?
```bash
~$ grep balneario cidades_sc.txt
```
R:
```
O resultado do grep será os textos(cidades) que possuem a palavra balneario (case sensitive). 
```

14. Execute o comando grep ”do Sul”cidades_sc.txt. Qual é o resultado?
```bash
~$ grep "do Sul" cidades_sc.txt
```
```
Balneario Barra do Sul
Bocaina do Sul
Campo Belo do Sul
Caxambu do Sul
Cocal do Sul
Formosa do Sul
Guaruja do Sul
Jaragua do Sul
Lindoia do Sul
Rio do Sul
Santa Rosa do Sul
Santiago do Sul
Sao Bento do Sul
Sao Cristovao do Sul
Sao Francisco do Sul
Sao Joao do Sul
Timbe do Sul
```

15. Utilize os comandos cat e grep para filtrar as cidades que começam com o nome Balneario.
```bash
cat cidades_sc.txt | grep Balneario
```

16. Crie um arquivo chamado balneario.txt com o conteúdo filtrado no problema 15.
```bash
cat cidades_sc.txt | grep Balneario > balneario.txt
```

17. Compacte o arquivo balneario.txt, nomeando de compactado.tar com o comando tar.
```bash
tar -cf compactado.tar balneario.txt
```

18. Descompacte o arquivo compactado.tar com o comando tar.
```bash
tar -xf compactado.tar
```

# Exercícios Shell Script

1. Crie um script que solicite ao usuário digitar o seu nome e imprime o conteúdo no terminal.

```shell
#!/bin/bash

echo -n "Digite seu nome: "
read name
echo "Bom dia $name"
```

2. Crie um script que multiplique dois números que o usuário informar.

```shell
#!/bin/bash

echo -n "Digite o primeiro número: "
read n1
echo -n "Digite o segundo número: "
read n2
res=$[$n1*$n2]
echo "O resultado é $res"
```

3. Crie um script que identifique se o usuário informou um número positivo, negativo ou zero.
```shell
#!/bin/bash
echo -n "Digite o número: "
read number

if [ $number -gt 0 ]; then
    echo "Positivo"
elif [ $number -eq 0 ]; then
    echo "Zero"
else
    echo "Negativo"
fi
```

4. Crie um script resolva a tabuada do número informado pelo usuário.
```shell
#!/bin/bash
echo -n "Digite o número: "
read number

c=0
while [ $c -lt 11 ]; do
    r=$[$number*$c]
    echo "$number x $c = $r" 
    c=$[$c+1]
done
```

5. Crie um script que apresente duas opções ao usuário. A primeira opção deverá mostrar o calendário. A segunda opção deve mostrar a lista de arquivos do diretório.
```shell
#!/bin/bash
o1="Mostrar calendário"
o2="Mostrar lista de arquivos do diretório"
echo -e "Opções: \n[1] $o1 \n[2] $o2"
echo -n "Digite a opção: "
read option

if [ $option -eq 1 ]; then
    echo -e "\n$o1\n"
    cal
elif [ $option -eq 2 ]; then
    echo -e "\n$o2\n"
    ls
else 
    echo -e "\nOpção inválida"
fi
```