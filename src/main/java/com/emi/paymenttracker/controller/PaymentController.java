package com.emi.paymenttracker.controller;


import org.springframework.context.PayloadApplicationEvent;
import org.springframework.web.bind.annotation.*;
import com.emi.paymenttracker.service.PaymentService;
import com.emi.paymenttracker.entity.Payment;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public void ajouterPayment(@RequestBody Payment payment) {
        service.ajouterPayment(payment);
    }

    @GetMapping
    public List<Payment> afficherList() {
        return service.affichevaleur();
    }

    @GetMapping("/{id}")
    public Payment afficherId(@PathVariable Long id) {
        return service.afficherId(id);
    }

    @GetMapping("/montants")
    public List<BigDecimal> afficherMontant() {
        return service.afficheMontants();
    }


    @GetMapping("/total")
    public BigDecimal total() {
        return service.total();
    }

    @PutMapping("/modifications")
    public void modifications(@RequestBody Payment payment) {
        service.modifications(payment);
    }

    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimerPaiement(id);
    }

    @GetMapping("count")
    public int nbdepaiement() {
        return service.compterPaiements();
    }

    @GetMapping("/exists")
    public Boolean existePaiement(@RequestParam String title, @RequestParam BigDecimal amount) {
        Payment payment = new Payment(title, amount);
        return service.existePaiement(payment);
    }

    @GetMapping("/superieur")
    public List<BigDecimal> superieurA(@RequestParam BigDecimal montant) {
        return service.afficherPaiementsSuperieursA(montant);
    }

    @GetMapping("/inferieur")
    public List<BigDecimal> afficherPaiementsInferieursA(@RequestParam BigDecimal montantInferieur) {
        return service.afficherPaiementsInferieursA(montantInferieur);
    }

    @GetMapping("/max")
    public BigDecimal montantMax() {
        return service.montantMax();
    }

    @GetMapping("/min")
    public BigDecimal min() {
        return service.montantMin();
    }

    @GetMapping("/moyenne")
    public BigDecimal moyenne()
    {
        return service.moyenneMontant();
    }
    @GetMapping("/titre")
    public List<Payment> rechercherParTitre(@RequestParam String titre)
    {
        return service.rechercherParTitre(titre);
    }

}