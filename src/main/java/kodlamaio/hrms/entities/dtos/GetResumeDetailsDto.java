package kodlamaio.hrms.entities.dtos;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetResumeDetailsDto {

	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private List<Image> images;
	private String coverLetter;
	private List<Education> educations;
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private List<Technology> technologies;
	private String githubLink;
	private String linkedinLink;
}
