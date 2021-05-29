package kodlamaio.hrms.api.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobAdvertService.update(jobAdvert);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id) {
		
		return this.jobAdvertService.getById(id);
	}
	
	@PostMapping("/closeAdvert")
	public Result closeAdvert(@RequestParam int id) {
		
		return this.jobAdvertService.closeAdvert(id);
	}
	
	@GetMapping("/getAllActiveAdverts")
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		
		return this.jobAdvertService.getAllActiveAdverts();
	}
	
	@GetMapping("/getAllByReleaseDate")
	public DataResult<List<JobAdvert>> getAllByReleaseDate() {
		
		return this.jobAdvertService.getAllByReleaseDate();
	}
	
}
