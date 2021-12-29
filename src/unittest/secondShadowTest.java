package unittest;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Elements.SpotLight;
import Geometrics.Plane;
import Geometrics.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class secondShadowTest {
    @Test
    public void spotLightTest2(){

        Scene scene = new Scene("spotLightTest2");
        scene.setCamera(new Camera( new Point3D(-50, 0, 100),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.setScreenDistance(200);
        scene.set_ambientLight(new AmbientLight(new Color(255, 255, 255, 255), 0.1));
        scene.setBackground(new Color	(248, 255, 133));
        Material m1=new Material(1,1,20);

        Plane plane = new Plane(new Point3D(-800,400,0), new Vector(3,-3, 0), new Color(253, 152, 204));
        plane.setMaterial(new Material(1,6,20));
        scene.addGeometry(plane);

        Triangle triangle = new Triangle(
                new Point3D(-20, 25, 260),
                new Point3D(-80, -65, 260),
                new Point3D(-100, 25, 260),

                new Color (164, 255, 232));

        Triangle triangle2 = new Triangle(
                new Point3D(-20, 25, 220),
                new Point3D(-80, -65, 220),
                new Point3D(-100, 25, 220),

                new Color (164, 255, 232));

        Material m2=new Material(1,1,4);
        triangle.setMaterial(m2);
        triangle2.setMaterial(m2);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -150), new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
        scene.addLight(new PointLight(new Color(255, 149, 149), new Point3D(100, -100, 100),
                0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("2nd shade image", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();

    }
}
