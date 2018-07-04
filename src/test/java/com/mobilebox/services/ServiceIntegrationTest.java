package com.mobilebox.services;

import static com.jayway.restassured.RestAssured.given;
import static java.lang.String.format;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_ARRAY_ITEMS;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_VALUES;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.response.ResponseBodyExtractionOptions;
import com.mobilebox.model.Battery;
import com.mobilebox.model.Device;
import com.mobilebox.model.DiskUsage;
import com.mobilebox.model.Response;
import com.mobilebox.model.Responses;
import com.mobilebox.service.IOSService;

import spark.Spark;

public class ServiceIntegrationTest {

  private static final String API_CONTEXT = "/api/v1";
  private String fullUrl = "http://127.0.0.1:5005" + API_CONTEXT + "/%s";
  private static final String UDID = "0416d649d4c1b9b57e0dae22a42344926a1dcc74";

  @BeforeClass
  public void beforeClass() {
    IOSService.main(null);
    Spark.awaitInitialization();
  }

  @AfterClass
  public void afterClass() {
    Spark.stop();
  }

  //TODO: Complete this test.
  public void testListDevicesShouldReturn200() throws URISyntaxException {
    String url = format(fullUrl, "devices");
    ArrayList<Device> devices = new ArrayList<Device>();
    Device device = new Device();
    Battery battery = new Battery();
    DiskUsage disk = new DiskUsage();
    
    device.setSerial(UDID)
          .setBattery(battery)
          .setDisk(disk)
          .setArchitecture("")
          .setModel("");
    
    devices.add(device);
    Responses<Device> data = new Responses<Device>(devices);
    String expected = new Response().withData(data).toJson();

    ResponseBodyExtractionOptions response =
        given().when().get(url).then().statusCode(200).extract().body();

    assertThatJson(response.asString()).when(IGNORING_VALUES, IGNORING_EXTRA_ARRAY_ITEMS, IGNORING_ARRAY_ORDER).isEqualTo(expected);
  }

  @Test()
  public void testGetBatteryShouldReturn200() throws URISyntaxException {
    String url = format(fullUrl, "device/" + UDID + "/battery");
    String expected =
        "{\"data\":{\"currentCapacity\":100,\"isCharging\": true,\"externalChargeCapable\":true,\"externalConnected\":true,\"fullyCharged\":false,\"gasGaugeCapability\":true}}";

    ResponseBodyExtractionOptions response =
        given().when().get(url).then().statusCode(200).extract().body();
    assertThatJson(response.asString()).when(IGNORING_VALUES).isEqualTo(expected);
  }

  @Test()
  public void testGetDiskShouldReturn200() throws URISyntaxException {
    String url = format(fullUrl, "device/" + UDID + "/disk");
    String expected =
        "{\"data\": {\"amountDataAvailable\": 0.0,\"amountDataReserved\": 0.0,\"calculateDiskUsage\": \"null\",\"calendarUsage\": 0.0,\"cameraUsage\": 0.0,\"mediaCacheUsage\": 0.0,\"notesUsage\": 0.0,\"photoUsage\": 0.0,\"totalDataAvailable\": 0.0,\"totalDataCapacity\": 0.0,\"totalDiskCapacity\": 15955132416.0,\"totalSystemAvailable\": 0.0,\"totalSystemCapacity\": 0.0,\"voicemailUsage\": 0.0,\"webAppCacheUsage\": 0.0}}";

    ResponseBodyExtractionOptions response =
        given().when().get(url).then().statusCode(200).extract().body();
    assertThatJson(response.asString()).when(IGNORING_VALUES).isEqualTo(expected);
  }

  @Test()
  public void testGetModelShouldReturn200() throws URISyntaxException {
    String url = format(fullUrl, "device/" + UDID + "/model");
    String expected = "{\"data\": {\"number\": MCFD23,\"status\":\"Success\"}}";

    ResponseBodyExtractionOptions response =
        given().when().get(url).then().statusCode(200).extract().body();
    assertThatJson(response.asString()).when(IGNORING_VALUES).isEqualTo(expected);
  }

  @Test()
  public void testGetCPUArchitectureShouldReturn200() throws URISyntaxException {
    String url = format(fullUrl, "device/" + UDID + "/cpu/architecture");
    String expected = "{\"data\": {\"architecture\": armvf7,\"status\":\"Success\"}}";

    ResponseBodyExtractionOptions response =
        given().when().get(url).then().statusCode(200).extract().body();
    assertThatJson(response.asString()).when(IGNORING_VALUES).isEqualTo(expected);
  }
}
