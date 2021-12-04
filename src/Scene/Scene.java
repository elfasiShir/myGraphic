
package Scene;

import Elements.Camera;
import Geometrics.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene {
    private String name;
    private ArrayList<Geometry> geometries;
    Camera camera;
    private double screenDistance;
    private Color background;

    public Scene(){
        this.name = "";
        this.geometries = new ArrayList<Geometry>();
        this.camera = new Camera();
        this.screenDistance = 100;
        this.background = new Color(0, 0, 0);
    }
    public Scene(String name){
        this.name = name;
        this.geometries = new ArrayList<Geometry>();
        this.camera = new Camera();
        this.screenDistance = 100;
        this.background = new Color(0,211,255);
    }
    public Scene(String name, Geometry geometry){
        this.name = name;
        this.geometries = new ArrayList<Geometry>();
        this.geometries.add(geometry);
        this.camera = new Camera();
        this.screenDistance = 100;
        this.background = new Color(0,211,255);
    }
    public Scene(String name, Geometry g, Camera camera){
        this.name = name;
        this.geometries = new ArrayList<Geometry>();
        this.geometries.add(g);
        this.setCamera(camera);
        this.screenDistance = 100;
        this.background = new Color(0,211,255);
    }
    public String getName(){return this.name;}
    public ArrayList<Geometry> getGeometries(){return this.geometries;}
    public void setName(String name){this.name = name;}
    public void setGeometries(ArrayList<Geometry> geometries) {this.geometries = geometries;}
    public void addGeometry(Geometry geometry){this.geometries.add(geometry);}
    public Camera getCamera() { return  this.camera; }
    public void setCamera(Camera camera) { this.camera = camera; }
    public Color getBackground() { return this.background; }
    public void setBackground(Color c) { this.background = c; }
    public double getScreenDistance() { return this.screenDistance; }
    public void setScreenDistance(double distance) { this.screenDistance = distance; }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene2 = (Scene) o;
        if (this.getGeometries().size() != scene2.getGeometries().size())
            return false;
        else {
            List<Geometry> copy = new ArrayList<>(this.getGeometries());
            if (copy.retainAll(scene2.getGeometries())) {
                return copy.size() == this.getGeometries().size()
                        && this.background == scene2.getBackground() &&
                        this.screenDistance == scene2.getScreenDistance();
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.geometries);
    }

}
