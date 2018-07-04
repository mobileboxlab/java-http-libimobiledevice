package com.mobilebox.device.services;

import java.util.ArrayList;
import java.util.Arrays;

import com.mobilebox.executor.Service;
import com.mobilebox.model.Serial;

/**
 * Service that gets the device name or a list of attached devices.
 */
public class DeviceId extends Service {

  private final String OPTION_LIST = "-l";

  public DeviceId() {
    setName("idevice_id");
  }

  /**
   * Gets the UDID of all attached devices. The UDID is a 40-digit hexadecimal number of the device
   * for which the name should be retrieved.
   * 
   * @return the UDID of all attached devices.
   */
  public ArrayList<Serial> getSerial() {
    String result = exec(new String[] {"-u", OPTION_LIST});
    ArrayList<Serial> devices = new ArrayList<Serial>();
    Arrays.stream(result.split("\\r?\\n")).forEach(id -> devices.add(new Serial(id)));
    return devices;
  }
  
}
