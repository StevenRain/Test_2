package pack3;

import java.net.URLDecoder;

public class Decode {

    public static void main(String[] args) {
        String example =
                "ss";
        String result = URLDecoder.decode(example);
        System.out.println(result);
    }
}
