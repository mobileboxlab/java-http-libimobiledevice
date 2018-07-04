package com.mobilebox.services;

import static org.assertj.core.api.Assertions.assertThat;
import static strman.Strman.rightTrim;

import org.testng.annotations.Test;

import com.mobilebox.base.BaseTest;
import com.mobilebox.device.services.DeviceDate;

public class IDeviceDateSuite extends BaseTest {

  @Test
  public void getDateTest() {
    String actual = new DeviceDate().getDate(udid);
    assertThat(rightTrim(actual)).isNotEmpty();
  }
}
