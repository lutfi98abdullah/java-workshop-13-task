package sg.edu.nus.iss.workshop13.App.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.ui.Model;

import sg.edu.nus.iss.workshop13.App.model.Contact;

public class Contacts {

    public void saveContact(Contact contact, Model model, ApplicationArguments appInArgs){
        String dataFileName = contact.getId();
        Set<String> optnames = appInArgs.getOptionNames();
        String [] optnamesArr = optnames.toArray(new String[optnames.size()]);
        Set<String> optNames = appInArgs.getOptionValues(optnamesArr[0]);
        String[] optValuesArr = optValues.toArray(new String[optValues.size()]);
        PrintWriter printWriter = null;
        try{
            FileWriter fileWriter = new FileWriter(optValuesArr[0] + "/" + dataFileName, Charset.forName("UTF-8"));
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(contact.getName());
            printWriter.println(contact.getEmail());
            printWriter.println(contact.getPhoneNumber());
        }catch(IOException e) {
            Logger.log(Level.WARNING,e.getMessage());
        }finally{
            printWriter.close();
            try {
                fileWriter.close();
            }catch(IOException e) {
                Logger.log(Level.WARNING,e.getMessage());
            }    
        }
        model.addAttribute("contact", new Contact(contact.getId(), contact.getName(), contact.getEmail(), contact.getPhoneNumber()));
    }
    public void getContactById(Model model,
        String contactId, ApplicationArguments appInArgs)
    {
        Set<String> optnames = appInArgs.getOptionNames();
        String[] optNamesArr = optnames.toArray(new String[optnames.size()]);
        Set<String> optNames = appInArgs.getOptionValues(optnamesArr[0]);
        String[] optValuesArr = optValues.toArray(new String[optValues.size()]);
        Contact cResp = new Contact();
        try{
            Path filePath = new File(optValuesArr[0] + "/" + contactId).toPath();
            Charset charset = Charset.forName("utf-8");
            List<String> stringListVal = Files.readAllLines(filePath, charset);
            cResp.setName(stringListVal.get(0));
            cResp.setEmail(stringListVal.get(1));
            cResp.setPhoneNumber(stringListVal.get(2));
            cResp.setId()
        }
    }
    
}
