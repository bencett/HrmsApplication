package kodlamaio.hrms.entities.concretes;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resumes")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitilazier", "handler" })
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	/*@Column(name = "education_id")
	private int educationId;
	
	@Column(name = "job_experience_id")
	private int jobExperienceId;
	
	@Column(name = "tech_id")
	private int techId;
	
	@Column(name = "language_id")
	private int languageId;
	
	@Column(name = "image_id")
	private int imageId;*/
	
	@Column(name = "github_link")
	private String gitHubLink;
	
	@Column(name = "linkedin_link")
	private String linkedInLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
		
		@OneToMany(mappedBy = "resume")
		private List<Language> languages;
		
		@OneToMany(mappedBy = "resume")
		private List<JobExperience> jobExperiences;
		
		@OneToMany(mappedBy = "resume")
		private List<Education> educations;
		
		@OneToMany(mappedBy = "resume")
		private List<Technology> technologies;
		
		@OneToMany(mappedBy = "resume")
		private List<Image> images;
}
