package com.mobilebox.device.services;

import java.util.Optional;

import com.mobilebox.executor.Service;

/**
 * Simple service to get and set the clock on a device.
 */
public class DeviceDate extends Service {

  public DeviceDate() {
    setName("idevicedate");
  }

  /**
   * Gets the current date.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @return The device current date.
   */
  public String getDate(final String udid) {
    return exec(udid, Optional.empty());
  }

}
