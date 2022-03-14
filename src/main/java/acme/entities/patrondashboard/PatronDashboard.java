package acme.entities.patrondashboard;

import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatronDashboard extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	@NotNull @Min(0)
	private Integer numerProposed;
	@NotNull @Min(0)
	private Integer numerAccepted;
	@NotNull @Min(0)
	private Integer numberDenied;
	@NotNull
	private Map<String, Map<Status, Money>> average;
	@NotNull
	private Map<String, Map<Status, Money>> deviation;
	@NotNull
	private Map<String, Map<Status, Money>> minimum;
	@NotNull
	private Map<String, Map<Status, Money>> maximum;


}
