import com.epam.multi.lesson1.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.epam.multi.lesson1.LightsUtil.areDurationsCorrect;

public class LightsUnitTest {

    @Test
    public void areDurationsCorrectTest() {
        int[] in = {1, 2, 3};
        Assert.assertEquals(areDurationsCorrect(in), true);
    }

}
