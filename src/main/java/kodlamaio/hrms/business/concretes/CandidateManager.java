package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.EmailValidator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.FakeMernisService;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private FakeMernisService fakeMernisService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeMernisService fakeMernisService, CandidateService candidateService) {
		super();
		this.candidateDao = candidateDao;
		this.fakeMernisService = fakeMernisService;

	}
	
	@Override
	public DataResult<List<Candidate>>  getAll() {

		return new SuccessDataResult<List<Candidate>>
		(candidateDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan kişi eklendi.");
	}

	@Override
	public Result register(Candidate candidate) {
		if (!EmailValidator.emailFormatController(candidate.getEmail())) {
			return new ErrorResult("Email formata uygun değil. Lütfen kontrol ederek tekrar deneyiniz.");
		}
		//else if (!fakeMernisService.checkIfRealPerson(candidate.getNationalIdentity(), candidate.getFirstName(), 
		//		candidate.getLastName(), candidate.getDateOfBirth())) {
		//	return new ErrorResult("Kullanıcı bilgileri mernis ile eşleşmedi.");
		//}
		this.add(candidate);
		return new SuccessResult("İş arayan kişi kaydedildi.");
	}
	
	public boolean checkIfEmailExists(Candidate candidate, String email) {
		if (candidate.getEmail() == email) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<Candidate> getCandidateByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getCandidateByEmail(email));
	}

}
