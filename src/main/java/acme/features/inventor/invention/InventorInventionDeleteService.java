package acme.features.inventor.invention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inventions.Invention;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorInventionDeleteService implements AbstractDeleteService<Inventor, Invention>{
	
	@Autowired
	protected InventorInventionRepository repository;

	@Override
	public boolean authorise(final Request<Invention> request) {
		assert request != null;

		boolean result;
		int inventionId;
		Invention invention;
		Inventor inventor;

		inventionId = request.getModel().getInteger("id");
		invention = this.repository.findOneInventionById(inventionId);
		inventor = invention.getInventor();
		result = invention.getPublished()==false && request.isPrincipal(inventor);

		return result;
	}

	@Override
	public void bind(final Request<Invention> request, final Invention entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "name", "technology", "description", "retailPrice", "link", "inventionType");
	
		
	}

	@Override
	public void unbind(final Request<Invention> request, final Invention entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model!=null;
		request.unbind(entity, model, "code", "name", "technology", "description", "retailPrice", "link", "inventionType");
	
		
	}

	@Override
	public Invention findOne(final Request<Invention> request) {
		assert request != null;
		
		Invention result;
		int id;
		
		id=request.getModel().getInteger("id");
		result=this.repository.findOneInventionById(id);
		
		return result;
	}

	@Override
	public void validate(final Request<Invention> request, final Invention entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Invention> request, final Invention entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
		
	}

}
