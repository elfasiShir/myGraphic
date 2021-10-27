package Geometrics;
import Primitives.Point3D;

public class Sphere extends Geometry{
    private Point3D center;
    private double radius;

    public Sphere(){
        this.center = new Point3D();
        this.radius = 0.0;
    }
    public Sphere(Point3D center, double radius){
        this.center = new Point3D(center);
        this.radius = radius;
    }
    public Sphere(double x, double y, double z, double radius){
        this.center = new Point3D(x, y, z);
        this.radius = radius;
    }
    public Sphere(Sphere other){
        this.center = new Point3D(other.getCenter());
        this.radius = other.getRadius();
    }
    public Point3D getCenter() {return center;}
    public double getRadius() {return radius;}

    public void setCenter(double x, double y, double z){this.center = new Point3D(x, y, z);}
    public void setCenter(Point3D center){this.center = new Point3D(center);}
    public void setRadius(double radius){this.radius = radius;}

    @Override
    public String toString() {
        return "Sphere: " +
                "center = " + center +
                ", radius = " + radius;
    }
}
