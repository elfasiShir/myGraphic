package Geometrics;

import Primitives.Point3D;

public class GeoPoint {
    private Geometry _geometry;
    private Point3D _point;

    public GeoPoint(GeoPoint other) {
        this._geometry = other._geometry;
        this._point = other._point;
    }

    public Geometry getGeometry() { return _geometry; }
    public void setGeometry(Geometry _geometry) { this._geometry = _geometry; }

    public Point3D getPoint() { return _point; }

    public void setPoint(Point3D _point) { this._point = _point; }
    public GeoPoint(Geometry geometry2, Point3D point2) {
        _geometry = geometry2;
        _point = point2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof GeoPoint)) return false;
        GeoPoint oth = (GeoPoint)obj;
        return this._geometry == oth._geometry && this._point.equals(oth._point);
    }
}
