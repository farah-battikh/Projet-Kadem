package tn.esprit.springproject.Service;
import tn.esprit.springproject.entity.Etudiant;
import java.util.*;


public interface iEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, Long idReservation);
}
