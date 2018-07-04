package com.mobilebox.device.services;

import java.util.Optional;

import com.mobilebox.executor.Service;

/**
 * Simple service to get or set the device name.
 */
public class DeviceName extends Service {

  public DeviceName() {
    setName("idevicename");
  }

  /**
   * Gets the device name.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @return The device name.
   */
  public String getName(final String udid) {
    return exec(udid, Optional.empty());
  }

}
