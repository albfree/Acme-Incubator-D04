
package acme.features.bookkeeper.accountingRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.customizations.Customization;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/customization/")
public class BookkeeperAccountingRecordController extends AbstractController<Administrator, Customization> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private BookkeeperAccountingRecordListService	listService;

	@Autowired
	private BookkeeperAccountingRecordShowService	showService;

	@Autowired
	private AdministratorCustomizationUpdateService	updateService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}