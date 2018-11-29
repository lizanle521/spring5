package com.lzl.redis.demo.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.*;

@WebServlet(value = "/servlet",asyncSupported = true)
public class NewServlet extends HttpServlet {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,1000*60L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync(req, res);
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                System.out.println("onComplete");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                System.out.println("onTimeout");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                System.out.println("onerror");
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                System.out.println("onStartAsync");
            }
        });
        executor.submit(new Req(asyncContext));
        System.out.println("----servlet---");
    }


    class Req implements Runnable {
        private AsyncContext asyncContext;
        public Req(AsyncContext asyncContext){
            this.asyncContext = asyncContext;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ServletResponse response = asyncContext.getResponse();
            try {
                PrintWriter writer = response.getWriter();
                writer.print("out");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("run");
            asyncContext.complete();
        }
    }
}
