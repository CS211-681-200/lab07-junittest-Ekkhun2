package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {
    @Test
    public void testReadData(){
        String output = "[{id: '6710400001', name: 'First', score: 0.0}, " +
                        "{id: '6710400002', name: 'Second', score: 0.0}, " +
                        "{id: '6710400003', name: 'Third', score: 0.0}, "  +
                        "{id: '6710400004', name: 'Fourth', score: 0.0}, " +
                        "{id: '6710400005', name: 'Fifth', score: 0.0}, "  +
                        "{id: '6710400006', name: 'Sixth', score: 0.0}, "  +
                        "{id: '6710400007', name: 'Seventh', score: 0.0}, " +
                        "{id: '6710400008', name: 'Eighth', score: 0.0}, " +
                        "{id: '6710400009', name: 'Ninth', score: 0.0}, "  +
                        "{id: '67104000010', name: 'Tenth', score: 0.0}]";

        StudentListHardCodeDatasource sListDataSource = new StudentListHardCodeDatasource();
        StudentList sList = sListDataSource.readData();

        assertEquals(10, sList.getStudents().size());
        assertEquals(output, sList.getStudents().toString());

    }
}