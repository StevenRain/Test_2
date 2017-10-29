package pack3;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SortExample {

    public static void main(String[] args) {
        List<Long> list1 = Lists.newArrayList();
        List<Long> list2 = Lists.newArrayList();
        for(long i=0;i<1000000;i++) {
            list1.add((long)new Random().nextInt(100));
        }

        list2 = Lists.newArrayList(list1);


        Stopwatch stopwatch1 = Stopwatch.createStarted();
        list1.sort(Comparator.naturalOrder());
        stopwatch1.stop();
        System.out.println(stopwatch1.elapsed(TimeUnit.MILLISECONDS));


        Stopwatch stopwatch = Stopwatch.createStarted();
        Collections.sort(list2);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
