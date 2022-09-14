import tkinter
import pygame as pg
import matplotlib.pyplot as mpl

#  Get actual window resolutions
tkinter_root = tkinter.Tk()
# O -100 é para a janela não ficar enorme
monitor_height = tkinter_root.winfo_screenheight() - 100  # Altura do monitor
monitor_width = tkinter_root.winfo_screenwidth() - 100  # Largura do monitor
print("width x height = %d x %d (pixels)" % (monitor_width, monitor_height))

p1 = (20, 10)  # Ponto 1
p2 = (30, 18)  # Ponto 2
x_min = 1
x_max = monitor_width
y_min = 1
y_max = monitor_height


def wc_to_ndc(x, y, x_min, x_max, y_min, y_max):
    """
    Realiza a conversão entre as coordenadas do mundo real para as coordenadas de dipositivos normalizadas.
    :param x: Coordenada X do mundo real
    :param y: Coordenada Y do mundo real
    :param x_min: Coordenada mínima do eixo X do mundo real
    :param x_max: Coordenada máxima do eixo X do mundo real
    :param y_min: Coordenada mínima do eixo Y do mundo real
    :param y_max: Coordenada máxima do eixo Y do mundo real
    :return: Tupla de coordenadas XY em NDC (Coordenadas de dispositivos normalizadas)
    """
    ndc_x = (x - x_min) / (x_max - x_min)
    ndc_y = (y - y_min) / (y_max - y_min)
    return ndc_x, ndc_y


def ndc_to_dc(ndc_x, ndc_y, ndh, ndv):  # ndh -> horizontal pixel size; ndv -> vertical pixel size
    """
    Realiza a conversão entre as coordenadas de dipositivos normalizadas para as coordenadas do dispositivo.
    :param ndc_x: Coordenada X em NDC (Coordenadas de dispositivos normalizadas)
    :param ndc_y: Coordenada Y em NDC (Coordenadas de dispositivos normalizadas)
    :param ndh: Quantidade horizontal de píxeis endereçaveis
    :param ndv: Quantidade verical de píxeis endereçaveis
    :return: Tupla de coordenadas XY em coordenadas de dispositivo.
    """
    dc_x = round(ndc_x * (ndh - 1))
    dc_y = round(ndc_y * (ndv - 1))
    return dc_x, dc_y


def draw_pixel(x, y):
    ndc_coordinates = wc_to_ndc(x, y, x_min, x_max, y_min, y_max)
    dc_coordinates = ndc_to_dc(ndc_coordinates[0], ndc_coordinates[1], monitor_width, monitor_height)
    pg.draw.rect(window, (0, 255, 0), (dc_coordinates[0], dc_coordinates[1], 1, 1))


if __name__ == '__main__':
    pg.init()
    window = pg.display.set_mode((monitor_width, monitor_height))

    #  Variações
    dx = p2[0] - p1[0]
    dy = p2[1] - p1[1]

    # d = 2 * dy - dx
    d = dy - (dx / 2)

    incremento_e = 2 * dy
    incremento_ne = 2 * (dy - dx)

    actual_x = p1[0]
    actual_y = p1[1]

    draw_pixel(actual_x, actual_y)
    mpl.plot(actual_x, actual_y, 'or')

    while True:
        for event in pg.event.get():
            if event.type == 256:  # Close window button action
                pg.quit()
                exit(0)

        while actual_x < p2[0]:
            if d <= 0:  # Escolher posição à Direita (E)
                d += incremento_e
                actual_x += 1
            else:  # Escolher posição à diagonal Direita (E)
                d += incremento_ne
                actual_x += 1
                actual_y += 1
            print(f'd: {d} | x: {actual_x} | y: {actual_y}')
            draw_pixel(actual_x, actual_y)
            mpl.plot(actual_x, actual_y, 'or')

        mpl.show()
        pg.display.update()
