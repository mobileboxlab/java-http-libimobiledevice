package com.mobilebox.service;

import java.util.ArrayList;
import static com.mobilebox.service.DeviceState.AVAILABLE;
import com.mobilebox.device.services.DeviceDiagnostics;
import com.mobilebox.device.services.DeviceId;
import com.mobilebox.device.services.DeviceInfo;
import com.mobilebox.exception.InternalException;
import com.mobilebox.model.Battery;
import com.mobilebox.model.CPUArchitecture;
import com.mobilebox.model.Device;
import com.mobilebox.model.DiskUsage;
import com.mobilebox.model.Info;
import com.mobilebox.model.Serial;

public class DeviceFactory {

  /**
   * Gets all devices.
   * 
   * @return A list with all the devices
   * @throws InternalException
   */
  public ArrayList<Device> getDevices() throws InternalException{
    DeviceInfo info = new DeviceInfo();
    DeviceDiagnostics diagnostics = new DeviceDiagnostics();
    ArrayList<Device> devices = new ArrayList<Device>();
    ArrayList<Serial> serials = new DeviceId().getSerial();
    
    for(Serial serial : serials){
      Device device = new Device();
      String udid = serial.getSerial();
      Battery battery = info.getBatteryInfo(udid);
      DiskUsage disk = info.getDiskUsageInfo(udid);
      CPUArchitecture arch = diagnostics.getCPUArchitecture(udid);
      Info deviceInfo = info.getInfo(udid);
      
      device.setSerial(udid)
            .setBattery(battery)
            .setDisk(disk)
            .setArchitecture(arch.getArchitecture())
            .setModel(deviceInfo.getProductType())
            .setPlatformVersion(deviceInfo.getProductVersion())
            .setState(AVAILABLE.toString());
      
      devices.add(device);      
    }
    
    return devices;   
  }

  /**
   * Gets a device information given the device udid.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @return A device
   * @throws InternalException
   */
  public Device getDevice(final String udid) throws InternalException {
    DeviceInfo info = new DeviceInfo();
    DeviceDiagnostics diagnostics = new DeviceDiagnostics();
    Device device = new Device();
    Battery battery = info.getBatteryInfo(udid);
    DiskUsage disk = info.getDiskUsageInfo(udid);
    CPUArchitecture arch = diagnostics.getCPUArchitecture(udid);
    Info deviceInfo = info.getInfo(udid);
      
    device.setSerial(udid)
          .setBattery(battery)
          .setDisk(disk)
          .setArchitecture(arch.getArchitecture())
          .setModel(deviceInfo.getProductType())
          .setPlatformVersion(deviceInfo.getProductVersion())
          .setState(AVAILABLE.toString());
          
    return device;   
  }

  
}
