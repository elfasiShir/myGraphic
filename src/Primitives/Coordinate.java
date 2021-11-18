package Primitives;

import java.util.Objects;

public class Coordinate {
    private double value;

    public Coordinate(){ this.value = 0.0;}
    public Coordinate(double value){this.value = value;}
    public Coordinate(Coordinate other){this.value = other.value;}
    public double getValue(){return this.value;}
    public void setValue(double value){this.value = value;}
    public double add(Coordinate other){ return this.value + other.getValue();}
    @Override
    public String toString() { return "" + value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return ((this.value - that.getValue() < 0.000000005) && (that.getValue() - this.value < 0.00000000005));
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
