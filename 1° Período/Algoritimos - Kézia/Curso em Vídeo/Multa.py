velocidade = float(input('Qual é a sua velocidade atual em km/h? '))
if velocidade > 80:
    print('Você está muito acima do limite de velocidade')
    multa = (velocidade-80)*7
    print('Terás que pagar uma multa de R${:.2f}'.format(multa))
else:
    print('Você está no limite de velocidade.\n'
          'Tenha uma boa viajem! :)')
