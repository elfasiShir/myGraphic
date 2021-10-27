package Geometrics;
import Primitives.Point3D;
import Primitives.Vector;

public class Plane {
    Point3D point;
    private Vector vertical;

    public Plane(){
        this.point = new Point3D();
    }
    public Plane(Point3D point, Vector vertical){
        this.point = new Point3D(point);
        this.vertical = new Vector(vertical);
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

    public Point3D getPoint(){return this.point;}
    public Vector getVertical(){return this.vertical;}

    public void setPoint(Point3D point) {this.point = new Point3D(point);}
    public void setPoint(double x, double y, double z){this.point = new Point3D(x, y, z);}
    public void setVertical(Vector vertical) {this.vertical = new Vector(vertical);}

    @Override
    public String toString() {
        return "Plane: " +
                "point = " + point +
                ", vertical = " + vertical;
    }
}
