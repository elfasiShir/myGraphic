package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class SpotLight extends PointLight{
    private Vector _direction;

    public SpotLight(Color c, Point3D _position, Vector v, double _kc, double _kl, double _kq){
        super(c, _position, _kc, _kl, _kq);
        this._direction = v;
    }

    public Vector getDirection() {
        return _direction;
    }

    public void setDirection(Vector _direction) {
        this._direction = _direction;
    }
    //Override methods
    @Override
    public Color getIntensity(Point3D p) {
        double d = getPosition().distance(p);
        double numerator = Math.max(0, _direction.normalize().dotProduct(getL(p).normalize()));
        double denominator = _kc + _kl * d + _kq * Math.pow(d,2);
        return colorMultiplyDouble(_intensity, (numerator / denominator) );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpotLight)) return false;
        if (!super.equals(o)) return false;
        SpotLight spotLight = (SpotLight) o;
        return _direction.equals(spotLight._direction);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _direction);
    }
}
