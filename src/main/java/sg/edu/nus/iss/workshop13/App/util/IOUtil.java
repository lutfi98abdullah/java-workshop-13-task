package sg.edu.nus.iss.workshop13.App.util;

import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.logging.Level;
import java.util.Set;

public class IOUtil {
    private static final Logger logger 
        = Logger.getLogger(IOUtil.class.getName());

    public static void createDir(String path){
        logger.log(Level.INFO, "create directory");
        File dir = new File(path);
        dir.mkdir();
        String osName = System.getProperty("os.name");
        
        //for mac and linux only
        if(!osName.contains("Windows")){
            try{
                String perm = "rwxrwx---";
                Set<PosixFilePermission> permission =
                    PosixFilePermissions.fromString(perm);
                Files.setPosixFilePermissions(dir.toPath(), permission);    

            }catch(IOException e){
                logger.log(Level.SEVERE, "Error creating directory!");
            }
        }
        
    }
}
