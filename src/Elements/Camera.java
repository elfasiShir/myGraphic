package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Camera {
    private Point3D P0;
    private Vector vUp;
    private Vector vRight;
    private Vector vTo;

    public Camera(Point3D p0, Vector vUp, Vector vTo){
        this.P0 = new Point3D(p0);
        this.vUp = new Vector(vUp);
        this.vTo = new Vector(vTo);
        this.vRight = vUp.crossProduct(vTo);
    }
    public Camera(){
        this.P0 = new Point3D();
        this.vUp = new Vector();
        this.vRight = new Vector();
        this.vTo = new Vector();
    }
    public Point3D getP0() {
        return this.P0;
    }
    public Vector getvLeft() {
        return this.vRight;
    }
    public Vector getvTo() {
        return this.vTo;
    }
    public Vector getvUp() {
        return this.vUp;
    }
    public void setP0(Point3D p0) {
        this.P0 = new Point3D(p0);
    }
    public void setP0(double x, double y, double z){
        this.P0 = new Point3D(x, y, z);
    }
    public void setvLeft(Vector vLeft) {
        this.vRight = new Vector(vLeft);
    }
    public void setvTo(Vector vTo) {
        this.vTo = new Vector(vTo);
    }
    public void setvUp(Vector vUp) {
        this.vUp = new Vector(vUp);
    }

    public boolean equals(Camera other){
        return this.P0.equals(other.getP0()) && this.vTo.equals(other.getvTo()) &&
                this.vRight.equals(other.getvLeft()) && this.vUp.equals(other.getvUp());
    }

    @Override
    public String toString() {
        return "Camera:" +
                "P0 = " + P0 +
                ", vUp = " + vUp +
                ", vLeft = " + vRight +
                ", vTo = " + vTo;
    }

    public Ray constructRayThroughPixel(int nX, int nY, double j, double i,
                                        double screenDist, double screenWidth ,double screenHeight){

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;
        Point3D Pc = this.P0.add(this.vTo.scale(screenDist));
        double Yi = (i - (nY / (2 * Ry)) + (Ry / 2));
        double Xj = (j - (nX / (2 * Rx)) + (Rx / 2));
        Point3D Pij = Pc.add( this.vRight.scale((j - ((nX - 1) / 2)) * Rx).subtract( this.vUp.scale((i - ((nY - 1) / 2 )) * Ry)));
        Vector Vij = Pij.subtract(this.P0);

        return new Ray(this.P0, Vij.normalize());
    }
}