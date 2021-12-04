package Geometrics;
import Primitives.*;
import java.util.List;
import java.awt.Color;
import java.util.List;

public abstract class Geometry {
    Color _emission;
    public abstract List<GeoPoint> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point);
    public Color getEmission() { return _emission; }
    public void setEmission(Color emission) { this._emission = emission; }
}