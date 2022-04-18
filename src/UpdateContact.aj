import java.io.BufferedWriter;
import java.io.FileWriter;

public aspect UpdateContact {
	pointcut updateContact(String name, Address address): call(void updateContact(String, Address)) && args(name, address);  
	
	before (String name, Address address): updateContact(name, address) {
		try {
			FileWriter writer = new FileWriter("log.txt", true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write("Record Updated: " + name + " " + address);
			bWriter.newLine();
			bWriter.close();
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

}
