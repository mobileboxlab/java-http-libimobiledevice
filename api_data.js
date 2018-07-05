define({ "api": [
  {
    "type": "get",
    "url": "/device/:serial/battery",
    "title": "GetBatteryInfo",
    "description": "<p>Gets information about the battery of an attached device.</p>",
    "group": "Devices",
    "version": "0.1.0",
    "name": "GetBatteryInfo",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "serial",
            "description": "<p>Target specific device by its 40-digit device UDID.</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response: ",
          "content": "{\n    \"data\": {\n        \"currentCapacity\": 100, \n        \"externalChargeCapable\": true, \n        \"externalConnected\": true, \n        \"fullyCharged\": false, \n        \"gasGaugeCapability\": true, \n        \"health\": \"good\", \n        \"isCharging\": false, \n        \"temp\": \"0\"     \n    }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "/home/henry/Documents/workspace/java-http-libimobiledevice/src/main/java/com/mobilebox/service/IOSService.java",
    "groupTitle": "Devices",
    "error": {
      "fields": {
        "500": [
          {
            "group": "500",
            "optional": false,
            "field": "InternalError",
            "description": "<p>The action cannot be completed</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "    HTTP/1.1 500 Server Error\n{\n    \"code\": \"INTERNAL_ERROR\", \n    \"message\": \"Error description\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "get",
    "url": "/device/:serial/cpu/architecture",
    "title": "GetCPUArchitecture",
    "description": "<p>Retrieve the CPU Architecture from the target device.</p>",
    "group": "Devices",
    "version": "0.1.0",
    "name": "GetCPUArchitecture",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "serial",
            "description": "<p>Target specific device by its 40-digit device UDID.</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response: ",
          "content": "{\n    \"data\": {\n        \"architecture\": \"armv7f\", \n        \"status\": \"Success\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "/home/henry/Documents/workspace/java-http-libimobiledevice/src/main/java/com/mobilebox/service/IOSService.java",
    "groupTitle": "Devices",
    "error": {
      "fields": {
        "500": [
          {
            "group": "500",
            "optional": false,
            "field": "InternalError",
            "description": "<p>The action cannot be completed</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "    HTTP/1.1 500 Server Error\n{\n    \"code\": \"INTERNAL_ERROR\", \n    \"message\": \"Error description\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "get",
    "url": "/device/:serial",
    "title": "GetDevice",
    "description": "<p>Get a device</p>",
    "group": "Devices",
    "version": "0.2.0",
    "name": "GetDevice",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "serial",
            "description": "<p>Target specific device by its 40-digit device UDID.</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response: ",
          "content": "HTTP/1.1 200 OK \n{\n    \"data\":{\n            {\n               \"architecture\": \"armv7f\", \n               \"battery\": {\n                   \"currentCapacity\": 100, \n                   \"externalChargeCapable\": true, \n                   \"externalConnected\": true, \n                   \"fullyCharged\": false, \n                   \"gasGaugeCapability\": true, \n                   \"health\": \"good\", \n                   \"isCharging\": false, \n                   \"temp\": \"0\"     \n               }, \n               \"disk\": {\n                   \"amountDataAvailable\": 2901368832.0, \n                   \"amountDataReserved\": 209715200.0, \n                   \"calculateDiskUsage\": \"null\", \n                   \"calendarUsage\": 0.0, \n                   \"cameraUsage\": 0.0, \n                   \"mediaCacheUsage\": 0.0, \n                   \"notesUsage\": 0.0, \n                   \"photoUsage\": 0.0, \n                   \"totalDataAvailable\": 3111084032.0, \n                   \"totalDataCapacity\": 13924319232.0, \n                   \"totalDiskCapacity\": 15955132416.0, \n                   \"totalSystemAvailable\": 272629760.0, \n                   \"totalSystemCapacity\": 2030813184.0, \n                   \"voicemailUsage\": 0.0, \n                   \"webAppCacheUsage\": 0.0\n               }, \n               \"model\": \"iPad\", \n               \"manufacturer\": \"Apple\",\n               \"platform\": \"ios\", \n               \"platformVersion\": \"8.4.1\", \n               \"present\": true,     \n               \"ready\": true,\n               \"status\" : 3, \n               \"serial\": \"0416d649d4c1b9b57e0dae22a42344926a1dcc74\",\n               \"state\": \"available\"     \n            }\n    }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "/home/henry/Documents/workspace/java-http-libimobiledevice/src/main/java/com/mobilebox/service/IOSService.java",
    "groupTitle": "Devices"
  },
  {
    "type": "get",
    "url": "/devices",
    "title": "GetDevices",
    "description": "<p>Get all devices</p>",
    "group": "Devices",
    "version": "0.2.0",
    "name": "GetDevices",
    "success": {
      "examples": [
        {
          "title": "Success-Response: ",
          "content": "HTTP/1.1 200 OK \n{\n    \"data\": {\n        \"items\": [\n            {\n                \"architecture\": \"armv7f\", \n                \"battery\": {\n                    \"currentCapacity\": 100, \n                    \"externalChargeCapable\": true, \n                    \"externalConnected\": true, \n                    \"fullyCharged\": false, \n                    \"gasGaugeCapability\": true, \n                    \"health\": \"good\", \n                    \"isCharging\": false, \n                    \"temp\": \"0\"     \n                }, \n                \"disk\": {\n                    \"amountDataAvailable\": 2901368832.0, \n                    \"amountDataReserved\": 209715200.0, \n                    \"calculateDiskUsage\": \"null\", \n                    \"calendarUsage\": 0.0, \n                    \"cameraUsage\": 0.0, \n                    \"mediaCacheUsage\": 0.0, \n                    \"notesUsage\": 0.0, \n                    \"photoUsage\": 0.0, \n                    \"totalDataAvailable\": 3111084032.0, \n                    \"totalDataCapacity\": 13924319232.0, \n                    \"totalDiskCapacity\": 15955132416.0, \n                    \"totalSystemAvailable\": 272629760.0, \n                    \"totalSystemCapacity\": 2030813184.0, \n                    \"voicemailUsage\": 0.0, \n                    \"webAppCacheUsage\": 0.0\n                }, \n                \"model\": \"iPad\", \n                \"manufacturer\": \"Apple\",\n                \"platform\": \"ios\", \n                \"platformVersion\": \"8.4.1\",    \n                \"present\": true,\n                \"ready\": true,\n                \"status\" : 3,   \n                \"serial\": \"0416d649d4c1b9b57e0dae22a42344926a1dcc74\",\n                \"state\": \"available\"  \n            }\n        ], \n        \"size\": 1\n    }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "/home/henry/Documents/workspace/java-http-libimobiledevice/src/main/java/com/mobilebox/service/IOSService.java",
    "groupTitle": "Devices",
    "error": {
      "fields": {
        "500": [
          {
            "group": "500",
            "optional": false,
            "field": "InternalError",
            "description": "<p>The action cannot be completed</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "    HTTP/1.1 500 Server Error\n{\n    \"code\": \"INTERNAL_ERROR\", \n    \"message\": \"Error description\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "get",
    "url": "/device/:serial/disk",
    "title": "GetDiskInfo",
    "description": "<p>Gets information about the disk usage of an attached device.</p>",
    "group": "Devices",
    "version": "0.1.0",
    "name": "GetDiskInfo",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "serial",
            "description": "<p>Target specific device by its 40-digit device UDID.</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response: ",
          "content": "{\n    \"data\": {\n        \"amountDataAvailable\": 2901368832.0, \n        \"amountDataReserved\": 209715200.0, \n        \"calculateDiskUsage\": \"null\", \n        \"calendarUsage\": 0.0, \n        \"cameraUsage\": 0.0, \n        \"mediaCacheUsage\": 0.0, \n        \"notesUsage\": 0.0, \n        \"photoUsage\": 0.0, \n        \"totalDataAvailable\": 3111084032.0, \n        \"totalDataCapacity\": 13924319232.0, \n        \"totalDiskCapacity\": 15955132416.0, \n        \"totalSystemAvailable\": 272629760.0, \n        \"totalSystemCapacity\": 2030813184.0, \n        \"voicemailUsage\": 0.0, \n        \"webAppCacheUsage\": 0.0\n   }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "/home/henry/Documents/workspace/java-http-libimobiledevice/src/main/java/com/mobilebox/service/IOSService.java",
    "groupTitle": "Devices",
    "error": {
      "fields": {
        "500": [
          {
            "group": "500",
            "optional": false,
            "field": "InternalError",
            "description": "<p>The action cannot be completed</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "    HTTP/1.1 500 Server Error\n{\n    \"code\": \"INTERNAL_ERROR\", \n    \"message\": \"Error description\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "get",
    "url": "/device/:serial/model",
    "title": "GetModelInfo",
    "description": "<p>Retrieve the model from the target device.</p>",
    "group": "Devices",
    "version": "0.1.0",
    "name": "GetModelInfo",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "serial",
            "description": "<p>Target specific device by its 40-digit device UDID.</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response: ",
          "content": "{\n    \"data\": {\n        \"number\": \"MC769\", \n        \"status\": \"Success\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "/home/henry/Documents/workspace/java-http-libimobiledevice/src/main/java/com/mobilebox/service/IOSService.java",
    "groupTitle": "Devices",
    "error": {
      "fields": {
        "500": [
          {
            "group": "500",
            "optional": false,
            "field": "InternalError",
            "description": "<p>The action cannot be completed</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "    HTTP/1.1 500 Server Error\n{\n    \"code\": \"INTERNAL_ERROR\", \n    \"message\": \"Error description\"\n}",
          "type": "json"
        }
      ]
    }
  }
] });
