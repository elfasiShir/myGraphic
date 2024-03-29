package Primitives;

import java.util.Objects;

public class Ray {
    private Point3D head;
    private Vector direction;

    //public Ray(){
     //   this.head = new Point3D();
       // this.direction = new Vector();
    //}
    public Ray(double xPoint, double yPoint, double zPoint,
               double xVector, double yVector, double zVector){
        this.head  = new Point3D(xPoint, yPoint, zPoint);
        this.direction = new Vector(xVector, yVector, zVector);
    }
    public Ray(Ray other){
        this.head = new Point3D(other.getHead());
        this.direction = new Vector(other.getDirection());
    }
    public Ray(Point3D head, Vector direction){
        this.head = new Point3D(head);
        this.direction = new Vector(direction.normalize());
    }
    public Vector getDirection() { return direction; }
    public Point3D getHead() { return head; }
    public void setDirection(Vector direction) { this.direction = direction; }
    public void setHead(Point3D head) { this.head = head; }
    public boolean equals(Ray other){ return this.head.equals(other.getHead()) && this.direction.equals(other.getDirection()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return Objects.equals(head, ray.head) && Objects.equals(direction, ray.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, direction);
    }

    @Override
    public String toString() {
        return "starting point: " + head + " direction: " + direction ;
    }
}
