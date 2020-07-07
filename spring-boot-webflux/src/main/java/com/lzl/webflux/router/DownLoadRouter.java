package com.lzl.webflux.router;

import com.lzl.webflux.handler.CityHandler;
import com.lzl.webflux.handler.FileDownLoadHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.reactive.result.view.RequestContext;
import reactor.core.publisher.Mono;

/**
 * @author lizanle
 * @data 2020/7/6 10:47 PM
 */
@Configuration
public class DownLoadRouter {
    @Autowired
    private FileDownLoadHandler fileDownLoadHandler;
    @Bean
    public RouterFunction<ServerResponse> route(FileDownLoadHandler fileDownLoadHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/img")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        serverRequest -> fileDownLoadHandler.downLoad(serverRequest));
    }
}
