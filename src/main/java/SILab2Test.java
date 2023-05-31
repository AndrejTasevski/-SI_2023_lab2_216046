import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class SILab2Test {
    private List<User> users = new ArrayList<User>();

    @Test
    void everyBranchTest(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertFalse(SILab2.function(new User(null, "p@ssword123","mail@yahoo.com"), new ArrayList<User>()));

        users.add(new User("username","password", "e-mail"));
        users.add(new User("mail@yahoo.com","password", "mail@yahoo.com"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username","osum", "nepravilen" ), null));

        assertFalse(SILab2.function(new User("random", "prazno mesto", "email@gmail.com"), null));

        assertFalse(SILab2.function(new User("random", "nemaspecijalniznaci", "email@gmail.com"), null));
    }

    @Test
    void MultipleCondition(){
        RuntimeException ex;
        //  if (user==null || user.getPassword()==null || user.getEmail()==null)
        assertTrue(SILab2.function(new User("username", "password", "email"), null));


        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "nebitno"), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "pass", null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }
}