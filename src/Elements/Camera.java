package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.Objects;

public class Camera {
    private Point3D P0;
    private Vector vUp;
    private Vector vRight;
    private Vector vTo;

    public Camera(Point3D p0, Vector to, Vector up){
        this.P0 = new Point3D(p0);
        this.vUp = new Vector(up.normalize());
        this.vTo = new Vector(to.normalize());
        this.vRight = to.crossProduct(up).normalize();
    }

    public Camera(){
        this.P0 = new Point3D();
        this.vUp = new Vector(0,-1,0);
        this.vRight = new Vector(1,0,0);
        this.vTo = new Vector(0,0,1);
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

//    public boolean equals(Camera other){
//        return this.P0.equals(other.getP0()) && this.vTo.equals(other.getvTo()) &&
//                this.vRight.equals(other.getvLeft()) && this.vUp.equals(other.getvUp());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camera)) return false;
        Camera camera = (Camera) o;
        return Objects.equals(P0, camera.P0) && Objects.equals(vUp, camera.vUp) && Objects.equals(vRight, camera.vRight) && Objects.equals(vTo, camera.vTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(P0, vUp, vRight, vTo);
    }

    @Override
    public String toString() {
        return "Camera:" +
                "P0 = " + P0 +
                ", vUp = " + vUp +
                ", vLeft = " + vRight +
                ", vTo = " + vTo;
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i,
                                        double screenDist, double screenWidth ,double screenHeight){
        Point3D pC = new Point3D(this.P0.add(this.vTo.scale(screenDist)));
        double rY = screenHeight / nY;
        double rX = screenWidth / nX;
        double xJ = (j - ((double)(nX - 1) / 2)) * rX;
        double yI = (i - ((double)(nY - 1) / 2)) * rY;

        /*
        double Yi = (i - (nY / (2 * Ry)) + (Ry / 2));
        double Xj = (j - (nX / (2 * Rx)) + (Rx / 2));
        Point3D Pij = Pc.add( this.vRight.scale((j - ((nX - 1) / 2)) * Rx).subtract( this.vUp.scale((i - ((nY - 1) / 2 )) * Ry)));
         */
        Point3D pIJ = new Point3D(pC);
        if(xJ != 0)
            pIJ = pIJ.add(this.getvLeft().scale(xJ));
        if (yI != 0)
            pIJ = pIJ.add(this.vUp.scale(-yI));
        Vector Vij = new Vector(pIJ.subtract(this.P0));
        return new Ray(this.P0, Vij.normalize());
    }

}