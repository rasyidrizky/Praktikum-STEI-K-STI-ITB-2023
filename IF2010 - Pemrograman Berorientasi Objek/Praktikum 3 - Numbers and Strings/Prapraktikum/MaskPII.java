public class MaskPII {
    private String maskEmail(String email) {        
        email = email.toLowerCase();
        int index = email.indexOf('@');

        String name = email.substring(0, index);
        String domain = email.substring(index);
        
        String maskedName = name.charAt(0) + "*****" + name.charAt(name.length() - 1);
        
        return maskedName + domain;
    }

    private String maskPhoneNumber(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
        String localNumber = digitsOnly.substring(digitsOnly.length() - 4);
        String countryCode = digitsOnly.substring(0, digitsOnly.length() - 10);
        String maskedCountry;

        if (countryCode.length() == 0) {
            maskedCountry = "";
        }
        else if (countryCode.length() == 1) {
            maskedCountry = "+*-";
        }
        else if (countryCode.length() == 2) {
            maskedCountry = "+**-";
        }
        else {
            maskedCountry = "+***-";
        }

        return maskedCountry + "***-***-" + localNumber;
    }

    public String maskPII(String pii) {
        // dilakukan pengecekan String pii
        // jika pii merupakan email, panggil method maskEmail
        // jika pii merupakan phone number, panggil method maskPhoneNumber
        if (pii.contains("@")) {
            return maskEmail(pii);
        } else {
            return maskPhoneNumber(pii);
        }
    }
}