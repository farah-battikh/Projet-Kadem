package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Foyer;

import java.util.List;


@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {


    @Query("SELECT f FROM Foyer f ORDER BY f.nomFoyer")
    List<Foyer> findAllSortedByName();
    @Query("SELECT AVG(f.capaciteFoyer) FROM Foyer f")
    Double calculateAverageCapacity();

    @Query("SELECT MAX(f.capaciteFoyer) FROM Foyer f")
    Long findMaxCapacity();

}
