# Exercicios terminal Linux

1. Utilize o comando echo para imprimir seu nome no terminal.
```bash
echo "Sergio Eduardo Flores Junior"
```

1. Utilize o comando echo para salvar seu nome em um arquivo chamado cliente01.txt. Confira o resultado com o comando less.
```bash
echo "Sergio Eduardo Flores Junior" > cliente01.txt
less cliente01.txt
```

1. Utilize o comando echo para salvar o nome da cidade em que você nasceu no final do arquivo cliente01.txt.
```bash
echo "Santo Ângelo" >> cliente01.txt
```

1. Crie um novo diretório chamado clientes com o comando mkdir. Confira o resultado com o comando ls.
```bash
mkdir clientes
ls
```

1. Mova o arquivo cliente01.txt para o diretório clientes. Confira o resultado com os comandos ls e cd.
```bash
mv cliente01.txt clientes/cliente01.txt
ls
cd clientes
```

1. Crie uma cópia do arquivo cliente01.txt com o comando cp chamado cliente01.txt.bkp. Confira o resultado.
```bash
cp cliente01.txt cliente01.txt.bkp
ls
less cliente01.txt.bkp
```

1. Remova o arquivo cliente01.txt com o comando rm. Confira o resultado.
```bash
rm cliente01.txt
ls
```

1. Crie um arquivo chamado de cliente.script com todos os comandos utilizados acima, na mesma ordem de execução.
```bash
cd ..
echo "echo \"Sergio Eduardo Flores Junior\"" > cliente.script && echo "echo \"Sergio Eduardo Flores Junior\" > cliente01.txt" >> cliente.script && echo "less cliente01.txt" >> cliente.script && echo "echo \"Santo Ângelo\" >> cliente01.txt" >> cliente.script && echo "mkdir clientes" >> cliente.script && echo "ls" >> cliente.script && echo "mv cliente01.txt clientes/cliente01.txt" >> cliente.script && echo "ls" >> cliente.script && echo "cd clientes" >> cliente.script && echo "cp cliente01.txt cliente01.txt.bkp" >> cliente.script && echo "ls" >> cliente.script && echo "less cliente01.txt.bkp" >> cliente.script && echo "rm cliente01.txt" >> cliente.script && echo "ls" >> cliente.script
```

1. Modifique o arquivo cliente.script com o comando chmod para se tornar um arquivo executável. Execute o arquivo e confira o resultado. Para executar utilize o comando ./cliente.script. Obs: exclua a pasta clientes antes de executar o script para garantir que está funcionando corretamente.
```bash
chmod +x cliente.script
./cliente.script
```

1. Execute o comando cal. Observe o resultado. Execute o comando echo|cal > hoje.txt. Utilize o comandos ls e less para conferir o resultado. O que ocorreu? Qual a função do operador — ?
```bash
echo|cal > hoje.txt
ls
less
```

1. Utilize o comando wget para baixar o arquivo cidades_sc.txt no endereço https://gist.githubusercontent.com/leandersonandre/c8cba982f42262591be628e5397d1c3f/raw/bd13a3e13823708e477f99f9285f845b292714c6/cidades_sc.txt.

1. Execute o comando grep Balneario cidades_sc.txt. Qual é o resultado?

1. Execute o comando grep balneario cidades_sc.txt. Qual é o resultado?

1. Execute o comando grep ”do Sul”cidades_sc.txt. Qual é o resultado?

1. Utilize os comandos cat e grep para filtrar as cidades que começam com o nome Balneario.

1. Crie um arquivo chamado balneario.txt com o conteúdo filtrado no problema 15.

1. Compacte o arquivo balneario.txt, nomeando de compactado.tar com o comando tar.

1. Descompacte o arquivo compactado.tar com o comando tar.
