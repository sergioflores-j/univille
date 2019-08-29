import random

# printa os dados da memória
def printMemoria():
  for i in range(len(memoria)):
    if (i % 10 == 0 and i != 0):
      print()
    print(memoria[i], end='|')
  print()

# retorna o valor de um indice em uma lista
# (se existir)
def getByIndex(list, index):
  try:
    return list[index]
  except:
    return -1

def printMenu(programa, tamanho, executado = False):
  print()

  # caso o menu ainda não tenha sido mostrado, mostra dados do programa
  if not executado:
    print('-------Execução-------')
    print('Programa:', programa)
    print('Tamanho:', tamanho)

  print('\nDeseja continuar e executar este programa? [s - Sim (padrão), n - Não, parar a execução, o - Mostrar memória]')
  executar = input()

  if executar == 'n': 
    return True
  elif executar == 'o':
    print('Memória:')
    # mostra os dados da memória atual
    printMemoria()
    return printMenu(programa, tamanho, True)
  
  return False


# variaveis globais
identificadorMemoriaLivre = '  '
tamanhoMemoriaTotal = 100
memoria = [identificadorMemoriaLivre] * tamanhoMemoriaTotal
espacosLivres = []
programas = [
  { "id": "p1", "tamanho": random.randint(1, 6) },
  { "id": "p2", "tamanho": random.randint(1, 6) },
  { "id": "p3", "tamanho": random.randint(1, 6) },
  { "id": "p4", "tamanho": random.randint(1, 6) },
  { "id": "p5", "tamanho": random.randint(1, 6) },
]

# monta a memória
for i in range(tamanhoMemoriaTotal):
  if(random.randint(0, 11) >= 5):
    memoria[i] = 'pX'
  else:
    memoria[i] = identificadorMemoriaLivre

# começa o programa
for programa in programas:
  tamanho = programa["tamanho"]
  letra = programa["id"]

  isBreak = printMenu(letra, tamanho)

  # Caso seja para parar o programa 
  if isBreak: 
    break
  
  # Varre a memória para encontrar os espaços livres (buracos)
  espacosLivres = []
  for i in range(len(memoria)):
    if (memoria[i] == identificadorMemoriaLivre):
      espacosLivres.append(i)

  # Primeira escolha (First-Fit)
  buracos = []
  for i in espacosLivres:
    # pega o valor do ultimo buraco (indice vazio)
    ultimoBuraco = getByIndex(buracos, len(buracos) - 1)

    # se a lista estiver vazia, será -1
    if (ultimoBuraco == -1):
      ultimoBuraco = 999

    # atribui um buraco novo caso:
    # - seja um indice ao lado do anterior
    # - seja o primeiro
    if (
        i - 1 == ultimoBuraco
        or ultimoBuraco == 999
    ):
      buracos.append(i)
    else:
      # caso não satisfaça uma das condições anteriores:
      # - limpa a lista e atribui o novo indice
      buracos = []
      buracos.append(i)

    # caso tenha encontrado o tamanho necessário de indices livres lado a lado
    # para o tamanho da informação, atribui a letra à memória nos mesmos e finaliza (first-fit)
    if len(buracos) >= tamanho:
      for j in buracos:
        memoria[j] = letra
      break
    
    # caso tenha varrido a lista de espaços livres
    # e não tenha encontrado nenhum indice lado a lado que
    # satisfaça o tamanho desejado, informa como erro ao usuário
    if i == espacosLivres[len(espacosLivres) - 1]:
      print('\nERRO! Sem memória disponível para', tamanho,
            'espaços. Tente um tamanho menor!\n')

  print('Memória depois:')
  printMemoria()

print()
print('Finalizou!')
print('Memória final:')
printMemoria()