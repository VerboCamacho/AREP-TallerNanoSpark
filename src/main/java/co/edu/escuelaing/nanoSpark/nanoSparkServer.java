package co.edu.escuelaing.nanoSpark;

import co.edu.escuelaing.httpserver.Handler;
import co.edu.escuelaing.httpserver.HttpRequest;
import co.edu.escuelaing.httpserver.HttpResponse;
import co.edu.escuelaing.httpserver.HttpServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class nanoSparkServer implements Handler {
    private static nanoSparkServer _theInstance;

    static {
        _theInstance = new nanoSparkServer();
    }

    private HttpServer hserver=new HttpServer();
    public void startServer() {
        try{
            hserver.startServer();
        }
        catch (IOException ex){
            Logger.getLogger(nanoSparkServer.class.getName());
        }

    }

    public static nanoSparkServer getInstance(){
        return _theInstance;
    }
    private Map<String, BiFunction<HttpRequest, HttpResponse, String>> bodyMap = new HashMap();
    private nanoSparkServer()  {
        hserver.registerHandler(this,"/Apps");
        //hserver.startServer();

    }

    public void get(String path,  BiFunction<HttpRequest, HttpResponse, String>bifunction){
        bodyMap.put(path,bifunction);
    }
    public String getValue(String path,HttpRequest req,HttpResponse res){
        return bodyMap.get(path).apply(req,res);
    }

    @Override
    public Object Handler(String path,HttpRequest req,HttpResponse res) {
        return getValue(path,req,res);
    }

}
