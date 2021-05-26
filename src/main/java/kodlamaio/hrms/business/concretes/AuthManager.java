package kodlamaio.hrms.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService{
	
	private EmployerService employerService;
	private CandidateService candidateService;
	private ValidationService validationService;
	private UserService userService;
	
	@Autowired
	public AuthManager(EmployerService employerService, EmployeeService employeeService,
			CandidateService candidateService, ValidationService validationService,UserService userService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.validationService = validationService;
		this.userService = userService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkEmployerMissingInfo(employer)) {
			
			return new ErrorResult("Lütfen tüm alanları doldurunuz!");
		}
		
		if (!checkIfEmailExists(employer.getEmail())) {
			
			return new ErrorResult(employer.getEmail() + "zaten kayıtlı.");
		}
		
		if (!checkIfEqualMailAndWebdomain(employer.getEmail(), employer.getWebAdress())) {
			
			return new ErrorResult("Mail adresi eşleşmiyor.");
		}
		
		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {
			
			return new ErrorResult("Şifreler aynı değil.");
		}
		
		employerService.add(employer);
		return new SuccessResult("İşveren başarıyla kaydedildi.");
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		
		if (checkIfRealPerson(candidate) == false) {
			
			return new ErrorResult("Bu kişi resmi kayıtlarda yok.");
		}
		
		if (!checkIfEmailExists(candidate.getEmail())) {
			
			return new ErrorResult(candidate.getEmail() + "zaten kayıtlı.");
		}
		
		if (!checkCandidateMissingInfo(candidate, confirmPassword)) {
			
			return new ErrorResult("Lütfen tüm alanları doldurunuz!");
		}
		
		if (!checkIfNationalIdExist(candidate.getNationalIdentity())) {
			
			return new ErrorResult(candidate.getNationalIdentity() + "zaten kayıtlı.");
		}
		
		if (!checkIfEqualPasswordAndConfirmPassword(candidate.getPassword(), confirmPassword)) {
			
			return new ErrorResult("Şifreler aynı değil.");
		}
		
		candidateService.add(candidate);
		return new SuccessResult("İş arayan başarıyla eklendi.");
	}

	private boolean checkIfEqualMailAndWebdomain(String email,String website) {
		
		String[] emailAry = email.split("@", 2);
		
		String domain = website.substring(4, website.length());
		
		if (emailAry[1].equals(domain)) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			
			return false;
		}
		
		return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		
		if (this.userService.getUserByEmail(email).getData() == null) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean checkIfRealPerson(Candidate candidate) {
		
		if (validationService.mernisValidate(candidate)) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkIfNationalIdExist(String nationalIdentity) {
		
		if (candidateService.findCandidateByNationalIdentity(nationalIdentity).getData() == null) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkEmployerMissingInfo(Employer employer) {
		
		if (employer.getEmail() != null && employer.getWebAdress() != null && employer.getCompanyName() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkCandidateMissingInfo(Candidate candidate,String confirmPassword) {
		if (candidate.getNationalIdentity() != null && candidate.getFirstName() != null && 
				candidate.getLastName() != null && candidate.getEmail() != null && confirmPassword != null &&
				candidate.getDateOfBirth() != null && candidate.getPassword() != null) {
			
			return true;
		}
		
		return false;
	}
}
