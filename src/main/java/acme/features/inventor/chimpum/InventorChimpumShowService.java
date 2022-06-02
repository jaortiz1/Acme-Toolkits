package acme.features.inventor.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorChimpumShowService implements AbstractShowService<Inventor, Chimpum>{
	// Internal state ---------------------------------------------------------
			@Autowired
			protected InventorChimpumRepository repository;
			
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;
		Chimpum result;
		int chimpumId;
		chimpumId = request.getModel().getInteger("id");
		result = this.repository.findOneChimpumById(chimpumId);
		return result;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String defaultCurrency = this.repository.getSystemConfiguration().getSystemCurrency();
		final Money budget = MoneyExchange.of(entity.getBudget(), defaultCurrency).execute().getTarget();
		model.setAttribute("budget", budget);
		request.unbind(entity, model, "code","title","creationTime","startTime","endTime","link","description", "invention");
	}

}
