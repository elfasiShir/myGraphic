package Geometrics;
import Primitives.Ray;

public class Cylinder extends Geometry {
    private double rad;
    private double height;
    private Ray axis;
    public Cylinder(){
        this.rad = 0.0;
        this.height = 0.0;
        this.axis = new Ray();
    }
    public Cylinder(double rad, double height,
                    double xPoint, double yPoint, double zPoint,
                    double xVector, double yVector, double zVector){
        this.rad = rad;
        this.height = height;
        this.axis = new Ray(xPoint, yPoint, zPoint, xVector, yVector, zVector);
    }
    public Cylinder(Cylinder other){
        this.rad = other.getRad();
        this.height = other.getHeight();
        this.axis = new Ray(other.getAxis());
    }

    public double getRad() {return this.rad;}
    public double getHeight() {return this.height;}
    public Ray getAxis() {return this.axis;}

    public void setRad(double rad) {this.rad = rad;}
    public void setHeight(double height) {this.height = height;}
    public void setAxis(Ray axis) {this.axis = new Ray(axis);}

    public boolean equals(Cylinder other){
        return this.axis.equals(other.getAxis()) &&
                this.height == other.getHeight() &&
                this.rad == other.getRad();
    }

    @Override
    public String toString() {
        return "Cylinder: " +
                "rad=" + rad +
                ", height=" + height +
                ", axis=" + axis;
    }
}
