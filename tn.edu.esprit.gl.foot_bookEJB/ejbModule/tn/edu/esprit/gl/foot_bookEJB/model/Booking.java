package tn.edu.esprit.gl.foot_bookEJB.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Stadium stadium;
	private User user;
	private Date date;
	private String nom;
	private BookingPk bookingPk;

	public Booking() {
		
	}

	public Booking(Stadium stadium, User user, Date date) {
		this.stadium = stadium;
		this.user = user;
		this.date = date;

		this.bookingPk = new BookingPk(user.getId(), stadium.getId());
	}

	

	@EmbeddedId
	public BookingPk getBookingPk() {
		return bookingPk;
	}
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idStadium", referencedColumnName = "id", updatable = false, insertable = false)
	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBookingPk(BookingPk bookingPk) {
		this.bookingPk = bookingPk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
