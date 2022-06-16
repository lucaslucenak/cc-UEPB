import entities.Address;
import entities.Employee;
import entities.Movie;
import enumns.RoleEnumn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    Employee joelEdgerton;
    Employee jasonBateman;
    Movie oPresente;

    @BeforeEach
    void setUp() throws Exception {
        joelEdgerton = new Employee("Joel Edgerton", "123.123.123-12",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal"));


        jasonBateman = new Employee("Jason Bateman", "321.321.321-21",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal"));

        oPresente = new Movie("O Presente", 2015, "SOUNDTRACK");
    }

    @Test
    public void shouldAddRoleIntoEmployee() {
        joelEdgerton.addRole(RoleEnumn.Actor);
        Assertions.assertEquals(RoleEnumn.Actor, joelEdgerton.getRoles().get(0));
    }

    @Test
    public void shouldAddMovieIntoFilmography() {
        joelEdgerton.addMovieIntoFilmography(oPresente);
        Assertions.assertEquals(oPresente, joelEdgerton.getFilmography().get(0));
    }

    @Test
    public void shouldPunchTheClock() {
        Assertions.assertEquals(joelEdgerton.clockIn(), "Punched the clock!");
    }
}
