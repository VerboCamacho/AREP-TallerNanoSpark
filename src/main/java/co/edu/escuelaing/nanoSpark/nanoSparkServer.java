package co.edu.escuelaing.nanoSpark;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class nanoSparkServer {
    private static nanoSparkServer _theInstance;

    static {
        try {
            _theInstance = new nanoSparkServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private HttpServer hserver=new HttpServer();

    public static nanoSparkServer getInstance(){
        return _theInstance;
    }
    private Map<String,String>bodyMap = new HashMap();
    private nanoSparkServer() throws IOException {
        try {
            hserver.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    public void get(String path,String body){
        bodyMap.put(path,body);
    }
    public String getValue(String path){
        return bodyMap.get(path);
    }
}
