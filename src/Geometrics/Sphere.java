package Geometrics;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

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
    public List<Point3D> findIntersections(Ray cameraRay){
        List<Point3D> point3DList = new ArrayList<Point3D>();
        Vector u = cameraRay.getHead().subtract(this.getCenter());
        double tm = cameraRay.getDirection().dotProduct(u);
        double distance = Math.sqrt(
                Math.pow(u.length(),2) -
                        Math.pow(tm,2)
        );
        if(distance > this.getRadius())
            return null;
        else{
            double th = Math.sqrt(
                    Math.pow(this.getRadius(),2) -
                            Math.pow(distance,2)
                );
                double t1 = tm-th;
                double t2 = tm+th;
                point3DList.add(cameraRay.getHead().add(cameraRay.getDirection().scale(t1)));
                point3DList.add(cameraRay.getHead().add(cameraRay.getDirection().scale(t2)));
                return point3DList;
            }

    }
    @Override
    public Vector getNormal(Point3D point) {
        return point.subtract(this.center);
    }
    @Override
    public String toString() {
        return "Sphere: " +
                "center = " + center +
                ", radius = " + radius;
    }
}









