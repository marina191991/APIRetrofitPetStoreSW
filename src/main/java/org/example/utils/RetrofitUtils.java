package org.example.utils;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class RetrofitUtils {
    static Properties prop = new Properties();
    private static InputStream configFile;

    static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    static {
        try {
            configFile = new FileInputStream("src/test/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static String getBaseUrl() {
        prop.load(configFile);
        return prop.getProperty("url");
    }


    public static Retrofit getRetrofit() {
        logging.setLevel(BODY);
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create()) //указывает через какую библиотеку реализуется сериализацияб,десериализация
                .client(httpClient.build())
                .build();
    }
}
