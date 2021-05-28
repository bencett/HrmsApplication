package kodlamaio.hrms.mernis;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.entities.concretes.Candidate;

public class FakeMernisService implements ValidationService{

	@Override
	public boolean mernisValidate(Candidate candidate) {
		

		if(candidate.getNationalIdentity()=="92222222222" && 
				candidate.getFirstName()=="Denebir" && 
				candidate.getLastName()== "Denebirsoyad" && 
				candidate.getDateOfBirth().getYear()==1962) {
			
			return true;
		}
		
		return false;
	}
	
}
