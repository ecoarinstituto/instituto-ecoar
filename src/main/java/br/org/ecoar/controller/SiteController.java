package br.org.ecoar.controller;

import br.org.ecoar.service.ContactMailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SiteController {

    private final ContactMailService mailService;

    public SiteController(ContactMailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/atividades")
    public String atividades() {
        return "atividades";
    }

    @GetMapping("/doacoes")
    public String doacoes(Model model) {
        model.addAttribute("donationCheckoutUrl",
                System.getenv().getOrDefault("DONATION_CHECKOUT_URL", "https://pay.sumup.com/b2c/Q3PGBIAK"));
        return "doacoes";
    }

    @GetMapping("/contato")
    public String contato(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contato";
    }

    @PostMapping("/contato")
    public String enviarContato(
            @Valid @ModelAttribute("contactForm") ContactForm form,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "contato";
        }

        try {
            mailService.send(form);
            model.addAttribute("sucesso", "Mensagem enviada com sucesso. Obrigado pelo contato!");
            model.addAttribute("contactForm", new ContactForm());
        } catch (Exception ex) {
            model.addAttribute("erro",
                    "Não foi possível enviar a mensagem agora. Tente novamente mais tarde.");
        }

        return "contato";
    }
}
