package br.com.esub.users.poc.google.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
{
 "id": "114723289600764785818",
 "email": "esuscribers@gmail.com",
 "verified_email": true,
 "name": "esubscribers esub",
 "given_name": "esubscribers",
 "family_name": "esub",
 "link": "https://plus.google.com/114723289600764785818",
 "gender": "male",
 "birthday": "0000-01-12",
 "locale": "pt-BR"
}
 */
@XmlRootElement
public class UserInfo {
	
	private String id;
	private String email;
	private String verified_email;
	private String name;
	private String given_name;
	private String family_name;
	private String link;
	private String gender;
	private String birthday;
	private String locale;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerified_email() {
		return verified_email;
	}
	public void setVerified_email(String verified_email) {
		this.verified_email = verified_email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", email=" + email + ", verified_email="
				+ verified_email + ", name=" + name + ", given_name="
				+ given_name + ", family_name=" + family_name + ", link="
				+ link + ", gender=" + gender + ", birthday=" + birthday
				+ ", locale=" + locale + "]";
	}
}
