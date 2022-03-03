package sg.edu.nus.iss.workshop13.App;

import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;

import static sg.edu.nus.iss.workshop13.App.util.IOUtil;
	
@SpringBootApplication
public class Workshop13TaskApplication {
	private static final Logger logger =
		Logger.getLogger(Workshop13TaskApplication.class.getName());
	private static final String DATA_DIR = "dataDir";

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop13TaskApplication.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List<String> optsval = appArgs.getOptionValues("DATA_DIR");

		if(optsval != null){
			createDir((String)optsval.get(0));
		}else{
			logger.warn("No data directory is provided!");
			System.exit(1);
		}
			
		app.run(args);
		
		SpringApplication.run(Workshop13TaskApplication.class, args);
	}

}
