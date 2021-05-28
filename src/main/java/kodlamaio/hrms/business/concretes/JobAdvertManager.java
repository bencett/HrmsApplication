package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi.");
		
	}

	@Override
	public Result changeActive(JobAdvert jobAdvert) {

		this.changeActive(jobAdvert);
		return new SuccessResult("İş ilanı aktivitesi değiştirildi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllActiveAdverts(),"Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByOrderByReleaseDate() {

		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByOrderByReleaseDate(),"İş ilanları tarihe göre listelendi.");
	}

}
