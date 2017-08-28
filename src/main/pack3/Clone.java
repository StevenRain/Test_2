package pack3;

class Person implements Cloneable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Clone {

    public static void main(String[] args) throws Exception{
        Person person1 = new Person("Steven", 24);
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i < 1000000; i++) {
            Person person2 = new Person("Steven" + i, 24);
        }
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        for (int i=0;i<1000000;i++) {
            Person person3 = (Person) person1.clone();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
        System.out.println(endTime2 - startTime2);
    }
}
