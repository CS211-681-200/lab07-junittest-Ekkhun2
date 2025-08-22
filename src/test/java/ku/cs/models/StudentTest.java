package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private static Student s1, s2;

    /*
    @BeforeAll // เป็น constructor | จะถูกเรียก 1 ครั้งก่อนทุก method เสมอ
    public static void init(){
        s = new Student("67xxxxxx", "test");
    }
     */

    @BeforeEach
    public void init(){
        s1 = new Student("6710000001", "Alice");
        s2 = new Student("6710000002", "Magnus");
    }

    @Test
    public void testChangeName(){
        // (s2) --> Student("6710000002", "Magnus");

        s2.changeName(" Alice ");
        assertEquals("Alice", s2.getName());

        s2.changeName(" ");
        assertEquals("Alice", s2.getName());
    }

    @Test
    public void testAddScore(){
        // (s1) --> Student("6710000001", "Alice");

        s1.addScore(40);
        assertEquals(40, s1.getScore());

        s1.addScore(-100);
        assertEquals(40, s1.getScore());
    }

    @Test
    public void testCalculateGrade(){
        // (s1) --> Student("6710000001", "Alice");

        s1.addScore(30);
        assertEquals("F", s1.grade());

        s1.addScore(70);
        assertEquals("A", s1.grade());
    }

    @Test
    public void testIsId(){
        // (s1) --> Student("6710000001", "Alice");
        // (s2) --> Student("6710000002", "Magnus");
        String id = "6710000001";
        assertEquals(true, s1.isId(id));
        assertEquals(false, s2.isId(id));
    }

    @Test
    public void testIsNameContains(){
        // data --> Student("6710000001", "Alice");
        assertEquals(true, s1.isNameContains("lic"));
        assertEquals(false, s1.isNameContains("zoc"));
    }
}