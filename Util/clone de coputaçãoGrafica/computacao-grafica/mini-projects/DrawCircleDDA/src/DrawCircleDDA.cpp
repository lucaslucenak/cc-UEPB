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
		int x = pixelPosition[2];
		int y = 0;
		int r = pixelPosition[2];

		int x_centre = pixelPosition[0];
		int y_centre = pixelPosition[1];

		// Initialising the value of P
		int P = 1 - r;

		/* Render here */
		glClear(GL_COLOR_BUFFER_BIT);

		glLoadIdentity();
		gluOrtho2D(0.0, resolution[0], 0.0, resolution[1]);

		glBegin(GL_POINTS);
		glColor3f(1, 1, 1);

		// When radius is zero only a single
		// point will be printed
		if (r > 0)
		{
			glVertex2d(x + x_centre, -y + y_centre);
			glVertex2d(y + x_centre, x + y_centre);
			glVertex2d(-y + x_centre, x + y_centre);
		}

		while (x > y)
		{
			y++;

			// Mid-point is inside or on the perimeter
			if (P <= 0)
				P = P + 2 * y + 1;
			// Mid-point is outside the perimeter
			else
			{
				x--;
				P = P + 2 * y - 2 * x + 1;
			}

			// All the perimeter points have already been printed
			if (x < y)
				break;

			// Printing the generated point and its reflection
			// in the other octants after translation
			glVertex2d(x + x_centre, y + y_centre);
			glVertex2d(-x + x_centre, y + y_centre);
			glVertex2d(x + x_centre, -y + y_centre);
			glVertex2d(-x + x_centre, -y + y_centre);

			// If the generated point is on the line x = y then 
			// the perimeter points have already been printed
			if (x != y)
			{
				glVertex2d(y + x_centre, x + y_centre);
				glVertex2d(-y + x_centre, x + y_centre);
				glVertex2d(y + x_centre, -x + y_centre);
				glVertex2d(-y + x_centre, -x + y_centre);
			}
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
	int pixelPosition[3];
	printf("-----------------------------------\n");
	printf("Type in the pixel position (x): ");
	cin >> pixelPosition[0];
	printf("Type in the pixel position (y): ");
	cin >> pixelPosition[1];
	printf("Type in the circle radius: ");
	cin >> pixelPosition[2];
	printf("-----------------------------------\n");

	// User device resolution
	int resolution[2] = { 1280, 720 };

	// Show window
	createWindow(pixelPosition, resolution, "Display 1280x720");

	return 0;
}