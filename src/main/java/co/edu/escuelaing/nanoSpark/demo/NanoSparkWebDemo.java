package co.edu.escuelaing.nanoSpark.demo;
import static co.edu.escuelaing.nanoSpark.NanoSpark.*;
/*
autor Daniel Benavides clase 3 de febrero AREP 2021-1
 */
public class NanoSparkWebDemo {
        public static void main(String[]args){
            get("/hola",(req,res)->"<!DOCTYPE html>\n"
                    +"<html>\n"
                    +"<head>\n"
                    +"<meta charset=\"UTF-8\">"
                    +"<title>Title of the document</title>\n"
                    +"</head>\n"
                    +"<body>\n"
                    +"<h1>get from nanoSpark using Lambda</h1>\n"
                    +"</body>\n"
                    +"</html>\n");
            startServer();
        }

}
