package co.edu.escuelaing.nanoSpark;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;

public class NanoSpark {
    public static void get(String path, BiFunction<HttpRequest, HttpResponse, String> bifunction){
        nanoSparkServer nanosvr=nanoSparkServer.getInstance();
        nanosvr.get(path, bifunction);
    }
    public static void startServer(){
        nanoSparkServer nanosvr=nanoSparkServer.getInstance();
        nanosvr.startServer();
    }
}
