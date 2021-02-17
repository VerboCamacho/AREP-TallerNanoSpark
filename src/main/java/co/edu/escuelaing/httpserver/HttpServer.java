package co.edu.escuelaing.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class HttpServer {

    private Map<String, Handler<String>> handlers = new HashMap<>();

    public HttpServer(){
        super();
    }
    public void registerHandler(Handler<String>h,String prefijo){
        handlers.put(prefijo,h);
    }

    public void startServer() throws IOException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 36000.");
            System.exit(1);
        }
        boolean running=true;
        while (running) {


            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean pathRead=false;
            String path="";
            while ((inputLine = in.readLine()) != null) {
                if(!pathRead){
                    path=inputLine.split(" ")[1];
                    System.out.println("Path leido : "+path);
                    pathRead=true;
                }
                System.out.println("Recibí: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            String prefijo="/Apps";
            String sufix="/hola";
            if(handlers.containsKey(prefijo)){
                out.println(getDefaultOkOutputHeader()+handlers.get(prefijo).Handler(sufix,null,null));
            }else{
                out.println(getDefaultOkOutput());
            }


            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();

    }
    private String getDefaultOkOutputHeader(){
        return "HTTP/1.1 200 OK\r\n"
                +"Content-Type: text/html\r\n"
                +"\r\n";
    }
    private String getDefaultOkOutput(){
        return "HTTP/1.1 200 OK\r\n"
                +"Content-Type: text/html\r\n"
                +"\r\n"
                +"<!DOCTYPE html>\n"
                +"<html>\n"
                +"<head>\n"
                +"<meta charset=\"UTF-8\">"
                +"<title>Title of the document</title>\n"
                +"</head>\n"
                +"<body>\n"
                +"<h1>Mi propio mensaje</h1>\n"
                +"</body>\n"
                +"</html>\n";
    }
    private int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;

    }

}
