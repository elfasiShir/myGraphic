package Primitives;

public class Coordinate {
    private double value;

    public Coordinate(){ this.value = 0.0;}
    public Coordinate(double value){this.value = value;}
    public Coordinate(Coordinate other){this.value = other.value;}
    public double getValue(){return this.value;}
    public void setValue(double value){this.value = value;}
    public boolean equals(Coordinate other){return this.value == other.getValue(); }
    public double add(Coordinate other){ return this.value + other.getValue();}
    @Override
    public String toString() { return "" + value; }

}
