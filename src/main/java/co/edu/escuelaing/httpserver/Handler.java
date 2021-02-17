package co.edu.escuelaing.httpserver;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface Handler<T> {
    public T Handler (String path, HttpRequest req, HttpResponse res);

}
