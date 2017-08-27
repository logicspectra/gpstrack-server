package com.logicspectra.gpstrack.server;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Token")
public class TokenEntity {
	@Id
	protected Long deviceId;

	protected Date tokenDate;
	protected String userId;
	protected Date tokenExpiryDate;
	protected String tokenValue;

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTokenExpiryDate() {
		return tokenExpiryDate;
	}

	public void setTokenExpiryDate(Date tokenExpiryDate) {
		this.tokenExpiryDate = tokenExpiryDate;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

}
