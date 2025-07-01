public class RequestData {
    private String method;
    private String path;
    private String version;
    private String body;

    public RequestData(String method, String path, String version, String body) {
        this.method = method;
        this.path = path;
        this.version = version;
        this.body = body;
    }

    public void printInfo() {
        System.out.printf("Informasi RequestData:\n");
        System.out.printf("%s %s %s\n", method, path, version);
        System.out.printf("Body: %s\n", body);
    }
}
