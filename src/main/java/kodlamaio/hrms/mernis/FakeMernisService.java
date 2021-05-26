package kodlamaio.hrms.mernis;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.entities.concretes.Candidate;

public class FakeMernisService implements ValidationService{

	@Override
	public boolean mernisValidate(Candidate candidate) {
		if (candidate.getNationalIdentity()=="27215594094" && candidate.getFirstName()=="Çetin" && 
				candidate.getLastName()== "Ürün" && candidate.getDateOfBirth().getYear()==1999) {
			return true;
		}
		return false;
	}
	
	
}
