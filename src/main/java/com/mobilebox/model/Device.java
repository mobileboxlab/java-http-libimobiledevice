package com.mobilebox.model;

import com.google.gson.annotations.SerializedName;
import static com.mobilebox.service.Consts.*;

public class Device extends Model<Device> {

  @SerializedName("serial")
  private String serial;

  @SerializedName("battery")
  private Battery battery;

  @SerializedName("model")
  private String model;

  @SerializedName("disk")
  private DiskUsage disk;

  @SerializedName("platform")
  private String platform = PLATFORM_IOS;

  @SerializedName("platformVersion")
  private String platformVersion;

  @SerializedName("architecture")
  private String architecture;

  @SerializedName("state")
  private String state;
  
  @SerializedName("manufacturer")
  private String manufacturer =  MANUFACTURER;
  
  //Required by STF in order to set the state of the device.
  @SerializedName("present")
  private boolean present = true;

  @SerializedName("status")
  private int status = 3;
  
  @SerializedName("ready")
  private boolean ready = true;
  
  public Device() {}

  public String getSerial() {
    return serial;
  }

  public Device setSerial(String serial) {
    this.serial = serial;
    return me();
  }

  public Battery getBattery() {
    return battery;
  }

  public Device setBattery(Battery battery) {
    this.battery = battery;
    return me();
  }

  public String getModel() {
    return model;
  }

  public Device setModel(String model) {
    this.model = model;
    return me();
  }

  public DiskUsage getDisk() {
    return disk;
  }

  public Device setDisk(DiskUsage disk) {
    this.disk = disk;
    return me();
  }

  public String getPlatformVersion() {
    return platformVersion;
  }

  public Device setPlatformVersion(String platformVersion) {
    this.platformVersion = platformVersion;
    return me();
  }

  public String getArchitecture() {
    return architecture;
  }

  public Device setArchitecture(String architecture) {
    this.architecture = architecture;
    return me();
  }

  public String getPlatform() {
    return platform;
  }

  public String getState() {
    return state;
  }

  public Device setState(String state) {
    this.state = state;
    return me();
  }

  @Override
  public Device me() {
    return this;
  }

  @Override
  public String toString() {
    return "Device [serial=" + serial + ", battery=" + battery + ", model=" + model + ", disk="
        + disk + ", platform=" + platform + ", platformVersion=" + platformVersion
        + ", architecture=" + architecture + ", state=" + state + ", manufacturer=" + manufacturer
        + ", present=" + present + "]";
  }
}
