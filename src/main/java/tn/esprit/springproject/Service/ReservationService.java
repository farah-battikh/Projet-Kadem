package tn.esprit.springproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Reservation;
import tn.esprit.springproject.Repository.ReservationRepository;

import java.util.Date;
import java.util.List;
import org.hibernate.query.Query;
@Service
public class ReservationService implements  iReservationService{
@Autowired
    ReservationRepository reservationRespository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRespository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation e) {
        return reservationRespository.save(e);
    }

    @Override
    public Reservation updateReservation(Reservation e) {
        return reservationRespository.save(e);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRespository.findById(idReservation).get();
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRespository.deleteById(idReservation);

    }

}
