public class JSONHandler implements IHandler {
    public void writeRequest(RequestData data) {
        System.out.println("Writing request in JSON format:");
        data.printInfo();
    }

    public void readRequest(RequestData data) {
        System.out.println("Reading request in JSON format:");
        data.printInfo();
    }
}
