
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class TestSolution {

    @Test
    public void testAlgo(){
        try {
            int a = 10/0;
        }catch (Exception e){
            System.out.println("捕获异常");
        }
    }
}
