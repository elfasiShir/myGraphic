package Geometrics;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plane extends Geometry{
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
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);

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
 /*
    @Override
    public List<Point3D> findIntersections(Ray ray){
        Vector vector = new Vector(this.getPoint().subtract(ray.getHead()));
        double t = this.getVertical().dotProduct(vector)
                /
                this.getVertical().dotProduct(ray.getDirection());
        Point3D point3D = new Point3D(ray.getHead().add(ray.getDirection().scale(t)));
        if (t>0){
            List<Point3D> list = new ArrayList<Point3D>();
            list.add(point3D);
            return list;
        }
        else{
            return null;
        }
    }
  */
 @Override
 public List<Point3D> findIntersections(Ray ray) {
     List<Point3D> intersections = new ArrayList<>();
     if (!this.point.equals(ray.getHead())) {
         double numerator = this.vertical.dotProduct(this.point.subtract(ray.getHead()));
         double denominator = this.vertical.dotProduct(ray.getDirection());
         if (denominator == 0) {       // The Ray is contained or parallel to the plane.
             return null;
         } else if ( 0 < numerator / denominator) {
             Point3D p = ray.getHead().add(ray.getDirection().scale(numerator / denominator));
             intersections.add(p);
             return intersections;
         }
     }
     return null;
 }
    /*
    @Override
    public Vector getNormal(Point3D point) {
        Vector vector = new Vector(this.getPoint().subtract(point));
        if(this.getVertical().dotProduct(vector) ==0)
            return this.getVertical();
        else{
            return null;
        }
    }
*/
    @Override
    public Vector getNormal(Point3D point) {
        return this.vertical;
    }

    @Override
    public boolean equals(Object o) {          // To compare 2 planes we need to 1. see if the 2 vertices to the planes are equals. Because we normalize every vector we can use equals method.
        if (this == o) return true;            //2. Determine whether a point is in the other plane.  if the vertices are equals but the point is not in the other plane => the planes are parallel.
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane2 = (Plane) o;
        return this.isPointInPlane(plane2.getPoint()) && Objects.equals(this.vertical, plane2.getVertical());
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
    private boolean isPointInPlane(Point3D otherPoint){               // Calculating plane equation and determining whether a point is in that plane.
        Point3D normal = this.getVertical().getHead();        // normal * (x,y,z) + d = 0.  where normal is the vector vertical to plane.
        double correctD = -(normal.getXVal() * this.getPoint().getXVal() +
                normal.getYVal() * this.getPoint().getYVal() +     // Calculating the correct d for the plane.
                normal.getZVal() * this.getPoint().getZVal());
        double otherD = -(normal.getXVal() * otherPoint.getXVal() +
                normal.getYVal() * otherPoint.getYVal() +   // Calculating the d for the plane with otherPoint .
                normal.getZVal() * otherPoint.getZVal());

        return correctD == otherD;
    }

}
