package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resumes")
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "education_id")
	private int educationId;
	
	@Column(name = "job_experience_id")
	private int jobExperienceId;
	
	@Column(name = "github_link")
	private String gitHubLink;
	
	@Column(name = "linkedin_link")
	private String linkedInLink;
	
	@Column(name = "tech_id")
	private int techId;
	
	@Column(name = "language_id")
	private int languageId;
	
	@Column(name = "image_id")
	private int imageId;
	
	@Column(name = "cover_letter")
	private String coverLetter;
}
