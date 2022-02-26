#include <GL/freeglut.h>
#include <GLFW/glfw3.h>
#include <iostream>
#include <tuple>

using namespace std;

std::tuple<double, double> toNDC(int* pixelPosition, int* resolution)
{
	int x = pixelPosition[0];
	int y = pixelPosition[1];

	int xmin = 0;
	int xmax = resolution[0];

	int ymin = 0;
	int ymax = resolution[1];

	double ndcx = (((double)x - xmin) / ((double)xmax - xmin));
	double ndcy = (((double)y - ymin) / ((double)ymax - ymin));

	double ndc[2] = { ndcx, ndcy };

	return std::make_tuple(ndc[0], ndc[1]);
}

std::tuple<int, int> toCoordinates(double ndc[], int* resolution)
{
	double ndcx = ndc[0];
	double ndcy = ndc[1];

	int xmin = 0;
	int xmax = resolution[0];

	int ymin = 0;
	int ymax = resolution[1];

	int ndh = xmax - xmin;
	int ndv = ymax - ymin;

	int dcx = round(ndcx * (ndh - 1));
	int dcy = round(ndcy * (ndv - 1));

	int coordinates[2] = { dcx, dcy };

	return std::make_tuple(coordinates[0], coordinates[1]);
}

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
		/* Render here */
		glClear(GL_COLOR_BUFFER_BIT);

		glLoadIdentity();
		gluOrtho2D(0.0, resolution[0], 0.0, resolution[1]);

		glBegin(GL_POINTS);
		glColor3f(1, 1, 1);
		glVertex2d(pixelPosition[0], pixelPosition[1]);
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
	int pixelPosition[2];
	printf("-----------------------------------\n");
	printf("Type in the pixel position (x): ");
	cin >> pixelPosition[0];
	printf("Type in the pixel position (y): ");
	cin >> pixelPosition[1];
	printf("-----------------------------------\n");

	// Input device resolution
	int inputResolution[2] = { 800, 600 };

	// Normalized Device Coordinates - NDC
	int ndcRange[2] = { 1, 1 };

	// User device resolution
	int userResolution[2] = { 1280, 720 };

	// Output device resolution
	int outputResolution[2] = { 1600, 900 };

	// Pixel convertion
	double NDC1[2];
	tie(NDC1[0], NDC1[1]) = toNDC(pixelPosition, inputResolution);
	int userPixelPosition[2];
	tie(userPixelPosition[0], userPixelPosition[1]) = toCoordinates(NDC1, userResolution);

	double NDC2[2];
	tie(NDC2[0], NDC2[1]) = toNDC(pixelPosition, inputResolution);
	int outputPixelPosition[2];
	tie(outputPixelPosition[0], outputPixelPosition[1]) = toCoordinates(NDC2, outputResolution);

	// Show values
	printf("Values\n-----------------------------------\n");
	printf("Input Pixel Position: (%d, %d)\n", pixelPosition[0], pixelPosition[1]);
	printf("NDC1: (%f, %f)\n", NDC1[0], NDC1[1]);
	printf("User Pixel Position: (%d, %d)\n", userPixelPosition[0], userPixelPosition[1]);
	printf("NDC2: (%f, %f)\n", NDC2[0], NDC2[1]);
	printf("Output Pixel Position: (%d, %d)\n", outputPixelPosition[0], outputPixelPosition[1]);

	// Show windows
	createWindow(pixelPosition, inputResolution, "Input Display 800x600");
	createWindow(userPixelPosition, userResolution, "User Display 1600x900");
	createWindow(outputPixelPosition, outputResolution, "Output Display 1280x720");

	return 0;
}