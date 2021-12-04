package unittest;
import java.awt.Color;

import org.junit.jupiter.api.Test;

import Elements.Camera;
import Geometrics.Sphere;
import Geometrics.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;

public class MyTestRenderer {

    @Test
    public void basicRenderTwoColorTest(){
        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(100) ;
        scene.setBackground(new Color(255, 169, 217, 255));
        scene.addGeometry(new Triangle(new Point3D(-250, 0, 100), new Point3D(0, -250, 100), new Point3D(100, 100, 100),new Color(233, 246, 160)));
        scene.addGeometry(new Triangle(new Point3D(-100, 500, 90), new Point3D(300, 100, 90), new Point3D(-250, 90, 90),new Color(176, 231, 255)));
        scene.addGeometry(new Triangle(new Point3D(-250, 100, 80), new Point3D(250, 50, 80), new Point3D(250, 0, 80),new Color(132, 246, 155)));
        scene.addGeometry(new Triangle(new Point3D(100, 0, 70), new Point3D(0, 100, 70), new Point3D(30, -30, 70),new Color(255, 204, 145)));
        scene.addGeometry(new Triangle(new Point3D(80, -250, 60), new Point3D(30, -160, 60), new Point3D(100, 100, 60),new Color(203, 148, 255)));
        ImageWriter imageWriter = new ImageWriter("MyRenderMLM", 500, 500, 500, 500);
        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();
    }
}
