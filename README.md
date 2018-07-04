# Overview #

This is a simple "REST" (I'm not so sure about that) service wrapper of [libimobiledevice](https://github.com/libimobiledevice/libimobiledevice) to communicate with services of Apple iOS devices using native
protocols. This service works on Linux and macOS. 

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

We need to set the libimobiledevice binaries path. In order to know this path open a terminal and execute:

```bash

whereis ideviceinfo 
```

Copy the path on the **ios-service.config** file. E.G:

```ini
service.port=5005
libimobiledevice.path=/usr/bin/
libimobiledevice.timeout=20000
```

## Execution

*	Download the latest version
*	Place the **ios-service.config** configuration file in the folder where **ios-service-X.X.X.jar** is located.
*	Start service:

```bash

sudo sudo service ios-service start
```

*	Send a GET request to http://ip:5005/api/v1/devices in order to verify that the service is running. 

```bash
curl http://127.0.0.1:5005/api/v1/devices
```
