package acme.entities.chimpum;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.inventions.Invention;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import spam.detector.SpamDetector;

@Entity
@Getter
@Setter
public class Chimpum extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;
	@NotBlank
	@Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
	@Column(unique = true)
	protected String			code;

	@NotBlank
	@Length(min = 0, max = 100)
	protected String			title;

	@NotBlank
	@Length(min = 0, max = 255)
	protected String			description;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date				creationTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				startTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				endTime;
	@NotNull
	@Valid
	protected Money			budged;

	@URL
	protected String			link;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "invention_id", referencedColumnName = "id")
	protected Invention invention;

	public boolean isSpam(final SystemConfiguration systemConfiguration) {

		final String text = this.getTitle() + "\n" + this.getDescription();
		return SpamDetector.isSpam(text, systemConfiguration.getWeakSpamTerms(), systemConfiguration.getStrongSpamTerms(), systemConfiguration.getStrongSpamTermsThreshold(), systemConfiguration.getWeakSpamTermsThreshold());

	}
}