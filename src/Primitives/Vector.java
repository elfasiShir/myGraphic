package Primitives;

import java.util.Objects;

public class Vector {
    private Point3D head;

    public Vector() { this.head = new Point3D(1,1,1); }

    public Vector(Vector other) {this.head = new Point3D(other.getHead());}
    public Point3D getHead() {return this.head;}
    public boolean equals(Vector other) {return this.head.equals(other.getHead());}
    public void setHead(Point3D other) {this.head = other;}
    public void setHead(double x, double y, double z) {this.head = new Point3D(x, y, z);}
    public void setHead(Coordinate x, Coordinate y, Coordinate z) {this.head = new Point3D(x, y, z);}

    @Override
    public String toString() {
        return "" + head;
    }
    public double length() {
        return (new Point3D().distance(this.head));
    }

    public Vector normalize() {

        double length = this.length();
        Vector vector = new Vector(
                this.getHead().getXVal() / length,
                this.getHead().getYVal() / length,
                this.getHead().getZVal() / length);
        return vector;
    }
    public Vector add(Vector other) {
        return new Vector(this.getHead().add(other.getHead()));
    }

    public Vector(double x, double y, double z) {
        this.head = new Point3D(x, y, z);
        if (Point3D.ZERO.equals(this.head)) {
            throw new IllegalArgumentException("Zero vector is not allowed");
        }
    }
    public Vector(Point3D p) {
        if (Point3D.ZERO.equals(p))
            throw new IllegalArgumentException("Zero vector is not allowed");
        this.head = new Point3D(p);
    }

    public Vector subtract(Vector other) {
        return this.getHead().subtract(other.getHead());
    }

    public Vector scale(double scalar) {
        return (new Vector(
                this.getHead().getXVal() * scalar,
                this.getHead().getYVal() * scalar,
                this.getHead().getZVal() * scalar));
    }
    public Vector crossProduct(Vector other){
        Coordinate x = new Coordinate((this.getHead().getYVal() * other.getHead().getZVal()) - (this.getHead().getZVal() * other.getHead().getYVal()));
        Coordinate y = new Coordinate((this.getHead().getZVal() * other.getHead().getXVal()) - (this.getHead().getXVal() * other.getHead().getZVal()));
        Coordinate z = new Coordinate((this.getHead().getXVal() * other.getHead().getYVal()) - (this.getHead().getYVal() * other.getHead().getXVal()));
        Point3D head = new Point3D(x,y,z);
        Vector vector = new Vector(head);
        return vector;
    }

    public double dotProduct(Vector other) {
        return (this.getHead().getXVal() * other.getHead().getXVal()
                + this.getHead().getYVal() * other.getHead().getYVal()
                + this.getHead().getZVal() * other.getHead().getZVal());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return Objects.equals(head, vector.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}