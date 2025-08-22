package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    private static StudentListFileDatasource sListFileDataSource;

    @BeforeAll
    public static void init(){
        sListFileDataSource = new StudentListFileDatasource("data", "student-list.csv");
    }

    @Test
    public void testReadData(){
        StudentList sList = sListFileDataSource.readData();
        assertEquals(5, sList.getStudents().size());
    }

    @Test
    public void testWriteData(){
        String input =  "6410450001,Tim Berners-Lee,145.5\n" +
                        "6410450002,Barbara Liskov,60.7\n" +
                        "6410450003,Alan Turing,346.2\n" +
                        "6410450004,John McCarthy,63.8\n" +
                        "6410450005,Alan Kay,68.0";

        StudentList sList = sListFileDataSource.readData();
        assertEquals()
    }
}