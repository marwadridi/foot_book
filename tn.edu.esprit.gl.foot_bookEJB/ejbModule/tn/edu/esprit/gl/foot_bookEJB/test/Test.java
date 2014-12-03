package tn.edu.esprit.gl.foot_bookEJB.test;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;
import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.BookingServiceLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.StadiumServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;

@Singleton
@Startup
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserServicesLocal userServicesLocal;

	@EJB
	StadiumServicesLocal stadiumServicesLocal;

	@EJB
	BookingServiceLocal bookingServiceLocal;

	public Test() {
		System.out.println("construit");
	}

	@PostConstruct
	public void init() {
		User user = new User();
		user.setLogin("login");
		user.setPassword("password");
		user.setName("user");

		User user2 = new User();
		user.setLogin("mar");
		user.setPassword("pwd");
		user.setName("marwa");

		Stadium stadium = new Stadium();
		stadium.setLibele("marsa");

		Date dateOfBooking = new Date();

		bookingServiceLocal.bookStadium(user, stadium, dateOfBooking);

	}

}
