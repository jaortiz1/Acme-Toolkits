package acme.features.inventor.chimpum;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.entities.inventions.Invention;
import acme.entities.inventions.InventionType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorChimpumCreateService implements AbstractCreateService<Inventor, Chimpum>{

	@Autowired
	protected InventorChimpumRepository repository;
	
	@Override
	public boolean authorise(Request<Chimpum> request) {
		System.out.println("authorise");
	assert request != null;
	System.out.println("authorise2");

		return true;
	}

	@Override
	public void bind(Request<Chimpum> request, Chimpum entity, Errors errors) {
		System.out.println("BIND1");
		assert request != null;
		assert entity != null;
		assert errors != null;
		System.out.println("BIND2");
		request.bind(entity, errors, "code","title", "budget", "startTime", "endTime",  "link", "description");
		
	}

	@Override
	public void unbind(Request<Chimpum> request, Chimpum entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model!=null;
		Collection<Invention> inventios = this.repository.findAllInventionsByType(InventionType.COMPONENT);
		model.setAttribute("inventions", inventios);
		request.unbind(entity, model, "code", "title", "budget", "creationTime", "startTime", "endTime",  "link", "description");

		
	}

	
	@Override
	public Chimpum instantiate(Request<Chimpum> request) {
		assert request != null;
		Chimpum result;
		result = new Chimpum();
		//result.setBudget(new Money());
		result.setCode("");
		result.setCreationTime(new Date());
		result.setDescription("");
		result.setEndTime(new Date());
		result.setInvention(new Invention());
		result.setLink("");
		result.setStartTime(new Date());
		result.setTitle("");
		System.out.println("instantiate2");

		return result;
	}

	@Override
	public void validate(Request<Chimpum> request, Chimpum entity, Errors errors) {
		System.out.println("VALIDATE");
		final String year, month, day;
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		

	}

	@Override
	public void create(Request<Chimpum> request, Chimpum entity) {
		System.out.println("CREATEEEEEE");
		assert request != null;
		assert entity != null;
		System.out.println(entity);
		this.repository.save(entity);
		System.out.println("CREATEEEEEE2");

	}

}
