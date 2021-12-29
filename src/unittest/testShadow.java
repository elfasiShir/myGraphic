package unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;
import Elements.*;
import Geometrics.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

class testShadow {
    @Test
    public void spotLightTest2(){

        Scene scene = new Scene("spotLightTest2");
        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.setScreenDistance(200);
        scene.set_ambientLight(new AmbientLight(new Color(255, 255, 255, 255), 0.1));
        scene.setBackground(new Color	(47, 231, 255));
        Material m1=new Material(1,1,20);

        Sphere s2 = new Sphere(new Point3D(-250,0, 700), 300, new Color(114, 188, 255));
        s2.setMaterial(new Material(1,1,20));
        scene.addGeometry(s2);

        Plane plane = new Plane(new Point3D(-800,400,0), new Vector(3,-2, 0), new Color(253, 152, 204));
        plane.setMaterial(new Material(2,1,20));
        scene.addGeometry(plane);

        Triangle triangle = new Triangle(new Point3D(-20, 25, 380),
                new Point3D(-80, -65, 380),
                new Point3D(-100, 25, 380),
                new Color (0, 0, 100));
/*

        Triangle triangle2 = new Triangle(new Point3D(-150, 25, 200),
                new Point3D(-250, -65, 200),
                new Point3D(-250, 25, 200),
                new Color (0, 0, 100));
*/

        Material m2=new Material(1,1,4);
        triangle.setMaterial(m2);
        //triangle2.setMaterial(m2);
        scene.addGeometry(triangle);
        //scene.addGeometry(triangle2);

        //scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -150), new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
        scene.addLight(new PointLight(new Color(255, 149, 149), new Point3D(100, -100, 100),
                0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();

    }

}
