package Geometrics;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
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
    public Sphere(Point3D center, double radius, Color color){
        this.center = new Point3D(center);
        this.radius = radius;
        this._emission = color;
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
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> list = new ArrayList<>();
        Vector u = this.center.subtract(ray.getHead());
        double tm = ray.getDirection().dotProduct(u);
        double d = Math.sqrt( Math.pow(u.length(), 2) - Math.pow(tm, 2) );
        if (d <= this.radius) {
            double th = Math.sqrt( Math.pow(this.radius, 2) - Math.pow(d, 2) );
            double t1 = tm - th;
            double t2 = tm + th;
            if (0 < t1 || 0 < t2) {
                if (0 < t1)
                    list.add(new GeoPoint(this, ray.getHead().add( ray.getDirection().scale(t1) )) );
                if (0 < t2)
                    list.add(new GeoPoint( this,ray.getHead().add( ray.getDirection().scale(t2) )) );
                return list;
            }
        }
        return null;
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









