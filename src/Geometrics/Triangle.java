package Geometrics;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

public class Triangle extends Geometry{
    private Point3D p1;
    private Point3D p2;
    private Point3D p3;

    public Triangle(){
        this.p1 = new Point3D();
        this.p2 = new Point3D();
        this.p3 = new Point3D();
    }
    public Triangle(Point3D p1, Point3D p2, Point3D p3){
        this.p1 = new Point3D(p1);
        this.p2 = new Point3D(p2);
        this.p3 = new Point3D(p3);
    }
    public Triangle(double x1, double y1, double z1,
                    double x2, double y2, double z2,
                    double x3, double y3, double z3){
        this.p1 = new Point3D(x1, y1, z1);
        this.p2 = new Point3D(x2, y2, z2);
        this.p3 = new Point3D(x3, y3, z3);
    }
    public Triangle(Triangle other){
        this.p1 = new Point3D(other.getP1());
        this.p2 = new Point3D(other.getP2());
        this.p3 = new Point3D(other.getP3());
    }

    public Point3D getP1() {return this.p1;}
    public Point3D getP2() {return this.p2;}
    public Point3D getP3() {return this.p3;}

    public void setP1(Point3D p1) {this.p1 = new Point3D(p1);}
    public void setP2(Point3D p2) {this.p2 = new Point3D(p2);}
    public void setP3(Point3D p3) {this.p3 = new Point3D(p3);}

    public void setP1(double x1 ,double y1, double z1) {this.p1 = new Point3D(x1, y1, z1);}
    public void setP2(double x2 ,double y2, double z2) {this.p2 = new Point3D(x2, y2, z2);}
    public void setP3(double x3 ,double y3, double z3) {this.p3 = new Point3D(x3, y3, z3);}

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Plane plane = new Plane(this.getP1(), this.getP2(), this.getP3());
        if (plane.findIntersections(ray) != null) {
            Vector v1 = this.getP1().subtract(ray.getHead());
            Vector v2 = this.getP2().subtract(ray.getHead());
            Vector v3 = this.getP3().subtract(ray.getHead());

            Vector n1 = v1.crossProduct(v2).normalize();
            Vector n2 = v2.crossProduct(v3).normalize();
            Vector n3 = v3.crossProduct(v1).normalize();

            double sign1 = Math.signum(n1.dotProduct(ray.getDirection()));
            double sign2 = Math.signum(n2.dotProduct(ray.getDirection()));
            double sign3 = Math.signum(n3.dotProduct(ray.getDirection()));

            if (sign1 == 0.0 || sign2 == 0.0 || sign3 == 0.0) {
                return null;
            } else {
                return plane.findIntersections(ray);
            }
        }
        return null;
    }
    @Override
    public Vector getNormal(Point3D point){
        Vector v1 = this.getP2().subtract(this.getP1());
        Vector v2 = this.getP3().subtract(this.getP1());
        return new Vector(v1.crossProduct(v2).normalize());
    }
//    @Override
//    public Vector getNormal(Point3D point){
//        Plane p = new Plane(this.getP1(), this.getP2(),this.getP3());
//        return p.getVertical().normalize();
//    }

    public boolean equals(Triangle other){
        return  this.p1.equals(other.getP1()) && this.p1.equals(other.getP2()) &&
                this.p1.equals(other.getP3()) &&
                this.p2.equals(other.getP1()) && this.p2.equals(other.getP2()) &&
                this.p2.equals(other.getP3()) &&
                this.p3.equals(other.getP1()) && this.p3.equals(other.getP2()) &&
                this.p3.equals(other.getP3());
    }
    @Override
    public String toString() {
        return "Triangle: " +
                "p1 = " + p1 +
                ", p2 = " + p2 +
                ", p3 = " + p3;
    }
}
