package com.mobilebox.device.services;

import java.util.Optional;

import com.mobilebox.exception.InternalException;
import com.mobilebox.executor.Service;
import com.mobilebox.model.CPUArchitecture;
import com.mobilebox.model.DeviceModel;
import com.mobilebox.parser.IDeviceParser;

/**
 * Retrieves diagnostics information from device.
 */
public class DeviceDiagnostics extends Service {

  private final String MOBILEGESTALT = "mobilegestalt";
  private final String DIAGNOSTICS = "diagnostics";
  private final String IOREGISTRY = "ioreg";

  public DeviceDiagnostics() {
    setName("idevicediagnostics");
  }

  /**
   * Diagnostics information type.
   */
  public enum Diagnostics {
    ALL("All"), 
    WIFI("WiFi"), 
    GASGAUGE("GasGauge"), 
    NAND("NAND");

    private final String value;

    private Diagnostics(final String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  /**
   * Mobilegestalt keys.
   */
  public enum Keys {
    DISKUSAGE("DiskUsage"), 
    MODELNUMBER("ModelNumber"), 
    TRAYSTATUS("SIMTrayStatus"), 
    SERIALNUMBER("SerialNumber"), 
    CHIPID("UniqueChipID"), 
    CPUARCHITECTURE("CPUArchitecture"), 
    PARTITIONTYPE("PartitionType"), 
    DEVICENAME("UserAssignedDeviceName");

    private final String value;

    private Keys(final String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  /**
   * IO registers keys.
   */
  public enum Register {
    IODEVICETREE("IODeviceTree"), 
    IOPOWER("IOPower"), 
    IOSERVICE("IOService");

    private final String value;

    private Register(final String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  /**
   * Gets diagnostics information of the target device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @param type Diagnostics type.
   * @return Diagnostics information
   */
  public String getDiagnostics(final String udid, Diagnostics type) {
    return exec(new String[] {"-u", udid, DIAGNOSTICS, type.toString()});
  }

  /**
   * Restart the target device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   */
  public void restart(final String udid) {
    exec(udid, Optional.of("restart"));
  }

  /**
   * Shutdown of the target device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   */
  public void shutdown(final String udid) {
    exec(udid, Optional.of("shutdown"));
  }

  /**
   * Gets information of the target device given a key.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @param key The Mobilegestalt key.
   * @return Diagnostics information
   */
  public String getKey(final String udid, Keys key) {
    return exec(new String[] {"-u", udid, MOBILEGESTALT, key.toString()});
  }

  /**
   * Retrieve IO registry from the target device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @param registry The IO registry.
   * @return Diagnostics information
   */
  public String getIORegistry(final String udid, Register register) {
    return exec(new String[] {"-u", udid, IOREGISTRY, register.toString()});
  }

  /**
   * Retrieve the model from the target device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @return Device model information.
   * @throws InternalException
   */
  public DeviceModel getModel(final String udid) throws InternalException {
    String response = getKey(udid, Keys.MODELNUMBER);
    return (DeviceModel) IDeviceParser.MODELNUMBER.parser(toNSDictionary(response));
  }

  /**
   * Retrieve the CPU Architecture from the target device.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @return Device CPU Architecture information.
   * @throws InternalException
   */
  public CPUArchitecture getCPUArchitecture(final String udid) throws InternalException {
    String response = getKey(udid, Keys.CPUARCHITECTURE);
    return (CPUArchitecture) IDeviceParser.CPUARCHITECTURE.parser(toNSDictionary(response));
  }

}
