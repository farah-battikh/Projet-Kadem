package tn.esprit.springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Service.iReservationService;
import tn.esprit.springproject.entity.Reservation;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private iReservationService reservationService;


    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation e) {
        Reservation reservation = reservationService.addReservation(e);
        return reservation;
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation e) {
        Reservation reservation = reservationService.updateReservation(e);
        return reservation;
    }}

