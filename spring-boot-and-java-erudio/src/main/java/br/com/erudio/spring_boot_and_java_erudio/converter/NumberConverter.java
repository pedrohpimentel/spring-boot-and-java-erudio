package br.com.erudio.spring_boot_and_java_erudio.converter;

import br.com.erudio.spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace("," , "."); // R$ 50,00 -> U$D 50.00
        return Double.parseDouble(number);
    }

    private static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace("," , "."); // R$ 50,00 -> U$D 50.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
