public class XMLHandler implements IHandler {
    public void writeRequest(RequestData data) {
        System.out.println("Writing request in XML format:");
        data.printInfo();
    }

    public void readRequest(RequestData data) {
        System.out.println("Reading request in XML format:");
        data.printInfo();
    }
}
