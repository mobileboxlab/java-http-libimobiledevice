package com.mobilebox.model;

import com.dd.plist.NSDictionary;

public class CPUArchitecture extends Model<CPUArchitecture> {

  String architecture;
  String status;

  public CPUArchitecture() {}

  @Override
  public CPUArchitecture me() {
    return this;
  }

  /**
   * Create a new DiskUsage given a NSDictionary with Disk information.
   * 
   * @param d A NSDictionary instance.
   */
  public CPUArchitecture(final NSDictionary d) {
    this.architecture = toString(d.get("CPUArchitecture"));
    this.status = toString(d.get("Status"));
  }

  public String getArchitecture() {
    return architecture;
  }

  public CPUArchitecture setArchitecture(String architecture) {
    this.architecture = architecture;
    return me();
  }

  public String getStatus() {
    return status;
  }

  public CPUArchitecture setStatus(String status) {
    this.status = status;
    return me();
  }


}
