package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InfrastructuralSystemTest {
    InfrastructuralSystem infrastructuralSystem;

    @BeforeEach
    void setUp() {
        infrastructuralSystem = new InfrastructuralSystem();
    }

    @Test
    public void shouldAllocateClassroom() {
        StringBuilder expected = new StringBuilder("Alocando a sala 200B");
        Assertions.assertEquals(expected.toString(), infrastructuralSystem.allocateClassroom("200B").toString());
    }

    @Test
    public void shouldCheckClassroomDisponibility() {
        StringBuilder expected = new StringBuilder("Verificando a disponibilidade da sala 200B");
        Assertions.assertEquals(expected.toString(), infrastructuralSystem.checkClassroomDisponibility("200B").toString());
    }
}
