package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class CostumerRepository {
	
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbc;

    public long postCostumer(String socialSecurityNumber, String firstName, String lastName, String mobilePhone, String phone, String email) {
        jdbc.update("INSERT INTO Kund (Personnummer, Fornamn, Efternamn, Mobilnummer, Fastnummer, Mejladress) VALUES (?, ?, ?, ?, ?, ?)", socialSecurityNumber, firstName, lastName, mobilePhone, phone, email);
        return jdbc.queryForObject("SELECT COUNT(*) FROM Kund", Long.class);
    }

    public Costumer getCostumer(long kundnummer) {
        return jdbc.queryForObject("SELECT * FROM Kund WHERE Kundnummer=?", costumerMapper, kundnummer);
    }
    
    public ArrayList<Costumer> getCostumers() {
    	ArrayList<Costumer> result = new ArrayList<>();
    	long max = jdbc.queryForObject("SELECT COUNT(*) FROM Kund", Long.class);
    	for(int n = 1; n <= max; n++) {
    		Costumer costumer = jdbc.queryForObject("SELECT * FROM Kund WHERE Kundnummer=?", costumerMapper, n);
    		result.add(costumer);
    	}
        return result;
    }

    public long updateCostumer(long kundnummer, String socialSecurityNumber, String firstName, String lastName, String mobilePhone, String phone, String email) {
            jdbc.update("UPDATE Kund SET Personnummer = ?, Fornamn = ?, Efternamn = ?, Mobilnummer = ?, Fastnummer = ?, Mejladress = ? WHERE kundnummer = ?", socialSecurityNumber, firstName, lastName, mobilePhone, phone, email, kundnummer);
            return kundnummer;
        }

    
    private static final RowMapper<Costumer> costumerMapper = new RowMapper<Costumer>() {
        public Costumer mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Costumer costumer = new Costumer();
        	costumer.setCostumerNumber(rs.getString("kundnummer"));
        	costumer.setSocialSecurityNumber(rs.getString("personnummer"));
        	costumer.setFirstName(rs.getString("fornamn"));
        	costumer.setLastName(rs.getString("efternamn"));
        	costumer.setMobilePhone(rs.getString("mobilnummer"));
        	costumer.setPhone(rs.getString("fastnummer"));
        	costumer.setEmail(rs.getString("mejladress"));
            return costumer;
        }
    };

}