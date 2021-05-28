package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	Result add(JobAdvert jobAdvert);
	
	Result changeActive(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAllActiveAdverts();
	
	DataResult<List<JobAdvert>> getAllByOrderByReleaseDate();
}
