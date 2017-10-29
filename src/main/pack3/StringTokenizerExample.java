package pack3;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StringTokenizerExample {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for(long i=0;i<1000000;i++) {
            builder.append(i + " ");
        }
        String example = builder.toString();
        Stopwatch stopwatch = Stopwatch.createStarted();
        example.split(" ");
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        stopwatch.reset();
        stopwatch.start();
        StringTokenizer stringTokenizer = new StringTokenizer(example, " ");
        while (stringTokenizer.hasMoreElements()) {
            stringTokenizer.nextToken();
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
