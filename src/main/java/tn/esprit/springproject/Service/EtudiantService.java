package tn.esprit.springproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Repository.ReservationRepository;
import tn.esprit.springproject.entity.Etudiant;

import tn.esprit.springproject.Repository.EtudiantRepository;
import tn.esprit.springproject.entity.Reservation;

import java.util.List;
@Service
public class EtudiantService implements iEtudiantService{

    @Autowired
    EtudiantRepository etudiantRespository;
    @Autowired
    ReservationRepository reservationRespository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRespository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRespository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRespository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRespository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRespository.deleteById(idEtudiant);

    }
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, Long idReservation) {
        Etudiant etudiant = etudiantRespository.findByNomEtAndPrenomEt(nomEt, prenomEt);
        Reservation reservation = reservationRespository.findById(idReservation).get();



        etudiant.getReservations().add(reservation);
        return etudiantRespository.save(etudiant);
    }




}
