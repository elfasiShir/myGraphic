package Primitives;

public class Cordinate {
    private double value;

    public Cordinate(double value){this.value = value;}
    public double getCordinate(){return this.value;}
    public void setCordinate(double value){this.value = value;}
    public boolean equals(Cordinate other){return this.value == other.getCordinate(); }
}
