import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void EveryBranchTest() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        assertFalse(SILab2.function(new User(null, "asd1234#", "jondoe@mail.com"),
                List.of(new User("jondoe@mail.com", "", "jondoe@mail.com"),
                        new User("moE", "", "moe@mail.com"))));
        assertFalse(SILab2.function(new User("jondoe", "jondoe", "jondoe.mail.com"), null));
        assertFalse(SILab2.function(new User("", "jondoe 1", " "), null));
    }

    @Test
    void MultipleConditionTest() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("jondoe", null, null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("jondoe", "jon123", null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        assertDoesNotThrow(() -> SILab2.function(new User("jondoe", "jon123", "jondoe.mail.com"), null));
    }
}