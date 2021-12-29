package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class PointLight extends Light {
    Point3D _position;
    double _kc;
    double _kl;
    double _kq;

    public PointLight(Color c, Point3D _position,double _kc, double _kl, double _kq){
        this._intensity = c;
        this._position = _position;
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    public Point3D getPosition() {return _position;}
    public double get_kc() {return _kc;}
    public double get_kl() {return _kl;}
    public double get_kq() {return _kq;}

    public void setPosition(Point3D _position) {this._position = _position;}
    public void set_kc(double _kc) {this._kc = _kc;}
    public void set_kl(double _kl) {this._kl = _kl;}
    public void set_kq(double _kq) {this._kq = _kq;}

    @Override
    public Color getIntensity(Point3D p) {
        double d = getPosition().distance(p);
        double coefficient = 1 / (_kc + _kl * d + _kq * Math.pow(d, 2));
        return colorMultiplyDouble(_intensity, coefficient);
    }
    @Override
    public Vector getL(Point3D p) {
        return _position.subtract(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointLight)) return false;
        PointLight that = (PointLight) o;
        return Double.compare(that._kc, _kc) == 0 && Double.compare(that._kl, _kl) == 0 && Double.compare(that._kq, _kq) == 0 && _position.equals(that._position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_position, _kc, _kl, _kq);
    }
}
