package acme.entities.zolet;

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
import lombok.ToString;
import spam.detector.SpamDetector;

@Entity
@Getter
@Setter
@ToString
public class Zolet extends AbstractEntity{
	
	//“^\w{3}-yymmdd-\w{2}$”
	protected static final long	serialVersionUID	= 1L;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{3}-[0-9]{6}-[a-zA-Z0-9]{2}?$")
	@Column(unique = false)
	protected String			code;

	@NotBlank
	@Length(min = 0, max = 100)
	protected String			theme;

	@NotBlank
	@Length(min = 0, max = 255)
	protected String			statement;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date				creationMoment;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				startTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				endTime;
	@NotNull
	@Valid
	protected Money			helping;

	@URL
	protected String			moreInfo;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "invention_id", referencedColumnName = "id")
	protected Invention invention;

	public boolean isSpam(final SystemConfiguration systemConfiguration) {

		final String text = this.getTheme() + "\n" + this.getStatement();
		return SpamDetector.isSpam(text, systemConfiguration.getWeakSpamTerms(), systemConfiguration.getStrongSpamTerms(), systemConfiguration.getStrongSpamTermsThreshold(), systemConfiguration.getWeakSpamTermsThreshold());

	}

}
