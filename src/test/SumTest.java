import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;
import sun.reflect.Reflection;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumTest {

    @Test
    public void test1() throws Exception {
        List<BiFunction<String, String, Integer>> methods = Lists.newArrayList(
                (x,y) -> x.equals(y) ? 1 : 0,
                (x,y) -> x.equals(y) ? 2 : 0
        );

        long result = methods.stream().map(mehtod -> mehtod.apply("1", "1")).mapToInt(Integer::intValue).sum();
        System.out.println(result);
    }

    @Test
    public void test2() throws Exception {
        List<Integer> list1 = Lists.newArrayList(1,2,3,4);
        List<Integer> list2 = Lists.newArrayList(1,2,3,5);
        long x = IntStream.range(0, list1.size()).mapToLong(i -> list1.get(i).equals(list2.get(i)) ? 1L : 0).sum();
        System.out.println(x);
    }
}
