package com.micmiu.mvc.ferriswheel.examples.web1.demos.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class FormBean {

	private String textVal;

	private String email;

	private String blogUrl;

	private String passwordVal;

	private String radioVal;

	private Date dateVal;

	private String selectStaticVal;

	private String selectRemoteVal;

	private String[] checkBoxVals;

	private String province;

	private String city;

	public String getTextVal() {
		return textVal;
	}

	public String getEmail() {
		return email;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public String getPasswordVal() {
		return passwordVal;
	}

	public String getRadioVal() {
		return radioVal;
	}

	public Date getDateVal() {
		return dateVal;
	}

	public String getSelectStaticVal() {
		return selectStaticVal;
	}

	public String getSelectRemoteVal() {
		return selectRemoteVal;
	}

	public String[] getCheckBoxVals() {
		return checkBoxVals;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public void setTextVal(String textVal) {
		this.textVal = textVal;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	public void setPasswordVal(String passwordVal) {
		this.passwordVal = passwordVal;
	}

	public void setRadioVal(String radioVal) {
		this.radioVal = radioVal;
	}

	public void setDateVal(Date dateVal) {
		this.dateVal = dateVal;
	}

	public void setSelectStaticVal(String selectStaticVal) {
		this.selectStaticVal = selectStaticVal;
	}

	public void setSelectRemoteVal(String selectRemoteVal) {
		this.selectRemoteVal = selectRemoteVal;
	}

	public void setCheckBoxVals(String[] checkBoxVals) {
		this.checkBoxVals = checkBoxVals;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
