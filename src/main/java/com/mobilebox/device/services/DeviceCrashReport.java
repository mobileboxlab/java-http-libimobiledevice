package com.mobilebox.device.services;

import com.mobilebox.executor.Service;

/**
 * Service to move crash reports from a device to a local directory.
 */
public class DeviceCrashReport extends Service {

  private final String OPTION_EXTRACT = "-e";

  public DeviceCrashReport() {
    setName("idevicecrashreport");
  }

  /**
   * Extract raw crash report into separate '.crash' file
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @param directory Full path to the local directory
   * @return
   */
  public String getCrashReport(final String udid, final String path) {
    return exec(new String[] {"-u", udid, OPTION_EXTRACT, path});
  }

}
