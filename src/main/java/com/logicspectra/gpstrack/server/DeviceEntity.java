package com.logicspectra.gpstrack.server;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicspectra.gpstrack.resource.DeviceResource;


@Entity
@Table(name="device")
public class DeviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "device_id", updatable = false, nullable = false)
	private Long id;

    @Enumerated(EnumType.STRING)
	private DeviceStatus status;
	
	@Column(name = "creation_time", updatable = false, nullable = false)
	private Date creationTime;

	@Column(name = "update_time", updatable = false, nullable = false)
	private Date updateTime;


	private String phone;

	private String model;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public DeviceStatus getStatus() {
		return status;
	}


	public void setStatus(DeviceStatus status) {
		this.status = status;
	}


	public Date getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}



	public DeviceResource toDevice() {
		DeviceResource device = new DeviceResource();
		device.setDeviceId(id);
		device.setLastUpdate(updateTime);
		device.setModel(model);
		device.setPhone(phone);
		device.setStatus(status);
		return device;
	}


	public static DeviceEntity toDeviceEntity(DeviceResource device) {
		DeviceEntity entity = new DeviceEntity();
		entity.setCreationTime(new Date());
		entity.setModel(device.getModel());
		entity.setPhone(device.getPhone());
		entity.setStatus(device.getStatus());;
		return entity;
	}

}
