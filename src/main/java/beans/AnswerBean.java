package beans;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;





public class AnswerBean implements Serializable {

    private Locale locale = new Locale("en");
    private ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

    private float x = -10;
    private float y = -10;
    private float r = -10;
    private String ans = messages.getString("ans_not_good");
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
