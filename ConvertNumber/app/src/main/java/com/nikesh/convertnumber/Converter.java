package com.nikesh.convertnumber;

public class Converter {


    static String one[] = {"", "one ", "two ", "three ", "four ",
            "five ", "six ", "seven ", "eight ",
            "nine ", "ten ", "eleven ", "twelve ",
            "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ",
            "nineteen "
    };


    static String ten[] = {"", "", "twenty ", "thirty ", "forty ",
            "fifty ", "sixty ", "seventy ", "eighty ",
            "ninety "
    };

    //1- or 2-digit number
    static String numToWords(int n, String s) {
        String str = "";
        // if n is more than 19, divide it
        if (n > 19) {
            str += ten[n / 10] + one[n % 10];
        } else {
            str += one[n];
        }

        // if n is non-zero
        if (n != 0) {
            str += s;
        }

        return str;
    }

    // Function to print a given number in words
    public String convertToWords(long n) {


        String out = "";

        if (n == 0) {
            out += "zero";
        }

        // hundred place
        out += numToWords((int) ((n / 100) % 10), "hundred ");

        if (n > 100 && n % 100 > 0) {
            out += "and ";
        }

        // handles digits at ones and tens places (if any)
        out += numToWords((int) (n % 100), "");

        return out;
    }

}
