package Primitives;
import java.lang.Math;
import java.util.Objects;

public class Point3D{
    private Coordinate x;
    private Coordinate y;
    private Coordinate z;

    public static final Point3D ZERO = new Point3D(0,0,0);

    public Point3D(double x, double y, double z){
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    public Point3D(Point3D other){
        this.x = new Coordinate(other.getXVal());
        this.y = new Coordinate(other.getYVal());
        this.z = new Coordinate(other.getZVal());
    }
    public Point3D(Coordinate x, Coordinate y, Coordinate z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3D(){
        this.x = new Coordinate(0.0);
        this.y = new Coordinate(0.0);
        this.z = new Coordinate(0.0);
    }
    public double getXVal(){return this.x.getValue();}
    public double getYVal(){return this.y.getValue();}
    public double getZVal(){return this.z.getValue();}

    public Coordinate getX(){return this.x;}
    public Coordinate getY(){return this.y;}
    public Coordinate getZ(){return this.z;}

    public void setX(double x) {this.x.setValue(x);}
    public void setY(double y) {this.y.setValue(y);}
    public void setZ(double z) {this.z.setValue(z);}


    @Override
    public String toString() {
        return "( " + x + ", " + y + ", " + z + ')';
    }
    public Point3D add(Point3D other){
        return new Point3D(
                this.x.getValue() + other.getXVal(),
                this.y.getValue() + other.getYVal(),
                this.z.getValue() + other.getZVal());
    }
    public Point3D add(Vector other){
        return add(other.getHead());
    }
    public Vector subtract(Point3D other){
        Vector v = new Vector(
                this.getXVal() - other.getXVal(),
                this.getYVal() - other.getYVal(),
                this.getZVal() - other.getZVal());
        if (v.getHead().equals(Point3D.ZERO)){
            throw new IllegalArgumentException("oh my gosh did you subtract to get point zero????");
        }
        return v;
    }
    public double distance(Point3D other){
        return Math.sqrt(
                Math.pow(this.getXVal() + other.getXVal(), 2) +
                Math.pow(this.getYVal() + other.getYVal(), 2) +
                Math.pow(this.getZVal() + other.getZVal(), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return x.equals(point3D.x) && y.equals(point3D.y) && z.equals(point3D.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
