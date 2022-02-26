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
		/* Bresenham algorithm */
		int m_new = 2 * (pixelPosition[3] - pixelPosition[1]);
		int slope_error_new = m_new - (pixelPosition[2] - pixelPosition[0]);

		for (int x = pixelPosition[0], y = pixelPosition[1]; x <= pixelPosition[2]; x++)
		{
			glVertex2d(x, y);

			// Add slope to increment angle formed
			slope_error_new += m_new;

			// Slope error reached limit, time to
			// increment y and update slope error.
			if (slope_error_new >= 0)
			{
				y++;
				slope_error_new -= 2 * (pixelPosition[2] - pixelPosition[0]);
			}
		}

		/* Render here */
		glClear(GL_COLOR_BUFFER_BIT);

		glLoadIdentity();
		gluOrtho2D(0.0, resolution[0], 0.0, resolution[1]);

		glBegin(GL_POINTS);
		glColor3f(1, 1, 1);

		for (int x = pixelPosition[0], y = pixelPosition[1]; x <= pixelPosition[2]; x++)
		{
			glVertex2d(x, y);

			// Add slope to increment angle formed
			slope_error_new += m_new;

			// Slope error reached limit, time to
			// increment y and update slope error.
			if (slope_error_new >= 0)
			{
				y++;
				slope_error_new -= 2 * (pixelPosition[2] - pixelPosition[0]);
			}
		}

		printf("End\n");

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