package org.example.utils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


import java.io.IOException;
import java.util.logging.Logger;

import static java.lang.String.valueOf;

public class LoggingInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request(); //получаем входящий запрос
        long t1 = System.nanoTime();
        System.out.printf("Sending request %s on %s%n%s%n",
                request.url(), chain.connection(), request.headers());
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        System.out.printf("Received response for %s in %.1fms%n%scode %s%n",
                response.request().url(), (t2 - t1) / 1e6d, response.headers(),response.code());
        return response;
    }
}
