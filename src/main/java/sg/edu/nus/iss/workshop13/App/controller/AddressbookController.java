package sg.edu.nus.iss.workshop13.App.controller;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sg.edu.nus.iss.workshop13.App.model.Contact;


@Controller
public class AddressbookController {
    private Logger logger = Logger.getLogger(AddressbookController.class.getName());

    @Autowired
    private ApplicationArguments appInArgs;

    @GetMapping("/")
    public String contactForm(Model model){
        Logger.getLogger(Level.INFO, "Show the contact form");
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String contactsSubmit(@ModelAttribute Contact contact, Model model){
        Logger.log(Level.INFO, "Id : " +contact.getId());
        Logger.log(Level.INFO, "Name : " +contact.getName());
        Logger.log(Level.INFO, "Email : " +contact.getEmail());
        Logger.log(Level.INFO, "Phone : " +contact.getPhoneNumber());
        Contacts ct = new Contacts();

       
        return "showContact";
        
    }
}
