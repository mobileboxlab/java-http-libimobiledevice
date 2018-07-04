package com.mobilebox.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.mobilebox.base.BaseTest;
import com.mobilebox.device.services.DeviceScreenshot;

public class IDeviceScreenshotSuite extends BaseTest {

  
  public void getScreenshotTest() {
    String actual = new DeviceScreenshot().getScreenshot(udid);
    assertThat(actual).isNotEmpty();
  }
}
