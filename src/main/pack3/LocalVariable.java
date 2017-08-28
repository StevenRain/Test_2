package pack3;

public class LocalVariable {
    public static int memberVariable = 0;

    public static void main(String[] args) {
        int localvariable = 0;
        long startTime = System.currentTimeMillis();
        for(int i=0; i<10000000; i++) {
            memberVariable ++;
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for(int i=0;i<10000000; i++) {
            localvariable ++;
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
