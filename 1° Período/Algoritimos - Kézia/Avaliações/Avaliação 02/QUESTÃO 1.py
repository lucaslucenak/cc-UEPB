# QUESTÃO 1

# ------------------------- funções ------------------------- #

def inserir_linha(linha):
    print(linha * 60)


def inserir_zeros_esquerda(bin_num):
    zeros = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    binario = zeros + bin_num
    while len(binario) > 16:
        binario.remove(0)
    return binario


def criar_sublistas(lista, quant_sublistas):
    separar = []
    tamanho_lista = len(lista)
    for j in range(quant_sublistas):
        inicio = int(j * tamanho_lista / quant_sublistas)
        fim = int((j + 1) * tamanho_lista / quant_sublistas)
        separar.append(lista[inicio:fim])
    return separar


# CONVERSOR DE BIN PARA HEX
def converter(numero):
    lista_binarios = [[0, 0, 0, 0], [0, 0, 0, 1], [0, 0, 1, 0], [0, 0, 1, 1], [0, 1, 0, 0], [0, 1, 0, 1], [0, 1, 1, 0],
                      [0, 1, 1, 1], [1, 0, 0, 0], [1, 0, 0, 1], [1, 0, 1, 0], [1, 0, 1, 1], [1, 1, 0, 0], [1, 1, 0, 1],
                      [1, 1, 1, 0], [1, 1, 1, 1]]
    lista_hexadecimal = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "A", "B", "C", "D", "E", "F"]
    for x in range(0, 4):
        for y in range(0, 16):
            recuperacao = lista_binarios.copy()
            if numero[x:x + 1] == lista_binarios[y:y + 1]:
                lista_binarios[y:y + 1] = lista_hexadecimal[y:y + 1]
                numero[x:x + 1] = lista_binarios[y:y + 1]
                lista_binarios = recuperacao
    return numero


# -------------------------- validação da entrada -------------------------- #

inserir_linha("=")
print("\tConversor de Binário para Hexadecimal")
inserir_linha("=")

# VALIDAÇÃO DA ENTRADA
num_valido = False
numero_inicial = 0
numero_binario = []

while num_valido is False:
    numero_inicial = str(input("Insira um número binário de até 16 bits: "))
    inserir_linha("-")
    # verificando se é um número e se tem até 16 bits
    if not numero_inicial.isnumeric():
        print("Não é um número. Tente novamente.")
        inserir_linha("-")
    elif len(numero_inicial) > 16:
        print("Número muito grande. Tente novamente.")
        inserir_linha("-")
    else:
        num_valido = True

    # Inserindo os dados em uma lista
    if num_valido is True:
        for i in numero_inicial:
            numero_binario.append(int(i))

        # Verificando se é um binário
        # se não for a lista é zerada
        # se for o número é mantido na lista "numero_binario"
        lista_decimais = list(range(2, 10))
        if set(numero_binario).intersection(lista_decimais):
            print("Não é um binário! Por favor, tente novamente.")
            inserir_linha("-")
            num_valido = False
            numero_binario = []
        else:
            num_valido = True

# ------------------------- executando funções ------------------------- #

numero_binario = inserir_zeros_esquerda(numero_binario)

numero_binario = criar_sublistas(numero_binario, 4)

numero_convertido = converter(numero_binario)

# transforma em str e remove os 0 a esquerda
numero_convertido = (''.join(map(str, numero_convertido))).lstrip('0')

print(f"O binário {numero_inicial} convertido em hexadecimal é: {numero_convertido}")
inserir_linha("=")
