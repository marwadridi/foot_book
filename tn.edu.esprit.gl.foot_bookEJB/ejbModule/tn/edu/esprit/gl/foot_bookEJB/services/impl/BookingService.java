package tn.edu.esprit.gl.foot_bookEJB.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl.foot_bookEJB.model.Booking;
import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;
import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.BookingServiceLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.BookingServiceRemote;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.StadiumServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class BookingService
 */

@Stateless
@LocalBean
public class BookingService implements BookingServiceRemote,
		BookingServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private UserServicesLocal userServicesLocal;

	@EJB
	private StadiumServicesLocal stadiumServicesLocal;

	/**
	 * Default constructor.
	 */
	public BookingService() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllBook() {

		String statement = "SELECT b from Booking b";
		return entityManager.createQuery(statement).getResultList();
	}

	@Override
	public boolean bookStadium(User user, Stadium stadium, Date dateOfBooking) {
		entityManager.persist(user);
		entityManager.persist(stadium);
		Booking booking = new Booking(stadium, user, dateOfBooking);
		entityManager.persist(booking);
		return false;
	}

}
