
import entities.Address;
import entities.Employee;
import entities.Movie;
import entities.People;
import enumns.RoleEnumn;


public class Application {
    public static void main(String[] args) {

        Movie oPresente = new Movie("O Presente", 2015, "SOUNDTRACK");

        Employee joelEdgerton = new Employee("Joel Edgerton", "123.123.123-12",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal"));
        joelEdgerton.addRole(RoleEnumn.Actor);
        joelEdgerton.addRole(RoleEnumn.Screenwriter);
        joelEdgerton.addRole(RoleEnumn.MovieDirector);
        joelEdgerton.addRole(RoleEnumn.Productor);
        oPresente.addCast(joelEdgerton);
        oPresente.addScreenwriter(joelEdgerton);
        oPresente.addmovieDirector(joelEdgerton);
        oPresente.addProductor(joelEdgerton);

        Employee jasonBateman = new Employee("Jason Bateman", "321.321.321-21",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal"));
        jasonBateman.addRole(RoleEnumn.Actor);
        oPresente.addCast(jasonBateman);

        Employee brianBaugh = new Employee("Brian Baugh", "987.987.987-98",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal")
                );
        brianBaugh.addRole(RoleEnumn.Cameraman);
        oPresente.addCameraman(brianBaugh);

        Employee jasonBlum = new Employee("Jason Blum", "654.654.654-65",
                new Address("Rua tal", "Numero tal", "Bairro tal", "Cidade tal",
                        "Estado tal", "Pais tal")
                );
        jasonBlum.addRole(RoleEnumn.Productor);
        oPresente.addProductor(jasonBlum);

        joelEdgerton.addMovieIntoFilmography(oPresente);
        jasonBateman.addMovieIntoFilmography(oPresente);
        brianBaugh.addMovieIntoFilmography(oPresente);
        jasonBlum.addMovieIntoFilmography(oPresente);

        joelEdgerton.showFilmography();
        System.out.println("-----");
        jasonBateman.showFilmography();
        System.out.println("-----");
        brianBaugh.showFilmography();
        System.out.println("-----");
        jasonBlum.showFilmography();

        System.out.println("\nCaracteristicas do filme:");
        System.out.println(oPresente.showFeatures());

    }
}
