package com.mobilebox.device.services;

import java.util.Optional;

import com.mobilebox.executor.Service;

/**
 * Gets a screenshot from a device.
 */
public class DeviceScreenshot extends Service {

  public DeviceScreenshot() {
    setName("idevicescreenshot");
  }

  /**
   * Gets the device name.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @return The device name.
   */
  public String getScreenshot(final String udid) {
    return exec(udid, Optional.empty());
  }

}
