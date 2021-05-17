package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

    public static final int CODE_STATUS_1 = -1;
    public static final int CODE_STATUS_2 = -2;
    public static final int CODE_STATUS_3 = -3;
    public static final int CODE_STATUS_4 = -4;

    public static final Logger logger = Logger.getLogger("MyLogger");

    static {
        try {
            FileHandler fileHandler = new FileHandler("App.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int divide() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter first number: ");
            int firstNumber = Integer.parseInt(bufferedReader.readLine());
            logger.log(Level.INFO, "First Number: " + firstNumber);
            Thread.sleep(100); // Added delay so that message below was printed after log above in the console
            System.out.print("Enter second number: ");
            int secondNumber = Integer.parseInt(bufferedReader.readLine());
            logger.log(Level.INFO, "Second Number: " + secondNumber);
            Thread.sleep(100); // Added delay so that message below was printed after log above in the console
            return firstNumber / secondNumber;

        } catch (IOException e) {
//            logger.log(Level.SEVERE, e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), e);
            return CODE_STATUS_1;
        } catch (ArithmeticException e) {
//            logger.log(Level.SEVERE, e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), e);
            return CODE_STATUS_2;
        } catch (NumberFormatException e) {
//            logger.log(Level.SEVERE, e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), e);
            return CODE_STATUS_3;
        } catch (Exception e) {
//            logger.log(Level.SEVERE, e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), e);
            return CODE_STATUS_4;
        }
    }

    public static void main( String[] args ) {

        System.out.println(divide());
    }
}
