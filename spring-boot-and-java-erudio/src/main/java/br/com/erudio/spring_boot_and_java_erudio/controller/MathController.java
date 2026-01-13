package br.com.erudio.spring_boot_and_java_erudio.controller;

import br.com.erudio.spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtraction (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/mult/3/5
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/div/3/5
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double division (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/ave/3/5
    @RequestMapping("/ave/{numberOne}/{numberTwo}")
    public Double average (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2.0;
    }

    // http://localhost:8080/math/sqr/3/5
    @RequestMapping("/sqr/{numberOne}")
    public Double square (
            @PathVariable("numberOne") String numberOne) throws Exception{

        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(numberOne));
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace("," , "."); // R$ 50,00 -> U$D 50.00
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace("," , "."); // R$ 50,00 -> U$D 50.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}