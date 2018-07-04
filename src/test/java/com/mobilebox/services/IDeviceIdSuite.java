package com.mobilebox.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mobilebox.base.BaseTest;
import com.mobilebox.device.services.DeviceId;
import com.mobilebox.model.Serial;

public class IDeviceIdSuite extends BaseTest {

  @Test
  public void getId() {
    ArrayList<Serial> actual = new DeviceId().getSerial();
    assertThat(actual).isNotEmpty();
  }
}
