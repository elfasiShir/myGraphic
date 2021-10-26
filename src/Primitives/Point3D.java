package Primitives;

public class Point3D{
    private Cordinate x;
    private Cordinate y;
    private Cordinate z;
    public Point3D(double x, double y, double z){
        this.x = new Cordinate(x);
        this.y = new Cordinate(y);
        this.z = new Cordinate(z);
    }
    public Point3D(Point3D other){
        this.x = new Cordinate(other.getXVal());
        this.y = new Cordinate(other.getYVal());
        this.z = new Cordinate(other.getZVal());
    }
    public Point3D(Cordinate x, Cordinate y, Cordinate z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3D(){
        this.x = new Cordinate(0.0);
        this.y = new Cordinate(0.0);
        this.z = new Cordinate(0.0);
    }
    public double getXVal(){return this.x.getCordinate();}
    public double getYVal(){return this.y.getCordinate();}
    public double getZVal(){return this.z.getCordinate();}

    public Cordinate getX(){return this.x;}
    public Cordinate getY(){return this.y;}
    public Cordinate getZ(){return this.z;}

    public String toString(){return "( " + x.toString() + ", " + y.toString() + ", " + z.toString() +  " )" ;}
    public boolean equals(Point3D other){
        return (this.x.equals(other.getX()) && this.y.equals(other.getY()) && this.z.equals(getZ()));
    }
}
