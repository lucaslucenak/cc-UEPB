# Questão 2 

def inserir_listra(listra):
    print(listra * 60)


inserir_listra("=")
print(" \t\t\t\t GERENCIADOR DE ESTOQUE")
inserir_listra("=")

matriz = []
marca = ['A', 'B', 'C']
# validando a entrada e coletando os dados
for i in range(3):
    validacao = False
    contador = 35
    linha = []

    print(f"Digite a quantidade disponivel da marca {''.join(marca[i:i + 1])}")
    for j in range(6):
        while validacao is False:
            entrada = input(f"Tamanho {contador}: ")
            if not entrada.isnumeric():
                print("Valor inválido, tente novamente.")
                validacao = False
            else:
                linha.append(int(entrada))
                contador += 1
                if contador > 40:
                    validacao = True
    inserir_listra('-')
    matriz.append(linha)

# Imprimindo a matriz com os valores já armazenados
print('Apresentando a matriz:')
for i in range(len(matriz)):
    print(matriz[i])

# Somar os valores das colunas e armazenar em uma lista

somas = []
for k in range(0, 6):
    somaTamanho = 0
    for f in range(0, 3):
        somaTamanho += matriz[f][k]
    somas.append(somaTamanho)

# Verificando a maior soma
maior_soma = max(somas)
numeracao = 0
for y in range(len(somas)):
    if [maior_soma] == (somas[y:y + 1]):
        for z in range(len(somas)):
            if somas[y:y + 1] == [somas[z]]:
                numeracao = (z + 35)

# Imprimindo as somas e a numeração em maior quantidade no estoque
inserir_listra('=')
print('Lista de somas: ', somas)
inserir_listra('=')
print(f'Numeração com maior quantidade em estoque é {numeracao} com {int(maior_soma)} unidades.')