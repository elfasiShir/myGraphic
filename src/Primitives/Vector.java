package Primitives;

public class Vector {
    private Point3D head;

    public Vector(){this.head = new Point3D();}
    public Vector(Point3D other){this.head = other;}
    public Vector(double x, double y, double z){this.head = new Point3D(x,y,z);}
    public Vector(Vector other){this.head = new Point3D(other.getHead());}
    public Point3D getHead(){return this.head;}
    public boolean equals(Vector other){return this.head.equals(other.getHead());}
    public void setHead(Point3D other){this.head = other;}
    public void setHead(double x, double y, double z){this.head = new Point3D(x, y, z);}
    public void setHead(Cordinate x, Cordinate y, Cordinate z){this.head = new Point3D(x, y, z);}
}
