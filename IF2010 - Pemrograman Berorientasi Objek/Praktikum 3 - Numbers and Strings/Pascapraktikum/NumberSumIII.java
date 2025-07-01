public class NumberSumIII {

    public Number[] numberSumIII(Number[] numbers) {
        Number[] result = new Number[numbers.length]; // array keluaran
        int index = 0;
        
        // buat sesuai dengan soal dan gunakan fungsi add, subtract, multiply untuk memudahkan
        boolean[] processed = new boolean[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (!processed[i]) {
            
            Number currentResult = numbers[i];
            boolean plus = true, minus = false, times = false;
            
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j].getClass().equals(numbers[i].getClass()) && !processed[j]) {
                    if (plus) {
                        currentResult = add(currentResult, numbers[j]);
                        plus = false; minus = true;
                    } else if (minus) {
                        currentResult = subtract(currentResult, numbers[j]);
                        minus = false; times = true;
                    } else if (times) {
                        currentResult = multiply(currentResult, numbers[j]);
                        times = false; plus = true;
                    }
                    processed[j] = true;
                }
            }
            
            result[index++] = currentResult;
            }
        }
        
        while (index < numbers.length) {
            result[index++] = null;
        }
        
        return result;
    } 

    private static Number add(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) return a.intValue() + b.intValue();
        if (a instanceof Byte && b instanceof Byte) return (byte) (a.byteValue() + b.byteValue());
        if (a instanceof Double && b instanceof Double) return a.doubleValue() + b.doubleValue();
        if (a instanceof Float && b instanceof Float) return a.floatValue() + b.floatValue();
        if (a instanceof Short && b instanceof Short) return (short) (a.shortValue() + b.shortValue());
        if (a instanceof Long && b instanceof Long) return a.longValue() + b.longValue();
        return null;
    } // lakukan operasi penjumlahan sesuai tipe data

    private static Number subtract(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) return a.intValue() - b.intValue();
        if (a instanceof Byte && b instanceof Byte) return (byte) (a.byteValue() - b.byteValue());
        if (a instanceof Double && b instanceof Double) return a.doubleValue() - b.doubleValue();
        if (a instanceof Float && b instanceof Float) return a.floatValue() - b.floatValue();
        if (a instanceof Short && b instanceof Short) return (short) (a.shortValue() - b.shortValue());
        if (a instanceof Long && b instanceof Long) return a.longValue() - b.longValue();
        return null;
    } // lakukan operasi pengurangan sesuai tipe data
    private static Number multiply(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) return a.intValue() * b.intValue();
        if (a instanceof Byte && b instanceof Byte) return (byte) (a.byteValue() * b.byteValue());
        if (a instanceof Double && b instanceof Double) return a.doubleValue() * b.doubleValue();
        if (a instanceof Float && b instanceof Float) return a.floatValue() * b.floatValue();
        if (a instanceof Short && b instanceof Short) return (short) (a.shortValue() * b.shortValue());
        if (a instanceof Long && b instanceof Long) return a.longValue() * b.longValue();
        return null;
    } // lakukan operasi perkalian sesuai tipe data
}