package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {
    @Test
    public void testReadData(){
        StudentListHardCodeDatasource sListDataSource = new StudentListHardCodeDatasource();
        StudentList sList = sListDataSource.readData();

        assertEquals(10, sList.getStudents().size());
    }
}