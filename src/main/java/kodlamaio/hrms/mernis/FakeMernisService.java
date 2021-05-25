package kodlamaio.hrms.mernis;
import java.time.LocalDate;

public class FakeMernisService {
	
	public boolean checkIfRealPerson(String nationalIdentity,String firstName, 
			                         String lastName,LocalDate dateOfBirth) {
		
		System.out.println(firstName + " " + lastName + "is real person.");
		return true;
	}
}
