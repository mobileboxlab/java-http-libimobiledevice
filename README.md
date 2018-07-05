# Overview #

**java-http-libimobiledevice** is a simple "REST" (I'm not so sure about that) service wrapper of [libimobiledevice](https://github.com/libimobiledevice/libimobiledevice) to communicate with services of Apple iOS devices using native
protocols. This service works on Linux and macOS. 

**libimobiledevice** is a cross-platform software library that talks the protocols to support iPhone®, iPod Touch®, iPad® and Apple TV® devices. Unlike other projects, it does not depend on using any existing proprietary libraries and does not require jailbreaking. It allows other software to easily access the device's filesystem, retrieve information about the device and it's internals, backup/restore the device, manage SpringBoard® icons, manage installed applications, etc.

## Requirements 

Install **libimobiledevice**: 

**Linux (Ubuntu)**
```bash
sudo add-apt-repository ppa:pmcenery/ppa
sudo apt-get update
sudo apt-get install libimobiledevice
sudo apt-get install libimobiledevice-utils
```

**macOS**
```bash
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" < /dev/null 2> /dev/null
brew install libimobiledevice
```

## Configuration

We need to set the **libimobiledevice** binaries path. In order to know this path open a terminal and execute:

```bash
whereis ideviceinfo 
```

Copy the path on the **ios-service.config** file. E.G:

```ini
service.port=5050
libimobiledevice.path=/usr/bin/
libimobiledevice.timeout=20000
```

## Execution

*	Download the latest version
*	Place the **ios-service.config** configuration file in the folder where **java-http-libimobiledevice-X.X.X.jar** is located.
*	Start service:

```bash
java -jar java-http-libimobiledevice-X.X.X.jar
```

## URL structure

The java-http-libimobiledevice API lives at [http://127.0.0.1:5050/api/v1/](http://127.0.0.1:5050/api/v1/), with particular endpoints following that prefix.

Responses are in **JSON** 

## Example calls

API examples use [httpie](https://httpie.org), a command-line HTTP client.

Gets information about the battery of an attached device.

**:serial** = Target specific device by its 40-digit device UDID.

```bash
http http://127.0.0.1:5050/api/v1/device/:serial/battery
```
**Response**

```json
{
    "data": {
        "currentCapacity": 100,
        "externalChargeCapable": true,
        "externalConnected": true,
        "fullyCharged": false,
        "gasGaugeCapability": true,
        "health": "good",
        "isCharging": false,
        "temp": "0"
    }
}
```

Retrieve the CPU Architecture from the target device.

```bash
http http://127.0.0.1:5050/api/v1/device/:serial/cpu/architecture
```
**Response**

```json

{
    "data": {
        "architecture": "armv7f",
        "status": "Success"
    }
}
```
Get a device

Retrieve the CPU Architecture from the target device.

```bash
http http://127.0.0.1:5050/api/v1/device/:serial
```
**Response**

```json

{
    "data":{
               "architecture": "armv7f", 
               "battery": {
                   "currentCapacity": 100, 
                   "externalChargeCapable": true, 
                   "externalConnected": true, 
                   "fullyCharged": false, 
                   "gasGaugeCapability": true, 
                   "health": "good", 
                   "isCharging": false, 
                   "temp": "0"     
               }, 
               "disk": {
                   "amountDataAvailable": 2901368832.0, 
                   "amountDataReserved": 209715200.0, 
                   "calculateDiskUsage": "null", 
                   "calendarUsage": 0.0, 
                   "cameraUsage": 0.0, 
                   "mediaCacheUsage": 0.0, 
                   "notesUsage": 0.0, 
                   "photoUsage": 0.0, 
                   "totalDataAvailable": 3111084032.0, 
                   "totalDataCapacity": 13924319232.0, 
                   "totalDiskCapacity": 15955132416.0, 
                   "totalSystemAvailable": 272629760.0, 
                   "totalSystemCapacity": 2030813184.0, 
                   "voicemailUsage": 0.0, 
                   "webAppCacheUsage": 0.0
               }, 
               "model": "iPad", 
               "manufacturer": "Apple",
               "platform": "ios", 
               "platformVersion": "8.4.1", 
               "present": true,     
               "ready": true,
               "status" : 3, 
               "serial": "0416d649d4c1b9b57e0dae22a42344926a1dcc74",
               "state": "available"     
            }
    }
}
```

# API Documentation

We use [apiDoc](http://apidocjs.com/) in order to generate the [documentation](https://mobileboxlab.github.io/java-http-libimobiledevice/) for java-http-libimobiledevice’s HTTP API.

**apiDoc** creates a documentation from API annotations in your source code. Please check the documentation [here](http://apidocjs.com/#params)

The proyect come with a Maven task in order to generate the documentation from Maven without any pain, but FIRST you need install **apiDoc** of course:

```bash
npm install apidoc -g 
```

And now we need execute the following command: 

```bash
mvn exec:exec
```

The documentation is generated on the **doc** directory. 

## Contribution

Any ideas are welcome. Feel free to submit any issues or pull requests.

