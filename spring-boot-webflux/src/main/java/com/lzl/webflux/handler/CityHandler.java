package com.lzl.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author lizanle
 * @data 2019/1/14 下午2:54
 */
@Component
public class CityHandler {

    public Mono<ServerResponse> helloCity(ServerRequest serverRequest)
    {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello city"));
    }
}
