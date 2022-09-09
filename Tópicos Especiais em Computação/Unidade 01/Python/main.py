import math

positivos = 2
negativos = 2
total = 4
proporcaoPositivos = positivos / total
proporcaoNegativos = negativos / total

entropia = -proporcaoPositivos * math.log2(proporcaoPositivos) - proporcaoNegativos * math.log2(proporcaoNegativos)

print(-proporcaoPositivos * math.log2(proporcaoPositivos))
print(-proporcaoNegativos * math.log2(proporcaoNegativos))
print(entropia)
