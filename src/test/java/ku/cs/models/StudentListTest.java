package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList sList;

    @BeforeEach
    public void init(){
        sList = new StudentList();
        sList.addNewStudent("6710000001", "Alice");
        sList.addNewStudent("6710000002", "Magnus");
        sList.addNewStudent("6710000003", "Chara");
    }

    @Test
    public void testAddNewStudent(){
        /*
        sList = StudentList<Student>[
        sList.addNewStudent("6710000001", "Alice");
        sList.addNewStudent("6710000002", "Magnus");
        sList.addNewStudent("6710000003", "Chara");]
        */

        assertEquals(3, sList.getStudents().size());
        assertEquals(0, sList.getStudents().get(0).getScore());
        assertEquals(0, sList.getStudents().get(1).getScore());
        assertEquals(0, sList.getStudents().get(2).getScore());

        sList.addNewStudent("6710000004", "James", 50);
        sList.addNewStudent("6710000005", "Micheal", 60);

        assertEquals(5, sList.getStudents().size());
        assertEquals(50, sList.getStudents().get(3).getScore());
        assertEquals(60, sList.getStudents().get(4).getScore());
    }

    @Test
    public void testFindStudentById(){
        /*
        sList = StudentList<Student>[
        sList.addNewStudent("6710000001", "Alice");
        sList.addNewStudent("6710000002", "Magnus");
        sList.addNewStudent("6710000003", "Chara");]
        */

        assertEquals("Alice", sList.findStudentById("6710000001").getName());
        assertEquals("Magnus", sList.findStudentById("6710000002").getName());
        assertEquals("Chara", sList.findStudentById("6710000003").getName());
        assertEquals(null, sList.findStudentById("6710000004").getName());
    }

    @Test
    public void testFilterByName(){
        /*
        sList = StudentList<Student>[
        sList.addNewStudent("6710000001", "Alice");
        sList.addNewStudent("6710000002", "Magnus");
        sList.addNewStudent("6710000003", "Chara");]
        */

        sList.getStudents().get(0).changeName("Alan");
        sList.getStudents().get(1).changeName("Brian");
        sList.getStudents().get(2).changeName("Chara");

        StudentList sFilter = sList.filterByName("an");

        assertEquals("Alan", sFilter.getStudents().get(0).getName());
        assertEquals("Brian", sFilter.getStudents().get(1).getName());
    }

    @Test
    public void testGiveScoreToId(){
        /*
        sList = StudentList<Student>[
        sList.addNewStudent("6710000001", "Alice");
        sList.addNewStudent("6710000002", "Magnus");
        sList.addNewStudent("6710000003", "Chara");]
        */

        assertEquals(0, sList.getStudents().get(0).getScore());
        assertEquals(0, sList.getStudents().get(1).getScore());
        assertEquals(0, sList.getStudents().get(2).getScore());

        sList.giveScoreToId("6710000001", 90);
        sList.giveScoreToId("6710000002", 75);
        sList.giveScoreToId("6710000003", 22);

        assertEquals(90, sList.getStudents().get(0).getScore());
        assertEquals(75, sList.getStudents().get(1).getScore());
        assertEquals(22, sList.getStudents().get(2).getScore());
    }

    @Test
    public void testViewGradeOfId(){
        /* sList = StudentList<Student>[
        sList.addNewStudent("6710000001", "Alice");
        sList.addNewStudent("6710000002", "Magnus");
        sList.addNewStudent("6710000003", "Chara");]*/

        sList.giveScoreToId("6710000001", 90);
        sList.giveScoreToId("6710000002", 75);
        sList.giveScoreToId("6710000003", 22);

        assertEquals("A", sList.getStudents().get(0).grade());
        assertEquals("B", sList.getStudents().get(1).grade());
        assertEquals("F", sList.getStudents().get(2).grade());
    }
}