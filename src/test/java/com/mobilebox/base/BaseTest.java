package com.mobilebox.base;

import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected String udid;

  @BeforeClass
  public void beforeClass() {
    udid = "0416d649d4c1b9b57e0dae22a42344926a1dcc74";
  }

}
