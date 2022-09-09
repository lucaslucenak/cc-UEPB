from random import randint

listaPersonagens = ['Scorpion',
                    'Sonya Blade',
                    'Jhonny Cage',
                    'Raiden',
                    'Sub-Zero',
                    'Liu Kang',
                    'Smoke',
                    'Ednaldo Pereira',
                    'Super Xandão']


def pularLinha():
    print('-' * 60)

def pularLinha2():
    print('=' * 60)

def personagens():
    for index, personagens in enumerate(listaPersonagens):
        print(index + 1, personagens)

print('Jogo RPG DAHORA')
personagens()

pularLinha2()

jogador1 = int(input('Jogador 1, Escolha o seu personagem [Apenas Números]: '))
pularLinha2()
jogador2 = int(input('Jogador 2, Escolha o seu personagem [Apenas Números]: '))
pularLinha2()

vidaJogador1 = 50
vidaJogador2 = 50

def funcao1():
    pularLinha()
    print('{}, é sua vez de atacar'.format(listaPersonagens[jogador1 - 1:jogador1]))
    pularLinha()
    pularLinha2()
    acao1 = input('Role o dado [Digite qualquer tecla]')
    pularLinha2()
    valorDadoJogador1 = randint(1, 7)
    print('O valor de ataque foi igual a ', valorDadoJogador1)

    pularLinha()
    pularLinha()

    print('{}, é sua vez de se defender'.format(listaPersonagens[jogador2 - 1:jogador2]))
    pularLinha()
    acao2 = input('Role o dado [Digite qualquer tecla]')
    pularLinha2()
    valorDadoJogador2 = randint(1, 7)
    print('O valor de defesa foi igual a ', valorDadoJogador2)

'''    if valorDadoJogador1 > valorDadoJogador2:
        dano = valorDadoJogador1 - valorDadoJogador2
        vidaJogador2 - dano = vidaJogador2
        print('dizer q a vida abaixou')
    elif valorDadoJogador1 <= valorDadoJogador2:
        print('Defesa prevaleceu')
'''
def funcao2():
    print('{}, é sua vez de atacar'.format(listaPersonagens[jogador2 - 1:jogador2]))
    pularLinha()
    acao1 = input('Role o dado [Digite qualquer tecla]')
    pularLinha2()
    valorDadoJogador2 = randint(1, 7)
    print('O valor de ataque foi igual a ', valorDadoJogador2)

    pularLinha()
    pularLinha()

    print('{}, é sua vez de se defender'.format(listaPersonagens[jogador1 - 1:jogador1]))
    pularLinha()
    acao2 = input('Role o dado [Digite qualquer tecla]')
    pularLinha2()
    valorDadoJogador1 = randint(1, 7)
    print('O valor de defesa foi igual a ', valorDadoJogador1)

'''    if valorDadoJogador2 > valorDadoJogador1:
        dano = valorDadoJogador2 - valorDadoJogador1
        vidaJogador1 - dano = vidaJogador1
        print('dizer q a vida abaixou')
    elif valorDadoJogador2 <= valorDadoJogador1:
        print('Defesa prevaleceu')
'''

while vidaJogador1 or vidaJogador2 > 0:
    funcao1()
    pularLinha2()
    funcao2()