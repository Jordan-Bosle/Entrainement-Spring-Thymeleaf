package training.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Personne implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    private String nom;

    private String prenom;

    private int age;


    public Personne() {

    }

    public Personne(long id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
}
