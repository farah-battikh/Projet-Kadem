package tn.esprit.springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Service.EtudiantService;
import tn.esprit.springproject.Service.iChambreService;
import tn.esprit.springproject.Service.iEtudiantService;
import tn.esprit.springproject.entity.Etudiant;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController
{

    @Autowired
    private iEtudiantService etudiantsevice;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
    List<Etudiant> listEtudiants = etudiantsevice.retrieveAllEtudiants();
    return listEtudiants;
}
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) { return etudiantsevice.retrieveEtudiant(etudiantId);
    }
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantsevice.addEtudiant(e);
        return etudiant;
    }
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) { etudiantsevice.removeEtudiant(etudiantId);
    }
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= etudiantsevice.updateEtudiant(e);
        return etudiant;
    }
    @PostMapping("/affecter-etud/{nomEt}/{prenomEt}/{idReservation}")
    public Etudiant affecterEtudiantAReservation(  @PathVariable("nomEt") String nomEt,@PathVariable("prenomEt") String prenomEt,@PathVariable("idReservation") long idReservation)

    {

        return etudiantsevice.affecterEtudiantAReservation( nomEt,  prenomEt,  idReservation);
    }


}
