package com.mobilebox.service;


import static com.mobilebox.service.Consts.API_CONTEXT;
import static com.mobilebox.service.Consts.CONTENT_TYPE_JSON;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;

import java.util.ArrayList;

import org.aeonbits.owner.ConfigCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilebox.configuration.Configuration;
import com.mobilebox.device.services.DeviceDiagnostics;
import com.mobilebox.device.services.DeviceInfo;
import com.mobilebox.exception.InternalException;
import com.mobilebox.exception.NotFoundException;
import com.mobilebox.model.Battery;
import com.mobilebox.model.CPUArchitecture;
import com.mobilebox.model.Device;
import com.mobilebox.model.DeviceModel;
import com.mobilebox.model.DiskUsage;
import com.mobilebox.model.Response;
import com.mobilebox.model.Responses;

public class IOSService {

  static Logger log = LoggerFactory.getLogger(IOSService.class);

  public static void main(String[] args) {
    port(getConfig().serverPort());

    before((request, response) -> {
      response.header("Access-Control-Request-Method", "*");
      response.header("Access-Control-Allow-Headers", "*");
      response.header("Access-Control-Allow-Origin", "*");
      response.header("Access-Control-Allow-Methods", "DELETE,GET,POST,PUT");
    });
    
    /**
     * @api {get} /devices GetDevices
     * @apiDescription Get all devices
     * @apiGroup Devices
     * @apiVersion 0.2.0
     * @apiName GetDevices
     * 
     * @apiSuccessExample Success-Response: 
     * HTTP/1.1 200 OK 
     * {
     *     "data": {
     *         "items": [
     *             {
     *                 "architecture": "armv7f", 
     *                 "battery": {
     *                     "currentCapacity": 100, 
     *                     "externalChargeCapable": true, 
     *                     "externalConnected": true, 
     *                     "fullyCharged": false, 
     *                     "gasGaugeCapability": true, 
     *                     "health": "good", 
     *                     "isCharging": false, 
     *                     "temp": "0"     
     *                 }, 
     *                 "disk": {
     *                     "amountDataAvailable": 2901368832.0, 
     *                     "amountDataReserved": 209715200.0, 
     *                     "calculateDiskUsage": "null", 
     *                     "calendarUsage": 0.0, 
     *                     "cameraUsage": 0.0, 
     *                     "mediaCacheUsage": 0.0, 
     *                     "notesUsage": 0.0, 
     *                     "photoUsage": 0.0, 
     *                     "totalDataAvailable": 3111084032.0, 
     *                     "totalDataCapacity": 13924319232.0, 
     *                     "totalDiskCapacity": 15955132416.0, 
     *                     "totalSystemAvailable": 272629760.0, 
     *                     "totalSystemCapacity": 2030813184.0, 
     *                     "voicemailUsage": 0.0, 
     *                     "webAppCacheUsage": 0.0
     *                 }, 
     *                 "model": "iPad", 
     *                 "manufacturer": "Apple",
     *                 "platform": "ios", 
     *                 "platformVersion": "8.4.1",    
     *                 "present": true,
     *                 "ready": true,
     *                 "status" : 3,   
     *                 "serial": "0416d649d4c1b9b57e0dae22a42344926a1dcc74",
     *                 "state": "available"  
     *             }
     *         ], 
     *         "size": 1
     *     }
     * }
     *
     * @apiUse InternalError
     */
    get(API_CONTEXT + "/devices", (req, res) -> {
      ArrayList<Device> devices = new DeviceFactory().getDevices();
      res.status(200);
      Responses<Device> data = new Responses<Device>(devices);
      return new Response().withData(data).toJson();
    });
    
    /**
     * @api {get} /device/:serial GetDevice
     * @apiDescription Get a device
     * @apiGroup Devices
     * @apiVersion 0.2.0
     * @apiName GetDevice
     * @apiParam {String} serial Target specific device by its 40-digit device UDID.
     * 
     * @apiSuccessExample Success-Response: 
     * HTTP/1.1 200 OK 
     * {
     *     "data":{
     *             {
     *                "architecture": "armv7f", 
     *                "battery": {
     *                    "currentCapacity": 100, 
     *                    "externalChargeCapable": true, 
     *                    "externalConnected": true, 
     *                    "fullyCharged": false, 
     *                    "gasGaugeCapability": true, 
     *                    "health": "good", 
     *                    "isCharging": false, 
     *                    "temp": "0"     
     *                }, 
     *                "disk": {
     *                    "amountDataAvailable": 2901368832.0, 
     *                    "amountDataReserved": 209715200.0, 
     *                    "calculateDiskUsage": "null", 
     *                    "calendarUsage": 0.0, 
     *                    "cameraUsage": 0.0, 
     *                    "mediaCacheUsage": 0.0, 
     *                    "notesUsage": 0.0, 
     *                    "photoUsage": 0.0, 
     *                    "totalDataAvailable": 3111084032.0, 
     *                    "totalDataCapacity": 13924319232.0, 
     *                    "totalDiskCapacity": 15955132416.0, 
     *                    "totalSystemAvailable": 272629760.0, 
     *                    "totalSystemCapacity": 2030813184.0, 
     *                    "voicemailUsage": 0.0, 
     *                    "webAppCacheUsage": 0.0
     *                }, 
     *                "model": "iPad", 
     *                "manufacturer": "Apple",
     *                "platform": "ios", 
     *                "platformVersion": "8.4.1", 
     *                "present": true,     
     *                "ready": true,
     *                "status" : 3, 
     *                "serial": "0416d649d4c1b9b57e0dae22a42344926a1dcc74",
     *                "state": "available"     
     *             }
     *     }
     * }
     *
     */
    get(API_CONTEXT + "/device/:serial", (req, res) -> {
      String udid = req.params(":serial");
      Device device = new DeviceFactory().getDevice(udid);
      res.status(200);
      return new Response().withData(device).toJson();
    });

    /**
     * @api {get} /device/:serial/battery GetBatteryInfo
     * @apiDescription Gets information about the battery of an attached device.
     * @apiGroup Devices
     * @apiVersion 0.1.0
     * @apiName GetBatteryInfo
     * @apiParam {String} serial Target specific device by its 40-digit device UDID.
     * 
     * @apiSuccessExample Success-Response: 
     * {
     *     "data": {
     *         "currentCapacity": 100, 
     *         "externalChargeCapable": true, 
     *         "externalConnected": true, 
     *         "fullyCharged": false, 
     *         "gasGaugeCapability": true, 
     *         "health": "good", 
     *         "isCharging": false, 
     *         "temp": "0"     
     *     }
     * }
     * 
     * @apiUse InternalError
     */
    get(API_CONTEXT + "/device/:serial/battery", (req, res) -> {
      String udid = req.params(":serial");
      Battery battery = new DeviceInfo().getBatteryInfo(udid);
      res.status(200);
      return new Response().withData(battery).toJson();
    });

    /**
     * @api {get} /device/:serial/disk GetDiskInfo
     * @apiDescription Gets information about the disk usage of an attached device.
     * @apiGroup Devices
     * @apiVersion 0.1.0
     * @apiName GetDiskInfo
     * @apiParam {String} serial Target specific device by its 40-digit device UDID.
     * 
     * @apiSuccessExample Success-Response: 
     * {
     *     "data": {
     *         "amountDataAvailable": 2901368832.0, 
     *         "amountDataReserved": 209715200.0, 
     *         "calculateDiskUsage": "null", 
     *         "calendarUsage": 0.0, 
     *         "cameraUsage": 0.0, 
     *         "mediaCacheUsage": 0.0, 
     *         "notesUsage": 0.0, 
     *         "photoUsage": 0.0, 
     *         "totalDataAvailable": 3111084032.0, 
     *         "totalDataCapacity": 13924319232.0, 
     *         "totalDiskCapacity": 15955132416.0, 
     *         "totalSystemAvailable": 272629760.0, 
     *         "totalSystemCapacity": 2030813184.0, 
     *         "voicemailUsage": 0.0, 
     *         "webAppCacheUsage": 0.0
     *    }
     * }
     * 
     * @apiUse InternalError
     */
    get(API_CONTEXT + "/device/:serial/disk", (req, res) -> {
      String udid = req.params(":serial");
      DiskUsage disk = new DeviceInfo().getDiskUsageInfo(udid);
      res.status(200);
      return new Response().withData(disk).toJson();
    });

    /**
     * @api {get} /device/:serial/model GetModelInfo
     * @apiDescription Retrieve the model from the target device.
     * @apiGroup Devices
     * @apiVersion 0.1.0
     * @apiName GetModelInfo
     * @apiParam {String} serial Target specific device by its 40-digit device UDID.
     * 
     * @apiSuccessExample Success-Response: 
     * {
     *     "data": {
     *         "number": "MC769", 
     *         "status": "Success"
     *     }
     * }
     * 
     * @apiUse InternalError
     */
    get(API_CONTEXT + "/device/:serial/model", (req, res) -> {
      String udid = req.params(":serial");
      DeviceModel model = new DeviceDiagnostics().getModel(udid);
      res.status(200);
      return new Response().withData(model).toJson();
    });

    /**
     * @api {get} /device/:serial/cpu/architecture GetCPUArchitecture 
     * @apiDescription Retrieve the CPU Architecture from the target device.
     * @apiGroup Devices
     * @apiVersion 0.1.0
     * @apiName GetCPUArchitecture 
     * @apiParam {String} serial Target specific device by its 40-digit device UDID.
     * 
     * @apiSuccessExample Success-Response: 
     * {
     *     "data": {
     *         "architecture": "armv7f", 
     *         "status": "Success"
     *     }
     * }
     * 
     * @apiUse InternalError
     */
    get(API_CONTEXT + "/device/:serial/cpu/architecture", (req, res) -> {
      String udid = req.params(":serial");
      CPUArchitecture architecture = new DeviceDiagnostics().getCPUArchitecture(udid);
      res.status(200);
      return new Response().withData(architecture).toJson();
    });

    /**
     * @apiDefine InternalError
     *
     * @apiError (500) InternalError The action cannot be completed
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 500 Server Error
     * {
     *     "code": "INTERNAL_ERROR", 
     *     "message": "Error description"
     * }
     */
    exception(InternalException.class, (e, request, response) -> {
      response.status(500);
      response.type(CONTENT_TYPE_JSON);
      response.body(new Response().withCode("INTERNAL_ERROR").withMessage(e.getMessage()).toJson());
    });

    /**
     * @apiDefine NotFoundError
     *
     * @apiError NotFoundError The resource requested not found.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found Error
     * {
     *     "code": "NOT_FOUND", 
     *     "message": "Error description"
     * }
     */
    exception(NotFoundException.class, (e, request, response) -> {
      response.status(404);
      response.type(CONTENT_TYPE_JSON);
      response.body(new Response().withCode("NOT_FOUND").withMessage(e.getMessage()).toJson());
    });

    /**
     * @apiDefine ExceptionError
     *
     * @apiError (500) ExceptionError Generic error
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 500 Server Error
     * {
     *     "code": "INTERNAL_ERROR", 
     *     "message": "Error description"
     * }
     */
    exception(Exception.class, (e, request, response) -> {
      response.status(500);
      response.type(CONTENT_TYPE_JSON);
      response.body(new Response().withCode("INTERNAL_ERROR").withMessage(e.getMessage()).toJson());
    });

    after((req, res) -> {
      res.type(CONTENT_TYPE_JSON);
    });
  }

  private static Configuration getConfig() {
    return ConfigCache.getOrCreate(Configuration.class);
  }
}
