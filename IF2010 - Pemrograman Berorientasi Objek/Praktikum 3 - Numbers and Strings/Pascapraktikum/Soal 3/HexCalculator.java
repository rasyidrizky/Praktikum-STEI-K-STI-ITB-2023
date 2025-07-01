public class HexCalculator {
    public static String toHex(int decimal) {
        return Integer.toHexString(decimal);
    }

    public static int toDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}