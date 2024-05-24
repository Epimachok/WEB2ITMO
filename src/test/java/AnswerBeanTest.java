import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import beans.AnswerBean;

public class AnswerBeanTest {

    private AnswerBean answerBean;

    @Before
    public void init() {
        answerBean = new AnswerBean();
    }

    
    @Test
    public void testDefaultValues() {
        assertEquals("Default X should be -10", -10.0, answerBean.getX(), 0.01);
        assertEquals("Default Y should be -10", -10.0, answerBean.getY(), 0.01);
        assertEquals("Default R should be -10", -10.0, answerBean.getR(), 0.01);
        assertEquals("Default ans should be 'Not Good'", "Not Good", answerBean.getAns());
    }

    @Test
    public void testSettersAndGetters() {
        answerBean.setX(5.0f);
        assertEquals("Set X should be 5.0", 5.0, answerBean.getX(), 0.01);

        answerBean.setY(5.5f);
        assertEquals("Set Y should be 5.5", 5.5, answerBean.getY(), 0.01);

        answerBean.setR(1.0f);
        assertEquals("Set R should be 1.0", 1.0f, answerBean.getR(), 0.01);
    }
}
