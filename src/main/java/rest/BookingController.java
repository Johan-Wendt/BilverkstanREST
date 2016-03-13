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
@RequestMapping(path="/booking")
public class BookingController {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private BookingRepository bookings;
	
	
	@RequestMapping(path = "/{submissionId}", method = RequestMethod.GET)
    public Booking getBookingByBookingNumber(@PathVariable("submissionId") long submissionId) {
        log.info("Get booking by submissionId");
        return bookings.getBooking(submissionId);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Booking postBooking(@ModelAttribute("booking") Booking booking, BindingResult result) {
		long newBooking = bookings.postBooking(booking.getCostumerId(), booking.getCarRegistrationId(),
				booking.getDateSubmissed(), booking.getDateDoneEst(), booking.getDateDoneAct(),
				booking.getDatePickedUp(), booking.getDatePaid(), booking.getMechanic(), booking.getEstimatePrice(),
				booking.getPaidPrice(), booking.getDateRepairEst(), booking.getDateRepairAct());
		return bookings.getBooking(newBooking);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<Booking> getAllBookings() {
        log.info("Get all bookings");
        return bookings.getBookings();
    }
	
	@RequestMapping(path = "/{SubmissionId}", method = RequestMethod.POST)
    public Booking updateBooking(@PathVariable("SubmissionId") long SubmissionId,
    		@ModelAttribute("booking") Booking booking, BindingResult result) {
		long newBooking = bookings.updateBooking(SubmissionId, booking.getCostumerId(),
				booking.getCarRegistrationId(), booking.getDateSubmissed(), booking.getDateDoneEst(),
				booking.getDateDoneAct(), booking.getDatePickedUp(), booking.getDatePaid(),
				booking.getMechanic(), booking.getEstimatePrice(), booking.getPaidPrice(),
				booking.getDateRepairEst(), booking.getDateRepairAct());
		return bookings.getBooking(newBooking);
    }

}