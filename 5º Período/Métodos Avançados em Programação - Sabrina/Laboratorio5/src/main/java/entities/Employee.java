package entities;

import enumns.RoleEnumn;
import exceptions.EmployeeCantBeActorAndCameramanException;
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

    public String clockIn() {
        return "Punched the clock!";
    }

    public void showFilmography() {
        for (Movie i : filmography) {
            System.out.println("Filme: " + i.getName());
            i.getMovieDirectors().stream().filter(director -> director.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi Diretor");
            });
            i.getCast().stream().filter(actor -> actor.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi Ator");
            });
            i.getScreenwriters().stream().filter(screenwriter -> screenwriter.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi Roteirista");
            });
            i.getCameramans().stream().filter(cameraman -> cameraman.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi Cameraman");
            });
            i.getProductors().stream().filter(productor -> productor.getName().equals(this.getName())).forEach(x -> {
                System.out.println("\"" + x.getName() + "\" foi Produtor");
            });

        }
    }

    public void addRole(RoleEnumn role) {
        for (RoleEnumn i : roles) {
            if (role == RoleEnumn.Cameraman && i == RoleEnumn.Actor) {
                throw new EmployeeCantBeActorAndCameramanException("O empregado não pode ser cameraman e ator ao mesmo tempo");
            }
        }
        roles.add(role);
    }

    public void addMovieIntoFilmography(Movie movie) {
        filmography.add(movie);
    }
}
