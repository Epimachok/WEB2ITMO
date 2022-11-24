package beans;

import java.io.Serializable;

public class AnswerBean implements Serializable {
    private float x = -10;
    private float y = -10;
    private float r = -10;
    private String ans = "Not Good";
    public AnswerBean(){
    }

    public float getR() {
        return r;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
