package com.zero.spring.mobile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/mobile")
public class SpringMobileController {

    @GetMapping("/greeting")
    public String greeting(Device device) {

        String deviceType = "browser";
        String platform = "browser";
        String viewName = "index";

        if (device.isNormal()) {
            deviceType = "browser";
        } else if (device.isMobile()) {
            deviceType = "mobile";
            viewName = "mobile/index";
        } else if (device.isTablet()) {
            deviceType = "tablet";
            viewName = "tablet/index";
        }

        platform = device.getDevicePlatform().name();

        if (platform.equalsIgnoreCase("UNKNOWN")) {
            platform = "browser";
        }

        log.info("Client Device Type: {}, Platform: {}", deviceType, platform);

        return viewName;
    }

}
