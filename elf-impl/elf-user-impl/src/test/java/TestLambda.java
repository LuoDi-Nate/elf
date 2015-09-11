import java.util.Arrays;
import java.util.List;

/**
 * Created by di on 11/9/15.
 */
public class TestLambda {
    public static void main(String[] args) {
        Integer[] testArray = {1,2,3,4,5,6,7,8,9,0};

        List<Integer> intList = Arrays.asList(testArray);

        intList.forEach( (integer -> print(integer)) );
    }

    private static void print(Integer integer){
        System.out.println(integer);
    }
}
