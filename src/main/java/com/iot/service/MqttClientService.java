package com.iot.service;

import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MqttClientService {
    private static final String MQTT_USERNAME = "username";
    private static final String MQTT_PASSWORD = "password";
    private IMqttClient mqttClient;

    public void sendMsg(String msg) throws MqttException {
        if(mqttClient == null) {
            mqttClient = new MqttClient("tcp://127.0.0.1:1883", MqttAsyncClient.generateClientId());
            mqttClient.connect(connectOptions());
        }

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(msg.getBytes());
        mqttMessage.setQos(0);
        mqttMessage.setRetained(true);

        mqttClient.publish("hello", mqttMessage);
    }

    private MqttConnectOptions connectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(MQTT_USERNAME);
        options.setPassword(MQTT_PASSWORD.toCharArray());
        options.setAutomaticReconnect(true);
        options.setConnectionTimeout(10);
        return options;
    }
}
