package co.edu.escuelaing.nanoSpark;

public class NanoSpark {
    public static void get(String path,String body){
        nanoSparkServer nanosvr=nanoSparkServer.getInstance();
        nanosvr.get(path, body);

    }
}
