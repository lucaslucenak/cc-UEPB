package entities;

import interfaces.MovieIf;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Movie implements MovieIf {

    private String name;
    private Integer year;
    private String soundtrack;
    private List<Employee> movieDirectors = new ArrayList<>();
    private List<Employee> cast = new ArrayList<>();
    private List<Employee> screenwriters = new ArrayList<>();
    private List<Employee> cameramans = new ArrayList<>();
    private List<Employee> productors = new ArrayList<>();

    public Movie(String name, Integer year, String soundtrack) {
        this.name = name;
        this.year = year;
        this.soundtrack = soundtrack;
    }

    public Movie() {
    }

    public void addCameraman(Employee cameraman) {
        cameramans.add(cameraman);
    }

    public void addProductor(Employee productor) {
        productors.add(productor);
    }

    public void addmovieDirector(Employee movieDirector) {
        movieDirectors.add(movieDirector);
    }

    public void addCast(Employee caster) {
        cast.add(caster);
    }

    public void addScreenwriter(Employee screenwriter) {
        screenwriters.add(screenwriter);
    }

    @Override
    public String showFeatures() {
        String features = "";
        features += "Filme: " + name +
                "\nAno: " + year +
                "\nTrilha Sonora: " + soundtrack;
        features += "\nDiretores:";
        for (Employee i : movieDirectors) {
            features += i.getName() + ", ";
        }
        features +="\nAtores:";
        for (Employee i : cast) {
            features += i.getName() + ", ";
        }
        features += "\nRoteiristas:";
        for (Employee i : cast) {
            features += i.getName() + ", ";
        }
        features += "\nCinegrafistas:";
        for (Employee i : screenwriters) {
            features += i.getName() + ", ";
        }
        features += "Produtores:";
        for (Employee i : productors) {
            features += i.getName() + ", ";
        }

        return features;
    }
}
