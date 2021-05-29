package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
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
	public Result update(JobAdvert jobAdvert) {
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı güncellendi.");
	}
	
	@Override
	public DataResult<JobAdvert> getById(int id){
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
	}

	//girilen id ile ilanı buluyor ve aktif mi değil mi kontrol ediyor
	//ve duruma göre aktifleştirip pasifleştiebiliyoruz
	//ilerleyen zamanlarda ilan ismi ile de kontrol sağlanabilir
	@Override
	public Result closeAdvert(int id) {
		
		if (getById(id)==null) {
			
			return new ErrorResult("Böyle bir iş ilanı yok.");
		}
		
		if (getById(id).getData().isActive()==false) {
			
			return new ErrorResult("Bu ilan zaten kapalı.");
		}
		
		/*ilan aktiflik field'ını değil setter'ını çağıracaksınız 
		 *(örn. isActive'nin setActive setter'ı)*/
		
		JobAdvert advertToClose = getById(id).getData();
		
		advertToClose.setActive(false);
		
		add(advertToClose);
		
		return new SuccessResult("İş ilanı pasif hale getirildi.");
			
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllActiveAdverts(),"Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByReleaseDate() {

		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByReleaseDate(),"İş ilanları tarihe göre listelendi.");
	}

}
