package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentPortalTest {
    StudentPortal studentPortal;

    @BeforeEach
    void setUp() {
        studentPortal = new StudentPortal();
    }

    @Test
    public void shouldGetStudentHistory() {
        StringBuilder expected = new StringBuilder("Suposto histórico do aluno Lucas");
        Assertions.assertEquals(expected.toString(), studentPortal.getStudentHistory("Lucas").toString());
    }

    @Test
    public void shouldGetStudentRDM() {
        StringBuilder expected = new StringBuilder("Suposto RDM do aluno Daniel");
        Assertions.assertEquals(expected.toString(), studentPortal.getStudentRDM("Daniel").toString());
    }
}
