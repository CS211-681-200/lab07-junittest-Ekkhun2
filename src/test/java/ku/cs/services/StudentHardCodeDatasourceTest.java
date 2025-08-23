package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    public void testReadData(){
        String output = "[{id: '6710400001', name: 'First', score: 0.0}, " +
                        "{id: '6710400002', name: 'Second', score: 0.0}, " +
                        "{id: '6710400003', name: 'Third', score: 0.0}, " +
                        "{id: '6710400004', name: 'Fourth', score: 0.0}]";

        StudentHardCodeDatasource studentDataSource = new StudentHardCodeDatasource();
        StudentList sList = studentDataSource.readData();

        assertEquals(4, sList.getStudents().size());
        assertEquals(output, sList.getStudents().toString());
    }
}