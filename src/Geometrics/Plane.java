package Geometrics;
import Primitives.Point3D;
import Primitives.Vector;

import java.util.Objects;

public class Plane {
    private Point3D point;
    private Vector vertical;

    public Plane(){
        this.point = new Point3D();
    }

    public Plane(double xPoint, double yPoint, double zPoint,
                 double xVector, double yVector, double zVector){
            this.point = new Point3D(xPoint, yPoint, zPoint);
            this.vertical = new Vector(xVector, yVector, zVector);
    }
    public Plane(Plane other){
        this.point = new Point3D(other.getPoint());
        this.vertical = new Vector(other.getVertical());
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        // if p1=p2 or p1=p3 - an exception will be thrown
        Vector v1 = p1.subtract(p2);
        Vector v2 = p1.subtract(p3);

        // if the points are in the same line - X-product will throw an exception
        this.vertical = v1.crossProduct(v2).normalize();
        this.point = new Point3D(p1);
    }

    public Plane(Point3D p, Vector n) {
        this.vertical = n.normalize();
        this.point = new Point3D(p);
    }



    public Point3D getPoint(){return this.point;}
    public Vector getVertical(){return this.vertical;}

    public void setPoint(Point3D point) {this.point = new Point3D(point);}
    public void setPoint(double x, double y, double z){this.point = new Point3D(x, y, z);}
    public void setVertical(Vector vertical) {this.vertical = new Vector(vertical);}


    public boolean equals(Plane other){return this.point.equals(other.getPoint()) && this.vertical.equals(other.getVertical());}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(point, plane.point) && Objects.equals(vertical, plane.vertical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, vertical);
    }

    @Override
    public String toString() {
        return "Plane: " +
                "point = " + point +
                ", vertical = " + vertical;
    }


}
