package pack3;


public class SaveVarargs {

    @SafeVarargs
    private static <T> T getResult(T... args) {
        return args.length > 0?args[0]:null;
    }

    public static void main(String[] args) {
        String str = "If the night is not forever, we are still together.";
        String[] strings = str.split(" ");
        String result = getResult(strings);
        System.out.println(result);

        String str1 = "Steven";
        String str2 = new String("Steven");
        System.out.println(str1.equals(str2));
    }
}
