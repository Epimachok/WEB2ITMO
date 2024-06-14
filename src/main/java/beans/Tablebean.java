package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablebean implements Serializable {
    private ArrayList<Float> x = new ArrayList<>();

    
    private ArrayList<Float> y = new ArrayList<>();
    private ArrayList<Float> r = new ArrayList<>();



    private ArrayList<String> Ans = new ArrayList<>();
    public Tablebean(){}

    public void setY(ArrayList<Float> y) {
        this.y = y;
    }

    public void setX(ArrayList<Float> x) {
        this.x = x;
    }

    public void setR(ArrayList<Float> r) {
        this.r = r;
    }

    public void setAns(ArrayList<String> ans) {
        Ans = ans;
    }

    public ArrayList<Float> getR() {
        return r;
    }

    public ArrayList<Float> getX() {
        return x;
    }

    public ArrayList<Float> getY() {
        return y;
    }

    public ArrayList<String> getAns() {
        return Ans;
    }
    public void addX(float i){
        this.x.add(i);
    }
    public void addY(float i){
        this.y.add(i);
    }
    public void addR(float i){
        this.r.add(i);
    }
    public void addAns(String i){
        this.Ans.add(i);
    }
}
