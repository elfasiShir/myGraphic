package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class DirectionalLight extends Light {
    Vector _direction;

    public DirectionalLight(Vector v){
        this._direction = v;
    }
    public DirectionalLight(Color c, Vector v){
        this._intensity = c;
        this._direction = v;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public Color getIntensity(Point3D p) {
        return _intensity;
    }
    @Override
    public Vector getL(Point3D p){
        return p.subtract(_direction.getHead());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectionalLight)) return false;
        DirectionalLight that = (DirectionalLight) o;
        return _direction.equals(that._direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_direction);
    }
}
