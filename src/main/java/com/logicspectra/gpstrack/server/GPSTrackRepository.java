package com.logicspectra.gpstrack.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.logicspectra.gpstrack.resource.DeviceResource;
import com.logicspectra.gpstrack.resource.LocationResource;
import com.logicspectra.gpstrack.resource.UserResource;

@ApplicationScoped
public class GPSTrackRepository {
	private static final Logger log = Logger.getLogger(GPSTrackRepository.class.getName());

	@PersistenceContext(unitName = "gpstrackPU")
	EntityManager em;

	public DeviceResource getDevice(long deviceId) {
		log.info("Seraching with Id :" + deviceId);
		DeviceEntity entity = em.find(DeviceEntity.class, deviceId);
		if (entity == null) {
			log.info("No device found with Id :" + deviceId);
			return null;
		}
		return entity.toDevice();
	}

	@javax.transaction.Transactional
	public DeviceResource addDevice(DeviceResource device) {
		em.persist(DeviceEntity.toDeviceEntity(device));
		return device;
	}

	public List<DeviceResource> getAllDevices() {
		List<DeviceEntity> deviceEntities = em.createQuery("Select d From DeviceEntity d", DeviceEntity.class)
				.getResultList();
		List<DeviceResource> devices = new ArrayList<DeviceResource>();
		for (DeviceEntity deviceEntity : deviceEntities) {
			devices.add(deviceEntity.toDevice());
		}
		return devices;
	}

	public DeviceResource deleteDevice(long deviceId) {
		return null;
	}

	@javax.transaction.Transactional
	public LocationResource addDeviceLocation(LocationResource deviceLocation) {
		em.persist(LocationEntity.toLocationEntity(deviceLocation));
		return deviceLocation;
	}

	public LocationResource getLocation(long locationId) {
		log.info("Seraching Location with Id :" + locationId);
		LocationEntity entity = em.find(LocationEntity.class, locationId);
		if (entity == null) {
			log.info("No Location found with Id :" + locationId);
			return null;
		}
		return entity.toLocationResource();
	}
	
	public UserResource getUser(String email) {
		log.info("Seraching User with email Id :" + email);
		UserEntity entity = em.find(UserEntity.class, email);
		if (entity == null) {
			log.info("No User found with emailId :" + email);
			return null;
		}
		return entity.toUserResource();
	}

}
