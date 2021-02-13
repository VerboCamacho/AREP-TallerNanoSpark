package co.edu.escuelaing.nanoSpark.demo;
import static co.edu.escuelaing.nanoSpark.NanoSpark.*;

public class NanoSparkWebDemo {
        public static void main(String[]args){
            get("/hello","<!DOCTYPE html>\n"
                    +"<html>\n"
                    +"<head>\n"
                    +"<meta charset=\"UTF-8\">"
                    +"<title>Title of the document</title>\n"
                    +"</head>\n"
                    +"<body>\n"
                    +"<h1>Mi propio mensaje</h1>\n"
                    +"</body>\n"
                    +"</html>\n");
        }
}
