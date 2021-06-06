package kodlamaio.hrms.business.concretes;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.services.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>
		(this.imageDao.findAll(),"Fotoğraflar listelendi.");
	}

	@Override
	public Result add(Image image, MultipartFile imageUrl) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploadPhoto = this.cloudinaryService.uploadImage(imageUrl).getData();
		image.setUrl(uploadPhoto.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf eklendi.");
	}

}
