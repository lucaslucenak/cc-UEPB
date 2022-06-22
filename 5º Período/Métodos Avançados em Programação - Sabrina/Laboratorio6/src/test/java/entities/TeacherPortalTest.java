package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeacherPortalTest {
    TeacherPortal teacherPortal;

    @BeforeEach
    void setUp() {
        teacherPortal = new TeacherPortal();
    }

    @Test
    public void shouldAllocateSubjectIntoTeacher() {
        StringBuilder expected = new StringBuilder("Alocando o(a) professor(a) Sabrina para a disciplina MAP");
        Assertions.assertEquals(expected.toString(), teacherPortal.allocateSubjectIntoTeacher("Sabrina", "MAP").toString());
    }

    @Test
    public void shouldCheckTeachersDisponibility() {
        StringBuilder expected = new StringBuilder("Verificando disponibilidade do(a) professor(a) Sabrina");
        Assertions.assertEquals(expected.toString(), teacherPortal.checkTeachersDisponibility("Sabrina").toString());
    }

    @Test
    public void shouldGetTeachersCompanyTime() {
        StringBuilder expected = new StringBuilder("Tempo de casa do professor(a) Sabrina");
        Assertions.assertEquals(expected.toString(), teacherPortal.getCompanyTime("Sabrina").toString());
    }
}
