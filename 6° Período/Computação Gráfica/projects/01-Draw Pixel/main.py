# import pyglet as pg
import tkinter

import pygame
import pygame as pg
from sys import exit

if __name__ == "__main__":
    #  Get actual window resolutions
    tkinter_root = tkinter.Tk()
    monitor_height = tkinter_root.winfo_screenheight()
    monitor_width = tkinter_root.winfo_screenwidth()
    print("width x height = %d x %d (pixels)" % (monitor_width, monitor_height))

    pygame.init()
    window = pg.display.set_mode((monitor_width-100, monitor_height-100))

    while True:
        for event in pg.event.get():
            if event.type == 256:
                pg.quit()
                exit(0)

        x_coordinate = int(input('Sex pixel x coordinate: '))
        y_coordinate = int(input('Sex pixel y coordinate: '))
        pg.draw.rect(window, (255, 255, 255), (x_coordinate, y_coordinate, 1, 1))  # window, (rgb color), (x_coordinate, y_coordinate, width, height)
        pg.display.update()

# def on_draw():
#     pg.graphics.draw(1, pg.gl.GL_POINT, {'v21', {50, 60}})
#
#
# if __name__ == "__main__":
#     #  Get actual window resolutions
#     tkinter_root = tkinter.Tk()
#     monitor_height = tkinter_root.winfo_screenheight()
#     monitor_width = tkinter_root.winfo_screenwidth()
#     print("width x height = %d x %d (pixels)" %(monitor_width, monitor_height))
#
#     # window = pg.window.Window(monitor_width, monitor_height)
#     window = pg.window.Window(1280, 720)
#     on_draw()
#     pg.app.run()
