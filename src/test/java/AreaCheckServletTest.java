import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import org.mainpack.AreaCheckServlet;

public class AreaCheckServletTest {

    @Test
    public void testCheckArea() {
        AreaCheckServlet servlet = new AreaCheckServlet();

        // Проверка первой четверти (должен быть Miss)
        assertFalse("Point in the first quadrant should be a miss", servlet.checkArea(1, 1, 2));

        // Проверка второй четверти (должен быть Hit в рамках круга)
        assertTrue("Point in the second quadrant within the circle should be a hit", servlet.checkArea(-1, 1, 2));

        // Проверка третьей четверти (должен быть Hit в рамках прямоугольника)
        assertTrue("Point in the third quadrant within the rectangle should be a hit", servlet.checkArea(-1, -1, 2));

        // Проверка четвертой четверти (должен быть Hit в рамках треугольника)
        assertFalse("Point in the fourth quadrant within the triangle should be a miss", servlet.checkArea(1, -1, 2));

        // Проверка условий, выходящих за рамки заданных границ
        assertFalse("Point outside the defined bounds should be a miss", servlet.checkArea(-6, -6, 2));
    }
}