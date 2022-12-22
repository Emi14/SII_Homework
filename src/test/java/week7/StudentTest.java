package week7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.ListException;
import org.siit.homework.week7.exception.RetrieveException;
import org.siit.homework.week7.student.IStudent;
import org.siit.homework.week7.student.Student;
import org.siit.homework.week7.student.StudentImpl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class StudentTest
{
    private IStudent students = new StudentImpl();

    @BeforeEach
    public void setStudents() throws AddStudentException
    {

            Student student1 = students.addStudent("Eduard", "Pricopi","12.05.2001", "M", "5010512170029");
            Student student2 =  students.addStudent("Mircea", "Olteanu","01.09.1975", "M", "3750901170029");
            Student student3 = students.addStudent("Elena", "Miu","04.05.1985", "F", "5850504170029");
            Student student4 = students.addStudent("Silvia", "Georgiana","20.04.2000", "M", "5000420170029");

    }
    @Test
    public void test_DeleteStudent() throws DeleteStudentException
    {
         students.deleteStudent("5850504170029");
    }

    @Test
    public void test_RetrieveAllStudentsByAge() throws RetrieveException
    {
        System.out.println(students.retrieveAllByAge(22));
    }

    @Test
    public void test_ListStudentsByComparator() throws ListException
    {
        System.out.println(students.list("Birth Date"));
    }

}
