package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
}
