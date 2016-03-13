package rest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@SessionAttributes
@RequestMapping(path="/car")
public class CarController {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private CarRepository cars;
	
	
	@RequestMapping(path = "/{regNumber}", method = RequestMethod.GET)
    public Car getCostumerByCostumerNumber(@PathVariable("regNumber") String regNumber) {
        log.info("Get car by regNumber");
        return cars.getCar(regNumber);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Car postCar(@ModelAttribute("car") Car car, BindingResult result) {
		Car newCar = cars.postCar(car.getRegNumber(), car.getManufacturer(), car.getModel(), car.getYear(), car.getColor());
		return newCar;
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<Car> getAllCars() {
        log.info("Get all cars");
        return cars.getCars();
    }
	
	@RequestMapping(path = "/{oldRegNumber}", method = RequestMethod.POST)
    public Car updateCostumer(@PathVariable("oldRegNumber") String oldRegNumber, @ModelAttribute("car") Car car, BindingResult result) {
		String newCar = cars.updateCar(oldRegNumber, car.getRegNumber(), car.getManufacturer(), car.getModel(), car.getYear(), car.getColor());
		return cars.getCar(newCar);
    }

}