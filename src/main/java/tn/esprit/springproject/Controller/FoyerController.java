package tn.esprit.springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Service.iFoyerService;
import tn.esprit.springproject.entity.Foyer;
import tn.esprit.springproject.entity.Notification;
import tn.esprit.springproject.entity.StatistiquesFoyers;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@CrossOrigin(origins = "*")
public class FoyerController {

    @Autowired
    private iFoyerService foyerService;


    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        return listFoyers;
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.retrieveFoyer(foyerId);
    }

    @PostMapping("/add-foyer")
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer) {
        try {
            Foyer addedFoyer = foyerService.addFoyer(foyer);


            foyerService.sendEmail("farah.battikh@esprit.tn", "Nouveau foyer disponible",
                    "Cher utilisateur,\n" +
                            "\n" +
                            "Nous avons le plaisir de vous informer qu'un nouveau foyer est disponible. Ce foyer est situé à Ariana Soghra, en Tunisie. Il dispose de 3 chambres, 2 salles de bains et d'une terrasse.\n" +
                            "\n" +
                            "Le foyer est équipé de tout le confort nécessaire, notamment d'une cuisine équipée, d'une climatisation et d'un parking. Il est également situé à proximité des commodités, notamment des écoles, des commerces et des transports publics.\" n\" +" +
                            "Cordialement. ");

            System.out.println("Email sent successfully");

            return new ResponseEntity<>(addedFoyer, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error adding foyer or sending email: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }

    @PutMapping("/update-foyer")
    public ResponseEntity<?> updateFoyer(@RequestBody Foyer e) throws Exception {
      try{
          return new ResponseEntity<>(foyerService.updateFoyer(e),HttpStatus.CREATED);

      }
catch (Exception exp){
          return new ResponseEntity<>(exp.getMessage(),HttpStatus.NOT_FOUND);
}
    }
    @PutMapping("/add-foyerwith-bloc")
    public Foyer addFoyerWithBloc(@RequestBody Foyer f){

        Foyer foyer = foyerService.addFoyerWithBloc(f);

        return foyer ;

    }


    @PostMapping("/createNotification")
    public ResponseEntity<String> createNotification(@RequestParam String username, @RequestParam String message) {
        foyerService.createNotification(username, message);
        return new ResponseEntity<>("Notification créée avec succès", HttpStatus.CREATED);
    }


    @GetMapping("/sortedByName")
    public ResponseEntity<List<Foyer>> getAllFoyersSortedByName() {
        List<Foyer> foyers = foyerService.getAllFoyersSortedByName();
        return new ResponseEntity<>(foyers, HttpStatus.OK);
    }
    @GetMapping("/statistics")
    public ResponseEntity<StatistiquesFoyers> getFoyersStatistics() {
        StatistiquesFoyers statistiques = foyerService.getFoyersStatistics();
        return new ResponseEntity<>(statistiques, HttpStatus.OK);
    }
}
