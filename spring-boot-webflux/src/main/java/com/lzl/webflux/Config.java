package com.lzl.webflux;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.handler.traffic.TrafficCounter;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author lizanle
 * @data 2020/7/6 9:30 PM
 */
@Configuration
public class Config {
    static {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    TrafficCounter trafficCounter = trafficHandler.trafficCounter();
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final long totalRead = trafficCounter.cumulativeReadBytes();
                    final long totalWrite = trafficCounter.cumulativeWrittenBytes();
                    System.out.println("total read: " + (totalRead ) + " B");
                    System.out.println("total write: " + (totalWrite ) + " B");
                    System.out.println("流量监控: " + System.lineSeparator() + trafficCounter);
                }
            }
        }).start();
    }
    private static final EventExecutorGroup EXECUTOR_GROUOP =
            new DefaultEventExecutorGroup(Runtime.getRuntime().availableProcessors() * 2);

    private static final GlobalTrafficShapingHandler trafficHandler =
            new GlobalTrafficShapingHandler(EXECUTOR_GROUOP, 1, 1);

    @Bean
    public NettyReactiveWebServerFactory nettyReactiveWebServerFactory(){
        NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
        factory.addServerCustomizers(server->server.afterNettyContextInit(nettyContext ->
            nettyContext.addHandlerLast(trafficHandler)
        ));
        return factory;
    }

    @Bean
    public ChannelInitializer channelInitializer(){
        return new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(trafficHandler);
            }
        };
    }
}
