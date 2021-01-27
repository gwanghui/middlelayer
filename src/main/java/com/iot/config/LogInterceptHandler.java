package com.iot.config;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.*;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class LogInterceptHandler extends AbstractInterceptHandler {

    @Override
    public String getID() {
        return "LogInterceptHandler";
    }

    @Override
    public void onConnect(InterceptConnectMessage interceptConnectMessage) {

    }

    @Override
    public void onDisconnect(InterceptDisconnectMessage interceptDisconnectMessage) {

    }

    @Override
    public void onConnectionLost(InterceptConnectionLostMessage interceptConnectionLostMessage) {
        System.out.println(interceptConnectionLostMessage);
    }

    @Override
    public void onPublish(InterceptPublishMessage interceptPublishMessage) {
        System.out.println(interceptPublishMessage.getTopicName());
        System.out.println(interceptPublishMessage.getClientID());
        System.out.println(interceptPublishMessage.getUsername());
        ByteBuf byteBuf = interceptPublishMessage.getPayload();
        System.out.println(byteBuf.readCharSequence(byteBuf.readableBytes(), Charset.forName("utf-8")).toString());
    }

    @Override
    public void onSubscribe(InterceptSubscribeMessage interceptSubscribeMessage) {
        System.out.println(interceptSubscribeMessage);
    }

    @Override
    public void onUnsubscribe(InterceptUnsubscribeMessage interceptUnsubscribeMessage) {
        System.out.println(interceptUnsubscribeMessage);
    }

    @Override
    public void onMessageAcknowledged(InterceptAcknowledgedMessage interceptAcknowledgedMessage) {
        System.out.println(interceptAcknowledgedMessage.getMsg());
    }
}
