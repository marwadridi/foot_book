package tn.edu.esprit.gl.foot_bookEJB.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BookingPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private int idStadium;

	public BookingPk() {
	}
	public BookingPk(int idUser, int idStadium) {
		super();
		this.idUser = idUser;
		this.idStadium = idStadium;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdStadium() {
		return idStadium;
	}

	public void setIdStadium(int idStadium) {
		this.idStadium = idStadium;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStadium;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingPk other = (BookingPk) obj;
		if (idStadium != other.idStadium)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	

}
