package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    private static StudentListFileDatasource sListFileDataSource;

    @BeforeAll
    public static void init(){
        sListFileDataSource = new StudentListFileDatasource("data", "student-list.csv");
    }

    @Test
    public void testReadData(){
        String output = "[{id: '6410450001', name: 'Tim Berners-Lee', score: 145.5}, " +
                        "{id: '6410450002', name: 'Barbara Liskov', score: 60.7}, " +
                        "{id: '6410450003', name: 'Alan Turing', score: 346.2}, "  +
                        "{id: '6410450004', name: 'John McCarthy', score: 63.8}, " +
                        "{id: '6410450005', name: 'Alan Kay', score: 68.0}]";

        StudentList sList = sListFileDataSource.readData();

        assertEquals(5, sList.getStudents().size());
        assertEquals(output, sList.getStudents().toString());
    }

    @Test
    public void testWriteData(){
        String output1 = "[{id: '6410450001', name: 'Tim Berners-Lee', score: 145.5}, " +
                         "{id: '6410450002', name: 'Barbara Liskov', score: 60.7}, " +
                         "{id: '6410450003', name: 'Alan Turing', score: 346.2}, "  +
                         "{id: '6410450004', name: 'John McCarthy', score: 63.8}, " +
                         "{id: '6410450005', name: 'Alan Kay', score: 68.0}]";

        String output2 = "[{id: '6410450001', name: 'Student1', score: 145.5}, " +
                         "{id: '6410450002', name: 'Student2', score: 60.7}, "  +
                         "{id: '6410450003', name: 'Student3', score: 346.2}, " +
                         "{id: '6410450004', name: 'Student4', score: 63.8}, "  +
                         "{id: '6410450005', name: 'Student5', score: 68.0}]";

        StudentList sList1 = sListFileDataSource.readData();
        assertEquals(output1, sList1.getStudents().toString());

        StudentList sList2 = new StudentList();
        sList2.addNewStudent("6410450001","Student1",145.5);
        sList2.addNewStudent("6410450002","Student2",60.7);
        sList2.addNewStudent("6410450003","Student3",346.2);
        sList2.addNewStudent("6410450004","Student4",63.8);
        sList2.addNewStudent("6410450005","Student5",68.0);

        sListFileDataSource.writeData(sList2);                  // overwrite data from sList2 to student-list.csv
        sList2 = studentsAddNewStudent(sList1.getStudents());   // copy the data from sList1 to sList2
        sList1 = sListFileDataSource.readData();
        assertEquals(output2, sList1.getStudents().toString());

        /////////////////////////////////////////////////////////////////////////////
        // rewrite sList1 data to student-list.csv                                 //
        sListFileDataSource.writeData(sList2);                                     //
        /////////////////////////////////////////////////////////////////////////////
    }

    public StudentList studentsAddNewStudent(ArrayList<Student> sList){
        StudentList newList = new StudentList();
        for (int i = 0; i < sList.size(); i++){
            newList.addNewStudent(sList.get(i).getId(), sList.get(i).getName(), sList.get(i).getScore());
        }
        return newList;
    }
}