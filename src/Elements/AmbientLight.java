package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class AmbientLight extends Light {
    double _ka = 0.1;

    //Constructors
    public AmbientLight() {}
    public AmbientLight(Color c, double ka) {
        this._intensity = c;
        this._ka = ka;
    }

    //Getter
    public double getKa() { return _ka; }

    //Setter
    public void setKa(double kA) { this._ka = kA; }

    //Override methods
    @Override
    public Color getIntensity(Point3D p) { return colorMultiplyDouble(_intensity, _ka); }

    @Override
    public Vector getL(Point3D p) {
        return new Vector(0,0,1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmbientLight)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._ka, _ka) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_ka);
    }
}