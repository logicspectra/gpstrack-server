package com.logicspectra.gpstrack.server;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicspectra.gpstrack.resource.LocationResource;

@Entity
@Table(name = "location")
public class LocationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private long deviceId;
	private double longitude;
	private double latitude;
	private double altitude;
	private Date creationTime;
	private Date deviceTime;

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getDeviceTime() {
		return deviceTime;
	}

	public void setDeviceTime(Date deviceTime) {
		this.deviceTime = deviceTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public static LocationEntity toLocationEntity(LocationResource locResource) {
		LocationEntity locEntity = new LocationEntity();
		locEntity.setCreationTime(new Date());
		locEntity.setAltitude(locResource.getAltitude());
		locEntity.setLongitude(locResource.getLongitude());
		locEntity.setLatitude(locResource.getLatitude());
		locEntity.setDeviceId(locResource.getDeviceId());
		locEntity.setDeviceTime(locResource.getDeviceTime());
		return locEntity;
	}

	public LocationResource toLocationResource() {
		LocationResource resource = new LocationResource();
		resource.setLatitude(latitude);
		resource.setLongitude(longitude);
		resource.setDeviceId(deviceId);
		resource.setDeviceTime(deviceTime);
		resource.setCreationTime(creationTime);
		return resource;
	}

}
