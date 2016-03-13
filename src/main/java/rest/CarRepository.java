package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class CarRepository {
	
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbc;

    public Car postCar(String regNumber, String manufacturer, String model, int year, String color) {
        jdbc.update("INSERT INTO Bil (Registreringsnummer, Marke, Modell, Argang, Farg) VALUES (?, ?, ?, ?, ?)", regNumber, manufacturer, model, year, color);
        return jdbc.queryForObject("SELECT * FROM Bil WHERE Registreringsnummer=?", carMapper, regNumber);
    }

    public Car getCar(String regNumber) {
        return jdbc.queryForObject("SELECT * FROM Bil WHERE Registreringsnummer=?", carMapper, regNumber);
    }
    
    public ArrayList<Car> getCars() {
    	
    	ArrayList<Car> cars = new ArrayList<>(jdbc.query("SELECT * FROM Bil", carMapper));

        return cars;
    }

    public String updateCar(String oldRegnumber, String regNumber, String manufacturer, String model, int year, String color) {
            jdbc.update("UPDATE Bil SET Registreringsnummer = ?, Marke = ?, Modell = ?, Argang = ?, Farg = ? WHERE Registreringsnummer = ?", regNumber, manufacturer, model, year, color, oldRegnumber);
            return regNumber;
        }

    
    private static final RowMapper<Car> carMapper = new RowMapper<Car>() {
        public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Car car = new Car();
        	car.setRegNumber(rs.getString("Registreringsnummer"));
        	car.setManufacturer(rs.getString("Marke"));
        	car.setModel(rs.getString("Modell"));
        	car.setYear(rs.getInt("Argang"));
        	car.setColor(rs.getString("Farg"));
            return car;
        }
    };
}