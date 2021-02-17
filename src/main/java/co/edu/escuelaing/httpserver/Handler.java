package co.edu.escuelaing.httpserver;



public interface Handler<T> {
    public T Handler (String path, HttpRequest req, HttpResponse res);

}
