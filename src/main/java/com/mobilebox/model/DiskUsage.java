package com.mobilebox.model;

import com.dd.plist.NSDictionary;

public class DiskUsage extends Model<DiskUsage> {

  double amountDataAvailable;
  double amountDataReserved;
  String calculateDiskUsage;
  double calendarUsage;
  double cameraUsage;
  double mediaCacheUsage;
  double notesUsage;
  double photoUsage;
  double totalDataAvailable;
  double totalDataCapacity;
  double totalDiskCapacity;
  double totalSystemAvailable;
  double totalSystemCapacity;
  double voicemailUsage;
  double webAppCacheUsage;

  public DiskUsage() {}

  @Override
  public DiskUsage me() {
    return me();
  }

  /**
   * Create a new DiskUsage given a NSDictionary with Disk information.
   * 
   * @param d A NSDictionary instance.
   */
  public DiskUsage(final NSDictionary d) {
    this.amountDataAvailable = toDouble(d.get("AmountDataAvailable"));
    this.amountDataReserved = toDouble(d.get("AmountDataReserved"));
    this.calculateDiskUsage = toString(d.get("CalculateDiskUsag"));
    this.calendarUsage = toDouble(d.get("CalendarUsage"));
    this.cameraUsage = toDouble(d.get("CameraUsage"));
    this.mediaCacheUsage = toDouble(d.get("MediaCacheUsage"));
    this.notesUsage = toDouble(d.get("NotesUsage"));
    this.photoUsage = toDouble(d.get("PhotoUsage"));
    this.totalDataAvailable = toDouble(d.get("TotalDataAvailable"));
    this.totalDataCapacity = toDouble(d.get("TotalDataCapacity"));
    this.totalDiskCapacity = toDouble(d.get("TotalDiskCapacity"));
    this.totalSystemAvailable = toDouble(d.get("TotalSystemAvailable"));
    this.totalSystemCapacity = toDouble(d.get("TotalSystemCapacity"));
    this.voicemailUsage = toDouble(d.get("VoicemailUsage"));
    this.webAppCacheUsage = toDouble(d.get("WebAppCacheUsage"));
  }

  public double getAmountDataAvailable() {
    return amountDataAvailable;
  }

  public DiskUsage setAmountDataAvailable(double amountDataAvailable) {
    this.amountDataAvailable = amountDataAvailable;
    return me();
  }

  public double getAmountDataReserved() {
    return amountDataReserved;
  }

  public DiskUsage setAmountDataReserved(double amountDataReserved) {
    this.amountDataReserved = amountDataReserved;
    return me();
  }

  public String getCalculateDiskUsage() {
    return calculateDiskUsage;
  }

  public DiskUsage setCalculateDiskUsage(String calculateDiskUsage) {
    this.calculateDiskUsage = calculateDiskUsage;
    return me();
  }

  public double getCalendarUsage() {
    return calendarUsage;
  }

  public DiskUsage setCalendarUsage(double calendarUsage) {
    this.calendarUsage = calendarUsage;
    return me();
  }

  public double getCameraUsage() {
    return cameraUsage;
  }

  public DiskUsage setCameraUsage(double cameraUsage) {
    this.cameraUsage = cameraUsage;
    return me();
  }

  public double getMediaCacheUsage() {
    return mediaCacheUsage;
  }

  public DiskUsage setMediaCacheUsage(double mediaCacheUsage) {
    this.mediaCacheUsage = mediaCacheUsage;
    return me();
  }

  public double getNotesUsage() {
    return notesUsage;
  }

  public DiskUsage setNotesUsage(double notesUsage) {
    this.notesUsage = notesUsage;
    return me();
  }

  public double getPhotoUsage() {
    return photoUsage;
  }

  public DiskUsage setPhotoUsage(double photoUsage) {
    this.photoUsage = photoUsage;
    return me();
  }

  public double getTotalDataAvailable() {
    return totalDataAvailable;
  }

  public DiskUsage setTotalDataAvailable(double totalDataAvailable) {
    this.totalDataAvailable = totalDataAvailable;
    return me();
  }

  public double getTotalDataCapacity() {
    return totalDataCapacity;
  }

  public DiskUsage setTotalDataCapacity(double totalDataCapacity) {
    this.totalDataCapacity = totalDataCapacity;
    return me();
  }

  public double getTotalDiskCapacity() {
    return totalDiskCapacity;
  }

  public DiskUsage setTotalDiskCapacity(double totalDiskCapacity) {
    this.totalDiskCapacity = totalDiskCapacity;
    return me();
  }

  public double getTotalSystemAvailable() {
    return totalSystemAvailable;
  }

  public DiskUsage setTotalSystemAvailable(double totalSystemAvailable) {
    this.totalSystemAvailable = totalSystemAvailable;
    return me();
  }

  public double getTotalSystemCapacity() {
    return totalSystemCapacity;
  }

  public DiskUsage setTotalSystemCapacity(double totalSystemCapacity) {
    this.totalSystemCapacity = totalSystemCapacity;
    return me();
  }

  public double getVoicemailUsage() {
    return voicemailUsage;
  }

  public DiskUsage setVoicemailUsage(double voicemailUsage) {
    this.voicemailUsage = voicemailUsage;
    return me();
  }

  public double getWebAppCacheUsage() {
    return webAppCacheUsage;
  }

  public DiskUsage setWebAppCacheUsage(double webAppCacheUsage) {
    this.webAppCacheUsage = webAppCacheUsage;
    return me();
  }



}
