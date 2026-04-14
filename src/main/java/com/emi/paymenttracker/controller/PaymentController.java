package com.emi.paymenttracker.controller;


import org.springframework.web.bind.annotation.*;
import com.emi.paymenttracker.service.PaymentService;
import com.emi.paymenttracker.entity.Payment;


@RestController
@RequestMapping("Payment")
public class PaymentController {

    private PaymentService service;

    public PaymentController(PaymentService service)
    {
        this.service = service;
    }

    @PostMapping
    public void ajouterPayment(@RequestBody Payment payment)
    {
        service.ajouterPayment(payment);
    }




}




/*🟦 @PathVariable

👉 “Je prends une info dans l’URL”

        💡 Exemple :

        /payments/3

        👉 ici :

        3 = l’id
tu le récupères avec @PathVariable

🧠 Image :

        “Je lis le numéro écrit dans l’adresse”

        🟨 @RequestParam

👉 “Je prends une petite info dans l’URL après un ?”

        💡 Exemple :

        /payments?title=Courses

👉 ici :

title=Courses = paramètre

🧠 Image :

        “Je lis un petit message ajouté à l’adresse”

        🟩 @RequestBody

👉 “Je prends un objet complet envoyé dans la requête”

        💡 Exemple :

        {
        "title": "Courses",
        "amount": 50
        }

        👉 ça devient un objet Payment

🧠 Image :

        “On m’envoie un paquet avec plusieurs infos dedans”

        🎯 Résumé ultra simple
@PathVariable → 📍 dans l’URL
@RequestParam → ❓ après le ?
@RequestBody → 📦 objet complet (JSON)*/