import tkinter

import pygame as pg
from sys import exit

# wc -> World Coordinates
# dc -> Dispositive Coordinates
# ndc -> Normal Dispositive Coordinates
# vp -> view port


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


def ndc_to_wc(ndc_x, ndc_y, x_min, x_max, y_min, y_max):
    """
    Realiza a conversão entre as coordenadas de dipositivos normalizadas para as coordenadas do mundo real.
    :param ndc_x: Coordenada X em NDC (Coordenadas de dispositivos normalizadas)
    :param ndc_y: Coordenada Y em NDC (Coordenadas de dispositivos normalizadas)
    :param x_min: Coordenada mínima do eixo X do mundo real
    :param x_max: Coordenada máxima do eixo X do mundo real
    :param y_min: Coordenada mínima do eixo Y do mundo real
    :param y_max: Coordenada máxima do eixo Y do mundo real
    :return: Tupla de coordenadas XY em Coordenadas do Mundo.
    """
    wc_x = ndc_x * (x_max - x_min) - x_min
    wc_y = ndc_y * (y_max - y_min) - y_min
    return wc_x, wc_y


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


if __name__ == "__main__":
    #  Get actual window resolutions
    tkinter_root = tkinter.Tk()
    # O -100 é para a janela não ficar enorme
    monitor_height = tkinter_root.winfo_screenheight() - 100  # Altura do monitor
    monitor_width = tkinter_root.winfo_screenwidth() - 100  # Largura do monitor
    print("width x height = %d x %d (pixels)" % (monitor_width, monitor_height))

    pg.init()
    window = pg.display.set_mode((monitor_width, monitor_height))

    wc_x_min = 0
    wc_x_max = 100
    wc_y_min = 0
    wc_y_max = 100
    wc_x = 50
    wc_y = 50

    ndc_coordinates = wc_to_ndc(wc_x, wc_y, wc_x_min, wc_x_max, wc_y_min, wc_y_max)
    dc_coordinates = ndc_to_dc(ndc_coordinates[0], ndc_coordinates[1], monitor_width, monitor_height)
    print(f"Coordenadas NDC (Coordenadas de dispositivos normalizadas): X = {ndc_coordinates[0]}, Y = {ndc_coordinates[1]}")
    print(f"Coordenadas de Dispositivo: X = {dc_coordinates[0]}, Y = {dc_coordinates[1]}")

    while True:
        for event in pg.event.get():
            if event.type == 256:  # Close window button action
                pg.quit()
                exit(0)

        pg.draw.rect(window, (0, 255, 0), (dc_coordinates[0], dc_coordinates[1], 11, 11))  # window, (rgb color), (x_coordinate, y_coordinate, width, height)
        pg.display.update()
