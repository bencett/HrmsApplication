package kodlamaio.hrms.core.utilities.adapters;
import java.time.LocalDate;
import kodlamaio.hrms.mernis.FakeMernisService;

public class MernisServiceAdapter implements ValidationService{

	@Override
	public boolean mernisValidate(String nationalIdentity, String firstName, String lastName, LocalDate dateOfBirth) {

		FakeMernisService person = new FakeMernisService();
		
		boolean result = true;
		try {
				result = person.checkIfRealPerson(nationalIdentity, firstName, lastName, dateOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	

}
