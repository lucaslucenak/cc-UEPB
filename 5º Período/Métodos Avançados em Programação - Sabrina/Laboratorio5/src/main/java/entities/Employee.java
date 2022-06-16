package entities;

import enumns.RoleEnumn;
import interfaces.EmployeeIf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Employee extends People implements EmployeeIf {
    List<RoleEnumn> roles  = new ArrayList<>();
    List<Movie> filmography = new ArrayList<>();

    public Employee(String name, String CPF, Address address) {
        super(name, CPF, address);
    }

    public void clockIn() {
        System.out.println("Punched the clock!");
    }

    public void showFilmography() {
        for (Movie i : filmography) {
            i.getMovieDirectors().stream().filter(director -> director.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi diretor do filme \"" + i.getName() + "\"");
            });
        }
        for (Movie i : filmography) {
            i.getCast().stream().filter(actor -> actor.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi ator do filme \"" + i.getName() + "\"");
            });
        }
        for (Movie i : filmography) {
            i.getScreenwriters().stream().filter(screenwriter -> screenwriter.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi roteirista do filme \"" + i.getName() + "\"");
            });
        }
        for (Movie i : filmography) {
            i.getCameramans().stream().filter(cameraman -> cameraman.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi cameraman do filme \"" + i.getName() + "\"");
            });
        }
        for (Movie i : filmography) {
            i.getProductors().stream().filter(productor -> productor.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi produtor do filme \"" + i.getName() + "\"");
            });
        }
    }

    public void addRole(RoleEnumn role) {
        roles.add(role);
    }

    public void addMovieIntoFilmography(Movie movie) {
        filmography.add(movie);
    }
}
