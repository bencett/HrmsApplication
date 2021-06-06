package kodlamaio.hrms.core.services;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService{

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager() {
		super();
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "bencet", 
				"api_key", "971185531595988",
				"api_secret", "MohSjeXz0IAhptpNPLFXQk5upt0"));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> uploadImage(MultipartFile imageUrl) {

		try {
				
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageUrl.getBytes(), 
						ObjectUtils.emptyMap());
				
				return new SuccessDataResult<Map>(resultMap);
		} 
		
		catch (IOException e) {

			e.printStackTrace();
		}
		
		return new ErrorDataResult<Map>();
	}

}
