public class Password {
    private String password;

    /**
     * Constructor untuk Password
     * @param password string password
     */
    public Password(String password) {
        this.password = password;
    }

    /**
     * Memeriksa apakah password memiliki minimal satu huruf kapital
     * @return true jika valid, false jika tidak
     */
    private boolean hasUpperCase() {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    /**
     * Memeriksa apakah password memiliki minimal satu angka
     * @return true jika valid, false jika tidak
     */
    private boolean hasNumber() {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    /**
     * Memeriksa apakah password memiliki minimal satu karakter khusus sebagai berikut: !@#$%^&*(),./
     * @return true jika valid, false jika tidak
     */
    private boolean hasSpecialChar() {
        String specialChars = "!@#$%^&*(),./";
        for (char c : password.toCharArray()) {
            if (specialChars.indexOf(c) != -1) return true;
        }
        return false;
    }

    /**
     * Validasi password dengan aturan:
     * 1. Password harus memiliki panjang minimal 12 karakter
     * 2. Password harus mengandung minimal satu huruf kapital
     * 3. Password harus mengandung minimal satu angka
     * 4. Password harus mengandung minimal satu karakter khusus
     * 
     * @return true jika password valid
     * @throws InvalidLengthException jika panjang password kurang dari 12
     * @throws InvalidPasswordException jika password tidak memenuhi salah satu kriteria lainnya
     */
    public boolean validate() throws InvalidLengthException, InvalidPasswordException {
        if (password.length() < 12) {
            throw new InvalidLengthException("Password harus memiliki panjang minimal 12 karakter");
        }
        if (!hasUpperCase()) {
            throw new InvalidPasswordException("Password harus mengandung minimal satu huruf kapital");
        }
        if (!hasNumber()) {
            throw new InvalidPasswordException("Password harus mengandung minimal satu angka");
        }
        if (!hasSpecialChar()) {
            throw new InvalidPasswordException("Password harus mengandung minimal satu karakter khusus");
        }
        return true;
    }
}

/**
 * Exception untuk password yang tidak valid
 */
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

/**
 * Exception untuk panjang password yang tidak valid
 */
class InvalidLengthException extends Exception {
    public InvalidLengthException(String message) {
        super(message);
    }
}