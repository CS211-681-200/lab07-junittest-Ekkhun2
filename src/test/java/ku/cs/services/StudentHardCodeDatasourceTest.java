package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    public void testReadData(){
        StudentHardCodeDatasource studentDataSource = new StudentHardCodeDatasource();
        StudentList sList = studentDataSource.readData();

        assertEquals(4, sList.getStudents().size());
    }
}