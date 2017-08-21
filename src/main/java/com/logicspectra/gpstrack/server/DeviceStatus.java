package com.logicspectra.gpstrack.server;

public enum DeviceStatus {

	UNKNOWN("unkown"), ONLINE("online"), OFFLINE("offline");

	private final String status;

	DeviceStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
