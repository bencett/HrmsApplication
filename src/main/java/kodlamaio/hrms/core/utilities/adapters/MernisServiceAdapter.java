package kodlamaio.hrms.core.utilities.adapters;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService{

	FakeMernisService FakeMernisService = new FakeMernisService();
	
	@Override
	public boolean mernisValidate(Candidate candidate) {
		
		FakeMernisService client = new FakeMernisService();
		
		if (client.mernisValidate(candidate)) {
			
			return true;
		}
		
		return false;
		
	}	

}
