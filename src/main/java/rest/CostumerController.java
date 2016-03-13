package rest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@SessionAttributes
@RequestMapping(path="/kund")
public class CostumerController {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private CostumerRepository costumers;
	
	
	@RequestMapping(path = "/{kundnummer}", method = RequestMethod.GET)
    public Costumer getCostumerByCostumerNumber(@PathVariable("kundnummer") long kundnummer) {
        log.info("Get costumer by Kundnummer");
        return costumers.getCostumer(kundnummer);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Costumer postCostumer(@ModelAttribute("costumer") Costumer costumer, BindingResult result) {
		long newCostumer = costumers.postCostumer(costumer.getSocialSecurityNumber(), costumer.getFirstName(),
				costumer.getLastName(), costumer.getMobilePhone(), costumer.getPhone(), costumer.getEmail());
		//return costumers.getCostumer(newCostumer);
		return costumers.getCostumer(newCostumer);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<Costumer> getAllCostumers() {
        log.info("Get all costumers");
        return costumers.getCostumers();
    }
	
	@RequestMapping(path = "/{kundnummer}", method = RequestMethod.POST)
    public Costumer updateCostumer(@PathVariable("kundnummer") long kundnummer,
    		@ModelAttribute("costumer") Costumer costumer, BindingResult result) {
		long newCostumer = costumers.updateCostumer(kundnummer, costumer.getSocialSecurityNumber(),
costumer.getFirstName(), costumer.getLastName(), costumer.getMobilePhone(), costumer.getPhone(), costumer.getEmail());
		//return costumers.getCostumer(newCostumer);
		return costumers.getCostumer(newCostumer);
    }

}
