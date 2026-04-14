package com.emi.paymenttracker.service;
import com.emi.paymenttracker.entity.Payment;
import com.emi.paymenttracker.repository.PaymentRepository;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;

// Composant de service permet à spring de reconnaitre la classe et de la créer en mémoire et l'injecter où c'est nécessaire
@Service

// Class PaymentService logique métier validation calcul

public class PaymentService {

    // interaction avec la base de donnée spring injecte pour utiliser les opérations sur les entités

    private final PaymentRepository paymentRepository;

    public PaymentService (PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }


    // Ajouter un payement

    public Payment ajouterPayment(Payment payment)
    {
        validateTitle(payment);
        validateAmount(payment);
        return paymentRepository.save(payment);
    }


    // méthode validation montant si il est null ou plus bas que 0 message d'erreur

    public void validateAmount(Payment payment)
    {
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO)<=0)
        {
            throw new IllegalArgumentException("le montant ne peut pas être négatif ou inférieur à 0");
        }
        else
        {
            System.out.println("correct");
        }
    }


    // méthode qui renvoie les valeurs

    public List<Payment> affichevaleur()
    {
        return paymentRepository.findAll();
    }


    // méthode qui affiche les paiements via l'id

    public Payment afficherId(Long id)
    {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isPresent())
        {
            return payment.get();
        }
        else
        {
            throw new IllegalArgumentException("Paiement introuvable");
        }
    }


    //méthode qui renvoie que le titre

    public List<String> afficheTitres()
    {
        List<Payment> payments = paymentRepository.findAll();
        List<String> titres = new ArrayList<>();

        for(Payment payment : payments)
        {
            titres.add(payment.getTitle());

        }
        return titres;
    }


    // méthode qui renvoie mes montants

    public List<BigDecimal> afficheMontants()
    {
        List<Payment> payments = paymentRepository.findAll();
        List<BigDecimal> montants = new ArrayList<>();

        for(Payment payment : payments )
        {
            montants.add(payment.getAmount());
        }
        return montants;
    }


    // méthode qui vérifie si le titre est à null ou non si oui message d'erreur

    public void validateTitle(Payment payment)
    {
        if (payment.getTitle() == null)
        {
            throw new IllegalArgumentException("Pas de titre");
        }
    }


// renvoie le total de toutes les sommes de dépense

    public BigDecimal total()
    {
        BigDecimal total = BigDecimal.ZERO;

        List<Payment> payments = paymentRepository.findAll();
        for(Payment paye : payments )
        {
            total = total.add(paye.getAmount());
        }
        return total;
    }


    // modifier titres et des montants

    public void modifications(Payment paiement) {
        if (paymentRepository.existsById(paiement.getId())) {

            Payment paiementExistant = paymentRepository.findById(paiement.getId()).get();

            if (paiement.getAmount() != null) {
                paiementExistant.setAmount(paiement.getAmount());
            }

            if (paiement.getTitle() != null && !paiement.getTitle().trim().isEmpty()) {
                paiementExistant.setTitle(paiement.getTitle());
            }

            paymentRepository.save(paiementExistant);
        } else {
            throw new IllegalArgumentException("Paiement introuvable");
        }
    }

    // supprimer un titre et un montant via l'id

    public void supprimerPaiement(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Paiement introuvable");
        }
    }


    //méthode qui compte les paiements

    public int compterPaiements()
    {
        int nombre = 0;
        for(int i=0;i<paymentRepository.findAll().size();i++)
        {
            nombre = nombre+1;
        }
        return nombre;
    }


    // meilleure façon de le faire

    public long compterPaiements2() {
        return paymentRepository.count();
    }

    public Boolean existePaiement(Payment payment)
    {
        if(paymentRepository.existsByTitleAndAmount(payment.getTitle(), payment.getAmount()))
        {
            throw new IllegalArgumentException("un paiement avec ce titre et montant existe deja");
        }
        else
        {
            return true;
        }
    }

    public List<BigDecimal> afficherPaiementsSuperieursA(BigDecimal amount)
    {
        List<Payment> payments = paymentRepository.findByAmountGreaterThan(amount);
        List<BigDecimal> superieur = new ArrayList<>();
        for(Payment number : payments)
        {
            superieur.add( number.getAmount());
        }
        return superieur;

    }

    // retrouver paiements inférieur à un nombre

    public List<BigDecimal> afficherPaiementsInferieursA(BigDecimal amount)
    {
        List<Payment> payments = paymentRepository.findByAmountLessThan(amount);
        List<BigDecimal> inferieur = new ArrayList<>();

        for(Payment lownumber : payments)
        {
            inferieur.add(lownumber.getAmount());
        }
        return inferieur;
    }

    public BigDecimal montantMax()
    {
        return paymentRepository.findMaxAmount();
    }
    public BigDecimal montantMin()
    {
        return paymentRepository.findMinAmount();
    }

    public BigDecimal moyenneMontant()
    {
        return paymentRepository.findAvgAmount();
    }

}

/*
compterPaiements
existePaiement
afficherPaiementsSuperieursA
afficherPaiementsInferieursA
Méthodes avec logique un peu plus poussée
montantMax
montantMin
moyenneMontants

Méthodes de recherche
rechercherParTitre
rechercherParTitreExact
rechercherTitresContenant
Méthodes “analyse”
compterTitresVides
compterPaiementsSuperieursA
compterPaiementsInferieursA
*/