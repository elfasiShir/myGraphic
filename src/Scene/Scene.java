package Scene;
import Geometrics.Geometry;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private String name;
    private ArrayList<Geometry> geometries;
    public Scene(){
        this.name = "";
        this.geometries = new ArrayList<Geometry>();
    }
    public Scene(String name){
        this.name = name;
        this.geometries = new ArrayList<Geometry>();
    }
    public Scene(String name, Geometry geometry){
        this.name = name;
        this.geometries = new ArrayList<Geometry>();
        this.geometries.add(geometry);
    }
    public String getName(){return this.name;}
    public ArrayList<Geometry> getGeometries(){return this.geometries;}
    public void setName(String name){this.name = name;}
    public void setGeometries(ArrayList<Geometry> geometries) {this.geometries = geometries;}
    public void addGeometry(Geometry geometry){this.geometries.add(geometry);}

    public boolean equals(Scene other){
        if(this.getGeometries().size() != other.getGeometries().size()){
            return false;
        }else{
            List<Geometry> copy = new ArrayList<Geometry>(this.getGeometries());
            if(copy.retainAll(other.getGeometries())){
                return copy.size() == this.getGeometries().size();
            }
        }
        return false;
    }
}
