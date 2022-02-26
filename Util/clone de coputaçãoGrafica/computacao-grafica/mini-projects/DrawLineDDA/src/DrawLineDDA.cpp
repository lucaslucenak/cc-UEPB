#include <GL/freeglut.h>
#include <GLFW/glfw3.h>
#include <iostream>
#include <tuple>

using namespace std;

int createWindow(int* pixelPosition, int* resolution, const char* title)
{
	GLFWwindow* window;

	/* Initialize the library */
	if (!glfwInit())
		return -1;

	/* Create a windowed mode window and its OpenGL context */
	window = glfwCreateWindow(resolution[0], resolution[1], title, NULL, NULL);
	if (!window)
	{
		glfwTerminate();
		return -1;
	}

	/* Make the window's context current */
	glfwMakeContextCurrent(window);

	/* Loop until the user closes the window */
	while (!glfwWindowShouldClose(window))
	{
		/* DDA algorithm */
		int dx = pixelPosition[2] - pixelPosition[0];
		int dy = pixelPosition[3] - pixelPosition[1];

		int steps;

		if (abs(dx) > abs(dy))
		{
			steps = abs(dx);
		}
		else
		{
			steps = abs(dy);
		}

		float Xinc = dx / (float)steps;
		float Yinc = dy / (float)steps;

		float X = pixelPosition[0];
		float Y = pixelPosition[1];

		/* Render here */
		glClear(GL_COLOR_BUFFER_BIT);

		glLoadIdentity();
		gluOrtho2D(0.0, resolution[0], 0.0, resolution[1]);

		glBegin(GL_POINTS);
		glColor3f(1, 1, 1);

		for (int k = 0; k <= steps; k++)
		{
			glVertex2d(round(X), round(Y));

			X += Xinc;
			Y += Yinc;
		}

		glEnd();

		/* Swap front and back buffers */
		glfwSwapBuffers(window);

		/* Poll for and process events */
		glfwPollEvents();
	}

	glfwTerminate();
	return 0;
}

int main()
{
	int pixelPosition[4];
	printf("-----------------------------------\n");
	printf("Type in the pixel position (x1): ");
	cin >> pixelPosition[0];
	printf("Type in the pixel position (y1): ");
	cin >> pixelPosition[1];
	printf("Type in the pixel position (x2): ");
	cin >> pixelPosition[2];
	printf("Type in the pixel position (y2): ");
	cin >> pixelPosition[3];
	printf("-----------------------------------\n");

	// User device resolution
	int resolution[2] = { 1280, 720 };

	// Show window
	createWindow(pixelPosition, resolution, "Display 1280x720");

	return 0;
}