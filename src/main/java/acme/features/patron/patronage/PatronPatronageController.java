package acme.features.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronPatronageController extends AbstractController<Patron, Patronage>{
	
	// Internal state ---------------------------------------------------------
	
			@Autowired
			protected PatronPatronageListService	listService;
			
			@Autowired
			protected PatronPatronageShowService			showService;
			
			@Autowired
			protected PatronPatronageCreateService			createService;
			
			@Autowired
			protected PatronPatronageDeleteService			deleteService;
			
			@Autowired
			protected PatronPatronageUpdateService			updateService;
			
			@Autowired
			protected PatronPatronagePublishService			publishService;
			
	// Constructors -----------------------------------------------------------


			@PostConstruct
			protected void initialise() {
				super.addCommand("show", this.showService);
				super.addCommand("list", this.listService);
				super.addCommand("create", this.createService);
				super.addCommand("delete", this.deleteService);
				super.addCommand("update", this.updateService);
				super.addCommand("publish", this.publishService);
				
			}

}
