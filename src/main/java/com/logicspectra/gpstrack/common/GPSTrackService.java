package com.logicspectra.gpstrack.common;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.logicspectra.gpstrack.resource.DeviceResource;
import com.logicspectra.gpstrack.resource.LocationResource;
import com.logicspectra.gpstrack.server.DeviceStatus;
import com.logicspectra.gpstrack.server.GPSTrackRepository;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class GPSTrackService {

	private static final Logger log = Logger.getLogger(GPSTrackService.class.getName());

	@Inject
	private GPSTrackRepository repository;

	@GET
	@Path("/devices/{id}")
	public DeviceResource getDevice(final @PathParam("id") long deviceId) {
		log.info("Device id :" + deviceId);
		return repository.getDevice(deviceId);
	}

	@GET
	@Path("/devices")
	public List<DeviceResource> getDevices() {
		return repository.getAllDevices();
	}

	@POST
	@Path("/devices")
	public DeviceResource addDevice(DeviceResource device) {
		log.info("Device id :" + device);
		return repository.addDevice(device);
	}

	@PUT
	@Path("/devices")
	@Produces("application/json")
	public DeviceResource updateDevice(DeviceResource device) {
		log.info("Device id :" + device);
		return repository.addDevice(device);
	}

	@DELETE
	@Path("/devices")
	public DeviceResource deletDevice(@PathParam("id") long deviceId) {
		log.info("Device id :" + deviceId);
		return repository.deleteDevice(deviceId);
	}
	
	@GET
	@Path("/locations/{id}")
	public LocationResource getLocation(final @PathParam("id") long locationId) {
		log.info("Location id :" + locationId);
		return repository.getLocation(locationId);
	}

	@POST
	@Path("/locations")
	public LocationResource addDeviceLocation(LocationResource deviceLocation) {
		log.info("Device Location :" + deviceLocation);
		return repository.addDeviceLocation(deviceLocation);
	}

	@GET
	@Path("/addtestdevice")
	@Produces("application/json")
	public void addTestDevice() {
		DeviceResource device = new DeviceResource();
		device.setModel("RTDTRR");
		device.setPhone("2345678923");
		device.setStatus(DeviceStatus.ONLINE);
		repository.addDevice(device);

	}

	@GET
	@Path("/addtestlocation")
	@Produces("application/json")
	public void addTestLocation() {
		LocationResource location = new LocationResource();
		location.setLatitude(17.366100);
		location.setLongitude(78.420097);
		location.setDeviceId(865067020873264L);
		location.setDeviceTime(new Date());
		repository.addDeviceLocation(location);

	}

}