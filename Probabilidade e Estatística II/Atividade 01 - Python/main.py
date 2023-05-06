from math import sqrt
from scipy.stats import t
from scipy.stats import norm


def teste_hipotese(n=0, media_amostral=0.0, media=0.0, desvio_padrao=0.0, nivel_significancia=0.0, lateralidade='INDEFINIDA'):
    """
    :param n: tamanho da amostra (100) - int
    :param media_amostral: média da amostra n (1570) - double
    :param media: média a ser testada (1600) - double
    :param desvio_padrao: desvio padrão da amostra (120) - double
    :param nivel_significancia: nível de significancia formecido (5% e 1%) - double
    :return: situação da hipótese (afirmada ou negada)
    """
    z = round((media_amostral - media) / (desvio_padrao / sqrt(n)), 2)  # Calculo do nível e confiança da média

    if n <= 30:  # Utiliza a tabela t-student
        tabela_utilizada = 't-student'
        graus_liberdade = n - 1
        valor_critico_inferior = round(t.ppf(nivel_significancia, graus_liberdade) if t.ppf(nivel_significancia, graus_liberdade) < 0 else t.ppf(nivel_significancia, graus_liberdade) * -1, 2)
        valor_critico_superior = round(t.ppf(nivel_significancia, graus_liberdade) if t.ppf(nivel_significancia, graus_liberdade) > 0 else t.ppf(nivel_significancia, graus_liberdade) * -1, 2)
    else:  # utiliza a tabela normal
        tabela_utilizada = 'normal'
        valor_critico_inferior = round(norm.ppf(nivel_significancia) if norm.ppf(nivel_significancia) < 0 else norm.ppf(nivel_significancia) * -1, 2)
        valor_critico_superior = round(norm.ppf(nivel_significancia) if norm.ppf(nivel_significancia) > 0 else norm.ppf(nivel_significancia) * -1, 2)

    if lateralidade.upper() == 'BILATERAL':  # Caso seja afirmada uma igualdade ou diferença
        if z <= valor_critico_inferior or z >= valor_critico_superior:  # Caso o nível de confiança esteja na região crítica determinada, a hipótese H0 é rejeitada.
            return f'''
            Nível de confiança da média está inserido na área crítica, portanto a HO é rejeitada.
            (z = {z} | Valor crítico inferior = {valor_critico_inferior} | Valor crítico superior = {valor_critico_superior})
            Cálculo Bilateral com a tabela '{tabela_utilizada}'.
            '''
        else:
            return f'''
            Nível de confiança da média NÃO está inserido na área crítica, portanto a HO é aceita.
            (z = {z} | Valor crítico inferior = {valor_critico_inferior} | Valor crítico superior = {valor_critico_superior})
            Cálculo Bilateral com a tabela '{tabela_utilizada}'.
            '''

    elif lateralidade.upper() == 'UNILATERAL_ESQUERDA':  # Caso seja afirmada uma diferença para menos
        if z <= valor_critico_inferior:  # Caso o nível de confiança esteja na região crítica determinada, a hipótese H0 é rejeitada.
            return f'''
            Nível de confiança da média está inserido na área crítica, portanto a HO é rejeitada.
            (z = {z} | Valor crítico inferior = {valor_critico_inferior})
            Cálculo Unilateral à Esquerda com a tabela '{tabela_utilizada}'.
            '''
        else:
            return f'''
            Nível de confiança da média NÃO está inserido na área crítica, portanto a HO é aceita.
            (z = {z} | Valor crítico inferior = {valor_critico_inferior})
            Cálculo Unilateral à Esquerda com a tabela '{tabela_utilizada}'.
            '''

    elif lateralidade.upper() == 'UNILATERAL_DIREITA':  # Caso seja afirmada uma diferença para mais
        if z >= valor_critico_superior:  # Caso o nível de confiança esteja na região crítica determinada, a hipótese H0 é rejeitada.
            return f'''
            Nível de confiança da média está inserido na área crítica, portanto a HO é rejeitada.
            (z = {z} | Valor crítico superior = {valor_critico_superior})
            Cálculo Unilateral à Direita com a tabela '{tabela_utilizada}'.
            '''
        else:
            return f'''
            Nível de confiança da média NÃO está inserido na área crítica, portanto a HO é aceita.
            (z = {z} | Valor crítico superior = {valor_critico_superior})
            Cálculo Unilateral à Direita com a tabela '{tabela_utilizada}'.
            '''


# n = 100 | x̅ = 1570 | µ = 1600 | σ = 120 | α = 0.05 / 0.01 | BILATERAL
print(teste_hipotese(100, 1570, 1600, 120, 0.05, 'BILATERAL'))  # Questão 1 (5%)
print(teste_hipotese(100, 1570, 1600, 120, 0.01, 'BILATERAL'))  # Questão 1 (1%)

# n = 25 | x̅ = 12 | µ = 13 | σ = 0.5 | α = 0.05 / 0.01 | UNILATERAL_DIREITA
print(teste_hipotese(25, 12, 13, 0.5, 0.05, 'UNILATERAL_DIREITA'))  # Questão 2
