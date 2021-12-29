package Geometrics;
import Primitives.*;
import java.util.List;
import java.awt.Color;
import java.util.List;

public abstract class Geometry {
    Color _emission;
    Material _material;

    public abstract List<GeoPoint> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point);


    public Color getEmission() { return _emission; }
    public void setEmission(Color emission) { this._emission = emission; }

    public void setMaterial(Material _material) {this._material = _material;}
    public Material getMaterial() {return _material;}
}