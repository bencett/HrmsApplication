package kodlamaio.hrms.core.utilities.adapters;

import java.time.LocalDate;

public interface ValidationService {
	
	boolean mernisValidate(String nationalIdentity,String firstName, String lastName, LocalDate dateOfBirth);
}
