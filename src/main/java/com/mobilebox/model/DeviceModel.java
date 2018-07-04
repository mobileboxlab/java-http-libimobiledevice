package com.mobilebox.model;

import com.dd.plist.NSDictionary;

public class DeviceModel extends Model<DeviceModel> {

  String number;
  String status;

  public DeviceModel() {}

  @Override
  public DeviceModel me() {
    return this;
  }

  /**
   * Create a new DeviceModel given a NSDictionary with Disk information.
   * 
   * @param d A NSDictionary instance.
   */
  public DeviceModel(final NSDictionary d) {
    this.number = toString(d.get("ModelNumber"));
    this.status = toString(d.get("Status"));
  }

  public String getNumber() {
    return number;
  }

  public DeviceModel setNumber(String number) {
    this.number = number;
    return me();
  }

  public String getStatus() {
    return status;
  }

  public DeviceModel setStatus(String status) {
    this.status = status;
    return me();
  }


}
