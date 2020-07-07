package com.lzl.webflux.handler;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;

/**
 * @author lizanle
 * @data 2020/7/6 10:43 PM
 */
@Component
public class FileDownLoadHandler {
    public Mono<ServerResponse> downLoad(ServerRequest request)
            {
        Resource resource = new ClassPathResource("test.txt");

         return ServerResponse.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.txt")
                 .contentType(MediaType.TEXT_PLAIN)
                 .body((p,a)->{
                     ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) p;
                     File file = null;
                     try {
                         file = resource.getFile();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     return zeroCopyResponse.writeWith(file,0,file.length());
                 });
    }
}
