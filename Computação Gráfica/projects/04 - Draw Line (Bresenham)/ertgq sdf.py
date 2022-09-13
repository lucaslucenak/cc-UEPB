import matplotlib.pyplot as matplot

# pegando os valores iniciais e finais
x1 = int(input("ponto inicial de x:  "))
y1 = int(input("ponto inicial de y: "))
x2 = int(input("ponto final de x: "))
y2 = int(input("ponto final de y: "))

# calculando a variação
dx = x2 - x1
dy = y2 - y1

# calculando variável de decisão d
d = dy - (dx / 2)

print ('X = %s, Y = %s' % (x1 , y1))

coordenadasx = [x1]
coordenadasy = [y1]

while(x1 < x2):
    x1 += 1

  # decidindo onde será o incremento no primeiro oitante
    if(d < 0):
      # incremento em E
        d = d + dy
    else:
      # incremento NE
        d = d + (dy - dx)
        y1 += 1

    coordenadasx.append(x1)
    coordenadasy.append(y1)
    print('x = %s, y = %s, d = %s' % (x1 , y1, d))

# plotando o gráfico
matplot.plot(coordenadasx, coordenadasy,'or')
matplot.show()