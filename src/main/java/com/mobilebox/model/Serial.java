package com.mobilebox.model;

public class Serial extends Model<Serial> {

  private String serial;

  public Serial() {}

  public Serial(final String id) {
    this.setSerial(id);
  }

  @Override
  public Serial me() {
    return this;
  }

  public String getSerial() {
    return serial;
  }

  public Serial setSerial(String id) {
    this.serial = id;
    return me();
  }

}
