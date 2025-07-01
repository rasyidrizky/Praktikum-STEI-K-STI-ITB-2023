public class Request {
    protected RequestData requestData;

    public Request(RequestData requestData) {
        this.requestData = requestData;
    }

    public void sendRequest(String url) {
        System.out.printf("Creating request with data:\n");
        requestData.printInfo();

        System.out.printf("Formatting request data to XML\n");
        IHandler handler = new XMLHandler();
        handler.writeRequest(requestData);

        System.out.printf("Sending request to %s\n", url);
    }

    public void readRequest(String url) {
        System.out.printf("Receiving request from %s\n", url);

        System.out.printf("Parsing request data from XML\n");
        IHandler handler = new XMLHandler();
        handler.readRequest(requestData);

        System.out.printf("Request parsed successfully with data:\n");
        requestData.printInfo();
    }
}
