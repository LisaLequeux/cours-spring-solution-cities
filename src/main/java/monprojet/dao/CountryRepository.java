package monprojet.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {

    // Méthode 1 à ajouter : renvoyer la population d'un pays à partir de son id
    @Query(value = "SELECT SUM(population) AS population"
            +"FROM country INNER JOIN city USING id"
            +"WHERE country.id = : idPays",
            nativeQuery = true)
    public int Integer(int idPays);

    // Méthode 2 à ajouter : renvoyer la liste avec le nom et la population des pays sans paramètres
    @Query(value = "SELECT country.name, SUM(population) AS population"
            +"FROM country INNER JOIN city USING id"
            +"GROUP BY name, country.id",
            nativeQuery = true)
    public List<PPP> PopParPays();
}
