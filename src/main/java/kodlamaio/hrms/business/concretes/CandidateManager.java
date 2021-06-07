	package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;

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
	public DataResult<Candidate> findCandidateByNationalIdentity(String nationalIdentity) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateByNationalIdentity(nationalIdentity));
	}

}
