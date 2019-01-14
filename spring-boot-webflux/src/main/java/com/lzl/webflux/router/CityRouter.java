package com.lzl.webflux.router;

import com.lzl.webflux.handler.CityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author lizanle
 * @data 2019/1/14 下午2:58
 */
@Configuration
public class CityRouter {

    private Object object;

    @Bean
    public RouterFunction<ServerResponse> routerCity(CityHandler cityHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),cityHandler::helloCity);
    }

}
