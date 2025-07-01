public class RequestV2 extends Request {
    /*
     * Konstruktor RequestV2 yang menerima parameter requestData
     * Sesuaikan dengan kebutuhan
     */
    public RequestV2(RequestData requestData) {
        super(requestData);
    }

    /*
     * Mengoverride method sendRequest yang ada di class Request dengan menggunakan JSONHandler
     * Lakukan hal yang sama dengan pola pada method sendRequest di class Request
     */
    public void sendRequest(String url) {
        System.out.printf("Creating request with data:\n");
        requestData.printInfo();

        System.out.printf("Formatting request data to JSON\n");
        IHandler handler = new JSONHandler();
        handler.writeRequest(requestData);

        System.out.printf("Sending request to %s\n", url);
    }

    /*
     * Mengoverride method readRequest yang ada di class Request dengan menggunakan JSONHandler
     * Lakukan hal yang sama dengan pola pada method readRequest di class Request
     */
    public void readRequest(String url) {
        System.out.printf("Receiving request from %s\n", url);

        System.out.printf("Parsing request data from JSON\n");
        IHandler handler = new JSONHandler();
        handler.readRequest(requestData);

        System.out.printf("Request parsed successfully with data:\n");
        requestData.printInfo();
    }
}
