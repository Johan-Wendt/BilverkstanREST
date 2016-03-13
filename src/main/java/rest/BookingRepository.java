package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

@Repository
public class BookingRepository {
	
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbc;

    public long postBooking(int costumerId, String carRegistrationId, Date dateSubmissed, Timestamp dateDoneEst,
    		Timestamp dateDoneAct, Timestamp datePickedUp, Date datePaid, int mechanic, int estimatePrice, int paidPrice,
    		Timestamp dateRepairEst, Timestamp dateRepairAct) {
        jdbc.update("INSERT INTO Bokning (Kund, Bil, DatumInlamning, DatumReparationBeraknad, DatumReparationFaktisk,"
        		+ " DatumFardigBeraknad, DatumFardigFaktisk, DatumHamtad, DatumBetald, Reparator, Offertpris,"
        		+ " BetaltBelopp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", costumerId, carRegistrationId,
        		dateSubmissed, dateDoneEst, dateDoneAct, datePickedUp, datePaid, dateRepairEst, dateRepairAct,
        		mechanic, estimatePrice, paidPrice);
        return jdbc.queryForObject("SELECT COUNT(*) FROM Bokning", Long.class);
    }

    public Booking getBooking(long submissionId) {
        return jdbc.queryForObject("SELECT * FROM Bokning WHERE Inlamningsnummer=?", bookingMapper, submissionId);
    }
    
    public ArrayList<Booking> getBookings() {
    	
    	ArrayList<Booking> bookings = new ArrayList<>(jdbc.query("SELECT * FROM Bokning", bookingMapper));

        return bookings;
    }

    public long updateBooking(long submissionId, int costumerId, String carRegistrationId,
    		Date dateSubmissed, Timestamp dateDoneEst, Timestamp dateDoneAct, Timestamp datePickedUp, Date datePaid,
    		int mechanic, int estimatePrice, int paidPrice, Timestamp dateRepairEst, Timestamp dateRepairAct) {
            jdbc.update("UPDATE Bokning SET Kund = ?, Bil = ?, DatumInlamning = ?, DatumReparationBeraknad = ?,"
            		+ " DatumReparationFaktisk = ?, DatumHamtad = ?, DatumBetald = ?, DatumFardigBeraknad = ?,"
            		+ " DatumFardigFaktisk = ?, Reparator = ?,"
            		+ " Offertpris = ?, BetaltBelopp = ? WHERE Inlamningsnummer = ?",
            		costumerId, carRegistrationId, dateSubmissed, dateDoneEst, dateDoneAct, datePickedUp,
            		datePaid, dateRepairEst, dateRepairAct, mechanic, estimatePrice, paidPrice, submissionId);
            return submissionId;
        }

    
    private static final RowMapper<Booking> bookingMapper = new RowMapper<Booking>() {
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Booking booking = new Booking();
        	booking.setSubmissionId(rs.getInt("Inlamningsnummer"));
        	booking.setCostumerId(rs.getInt("Kund"));
        	booking.setCarRegistrationId(rs.getString("Bil"));
        	booking.setDateSubmissed(rs.getDate("DatumInlamning") );
        	booking.setDateDoneEst(rs.getTimestamp("DatumFardigBeraknad"));
        	booking.setDateDoneAct(rs.getTimestamp("DatumFardigFaktisk"));
        	booking.setDatePickedUp(rs.getTimestamp("DatumHamtad"));
        	booking.setDatePaid(rs.getDate("DatumBetald"));
        	booking.setMechanic(rs.getInt("Reparator"));
        	booking.setEstimatePrice(rs.getInt("Offertpris"));
        	booking.setPaidPrice(rs.getInt("Betaltbelopp"));
        	booking.setDateRepairEst(rs.getTimestamp("DatumReparationBeraknad"));
        	booking.setDateRepairAct(rs.getTimestamp("DatumReparationFaktisk"));
        	
            return booking;
        }
    };
}