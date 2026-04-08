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

    // supprimer un titre ou un montant
}
