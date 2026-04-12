package com.emi.paymenttracker.service;
import com.emi.paymenttracker.entity.Payment;
import com.emi.paymenttracker.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

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


    // méthode qui vérifie si le titre est à null ou non si oui message d'erreur

    public void validateTitle(Payment payment)
    {
        if (payment.getTitle() == null);
        {
            throw new IllegalArgumentException(" n est pas rempli");
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
}
