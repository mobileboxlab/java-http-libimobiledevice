package com.mobilebox.device.services;

import java.util.Optional;

import com.mobilebox.executor.Service;

/**
 * Simple service to install, get, or remove provisioning profiles.
 */
public class DeviceProvision extends Service {

  private final String OPTION_LIST = "list";

  public DeviceProvision() {
    setName("ideviceprovision");
  }

  /**
   * Get a list of all provisioning profiles on the device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @return A list of all provisioning profiles on the device.
   */
  public String getProvisioningProfiles(final String udid) {
    return exec(udid, Optional.of(OPTION_LIST));
  }

}
