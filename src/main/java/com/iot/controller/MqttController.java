package com.iot.controller;

import com.iot.service.MqttClientService;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MqttController {
    private final MqttClientService mqttClientService;

    @GetMapping(value = "/mqtttest")
    public String sendMessage() throws MqttException {
        mqttClientService.sendMsg("설날입니다.");
        return "hello";
    }
}
