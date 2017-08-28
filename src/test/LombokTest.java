import lombok.*;
import org.junit.Test;

public class LombokTest {

    @Data
    @AllArgsConstructor
    @Builder
    static class Student {
        private int id;
        private String name;
    }

    @Test
    public void lombokTest() throws Exception {
        Student student = Student.builder()
                .id(1)
                .name("Katherine")
                .build();
        System.out.println(student);
    }
}
