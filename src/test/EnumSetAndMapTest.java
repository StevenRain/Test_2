import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import javax.sql.StatementEvent;
import java.lang.reflect.AnnotatedArrayType;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumSetAndMapTest {

    enum TestEnum {
        Steven,
        Anna,
        Katherine
    }

    @Test
    public void EnumSetTest() throws Exception {
        EnumMap<TestEnum, String> map = Maps.newEnumMap(TestEnum.class);
        map.put(TestEnum.Steven, "China");
        map.put(TestEnum.Anna, "Russia");
        map.entrySet().stream().forEach(System.out::println);
    }

    @Test
    public void EnumTest2() throws Exception {
        EnumSet<TestEnum> set = Sets.newEnumSet(Sets.newHashSet(), TestEnum.class);
        set.add(TestEnum.Steven);
        set.add(TestEnum.Katherine);
        set.forEach(System.out::println);
    }
}
