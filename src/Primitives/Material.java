package Primitives;

import java.util.Objects;

public class Material {
    private double _kd = 0d;
    private double _ks = 0d;
    private int _Shininess = 1;

    public Material(Material material) {
        _kd = material.getKd();
        _ks = material.getKs();
        _Shininess = material.getShininess();
    }

    public Material() {
        _kd = 0d;
        _ks = 0d;
    }

    public Material(double kd, double ks, int nS) {
        _kd = kd;
        _ks = ks;
        _Shininess = nS;
    }
    

    public double get_kd() {
        return _kd;
    }

    public int get_Shininess() {
        return _Shininess;
    }

    public double getKd() {
        return _kd;
    }

    public void setKd(double kd) {
        _kd = kd;
    }


    public double getKs() {
        return _ks;
    }

    public void setKs(double ks) {
        _ks = ks;
    }

    public int getShininess() {
        return _Shininess;
    }

    public void setShininess(int nShininess) {
        _Shininess = nShininess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Double.compare(material._kd, _kd) == 0 && Double.compare(material._ks, _ks) == 0 && _Shininess == material._Shininess;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_kd, _ks, _Shininess);
    }
}
