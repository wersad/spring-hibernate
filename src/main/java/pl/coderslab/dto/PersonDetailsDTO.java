package pl.coderslab.dto;

import java.util.Arrays;

public class PersonDetailsDTO {

	private String login;

	private String password;

	private String email;

	private String firstName;

	private String lastName;

	private String notes;

	private boolean receiveMessages;

	private String sex;

	private String country;

	private String[] languages;

	private String[] hobbies;

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getLanguages() {
		return this.languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String[] getHobbies() {
		return this.hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isReceiveMessages() {
		return this.receiveMessages;
	}

	public void setReceiveMessages(boolean receiveMessages) {
		this.receiveMessages = receiveMessages;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "PersonDetailsDTO [login=" + login + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", notes=" + notes + ", receiveMessages=" + receiveMessages
				+ ", sex=" + sex + ", country=" + country + ", languages=" + Arrays.toString(languages) + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
}
