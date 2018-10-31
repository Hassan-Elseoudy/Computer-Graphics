#include <GL/freeglut.h>
#include <GL/gl.h>
#include <stdlib.h>
#include <math.h>
#include <stdio.h>

// light position
GLfloat g_light_position[4] = { 2.0f, 1.2f, 4.0f, 1.0f };

// Lighting values
GLfloat  whiteLight[] = { 0.2f, 0.2f, 0.2f, 1.0f };
GLfloat  sourceLight[] = { 0.8f, 0.8f, 0.8f, 1.0f };
GLfloat	 lightPos[] = { 0.0f, 0.0f, 0.0f, 1.0f };


// Called to draw scene
void RenderScene(void)
{
    // Earth and Moon angle of revolution
    static float fMoonRot = 0.0f;
    static float fEarthRot = 0.0f;

    // Clear the window with current clearing color
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // Save the matrix state and do the rotations
    glMatrixMode(GL_MODELVIEW);
    glPushMatrix();

    // Set light position before viewing transformation
    glLightfv(GL_LIGHT0,GL_POSITION,lightPos);

    // Translate the whole scene out and into view
    glTranslatef(0.0f, 0.0f, -300.0f);

    // Set material color, Red
    // Sun
    glColor3ub(255, 255, 0);
    glutSolidSphere(30.0f, 1000, 1000);

    // Move the light after we draw the sun!
    glLightfv(GL_LIGHT0,GL_POSITION,lightPos);


    // Rotate coordinate system
    glRotatef(fEarthRot, 0.0f, 1.0f, 0.0f);

    // Draw the Earth
    glColor3ub(0,0,255);
    glTranslatef(105.0f,0.0f,0.0f);
    glutSolidSphere(15.0f, 1000, 1000);


    // Rotate from Earth based coordinates and draw Moon
    glColor3ub(200,200,200);
    glRotatef(fMoonRot,0.0f, 1.0f, 0.0f);



    glTranslatef(30.0f, 0.0f, 0.0f);

        //Stars
    glBegin (GL_POINTS);
    for (int i = 0; i < 10000; i++)
        glVertex3f (rand() % 1000, rand() % 1000, rand() % 1000);
    glEnd ();
    fMoonRot+= 15.0f;
    if(fMoonRot > 360.0f)
        fMoonRot = 0.0f;

    glutSolidSphere(5.0f, 1000, 1000);

    // Restore the matrix state
    glPopMatrix();	// Modelview matrix

    // Step earth orbit 5 degrees
    fEarthRot += 5.0f;
    if(fEarthRot > 360.0f)
        fEarthRot = 0.0f;

    // Show the image
    glutSwapBuffers();
}


// This function does any needed initialization on the rendering
// context.
void SetupRC()
{
    // Light values and coordinates
    glEnable(GL_DEPTH_TEST);	// Hidden surface removal
    glFrontFace(GL_CCW);		// Counter clock-wise polygons face out
    glEnable(GL_CULL_FACE);		// Do not calculate inside of jet

    // Enable lighting
    glEnable(GL_LIGHTING);

    // Setup and enable light 0
    glLightModelfv(GL_LIGHT_MODEL_AMBIENT,whiteLight);
    glLightfv(GL_LIGHT0,GL_DIFFUSE,sourceLight);
    glLightfv(GL_LIGHT0,GL_POSITION,lightPos);
    glEnable(GL_LIGHT0);

    // Enable color tracking
    glEnable(GL_COLOR_MATERIAL);

    // Set Material properties to follow glColor values
    glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);

    // Black blue background
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f );
}


void TimerFunc(int value)
{
    glutPostRedisplay();
    glutTimerFunc(100, TimerFunc, 1);
}

void ChangeSize(int w, int h)
{
    GLfloat fAspect;

    // Prevent a divide by zero
    if(h == 0)
        h = 1;

    // Set Viewport to window dimensions
    glViewport(0, 0, w, h);

    // Calculate aspect ratio of the window
    fAspect = (GLfloat)w/(GLfloat)h;

    // Set the perspective coordinate system
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    // field of view of 45 degrees, near and far planes 1.0 and 425
    gluPerspective(45.0f, fAspect, 1.0, 425.0);

    // Modelview matrix reset
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}


int main(int argc, char* argv[])
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutCreateWindow("Let's play with stars!");
    glutReshapeFunc(ChangeSize);
    glutDisplayFunc(RenderScene);
    glutTimerFunc(500, TimerFunc, 1);
    SetupRC();
    glutMainLoop();

    return 0;
}
