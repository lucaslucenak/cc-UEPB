import entities.Address;
import entities.Employee;
import entities.Movie;
import enumns.RoleEnumn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {
    Employee joelEdgerton;
    Movie oPresente;

    @BeforeEach
    void setUp() throws Exception {
        oPresente = new Movie("O Presente", 2015, "SOUNDTRACK");

        joelEdgerton = new Employee("Joel Edgerton", "123.123.123-12",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal"));
    }

    @Test
    void shouldAddMovieDirectorRoleIntoEmployee() {
        joelEdgerton.addRole(RoleEnumn.MovieDirector);
        Assertions.assertEquals(RoleEnumn.MovieDirector, joelEdgerton.getRoles().get(0));
    }

    @Test
    void shouldAddCasterRoleIntoEmployee() {
        joelEdgerton.addRole(RoleEnumn.Actor);
        Assertions.assertEquals(RoleEnumn.Actor, joelEdgerton.getRoles().get(0));
    }

    @Test
    void shouldAddScreenwritersRoleIntoEmployee() {
        joelEdgerton.addRole(RoleEnumn.Screenwriter);
        Assertions.assertEquals(RoleEnumn.Screenwriter, joelEdgerton.getRoles().get(0));
    }

    @Test
    void shouldAddCameramanRoleIntoEmployee() {
        joelEdgerton.addRole(RoleEnumn.Cameraman);
        Assertions.assertEquals(RoleEnumn.Cameraman, joelEdgerton.getRoles().get(0));
    }

    @Test
    void shouldAddProductorRoleIntoEmployee() {
        joelEdgerton.addRole(RoleEnumn.Productor);
        Assertions.assertEquals(RoleEnumn.Productor, joelEdgerton.getRoles().get(0));
    }

}
