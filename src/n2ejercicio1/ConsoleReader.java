package n2ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    private static Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) {
        while(true) {
            try {
                System.out.println(message);
                byte varByte = sc.nextByte();
                return varByte;
            } catch(InputMismatchException e) {
                System.out.println("Formato incorrecto: solo números, no-decimales, capacidad: 1 byte");
            } finally {
                sc.nextLine();
            }
        }
    }

    public static int readInt(String message) {
        while(true) {
            try {
                System.out.println(message);
                int varInt = sc.nextInt();
                return varInt;
            } catch(InputMismatchException e) {
                System.out.println("Formato incorrecto: solo números, no-decimales, capacidad: 4 byte");
            } finally  {
                sc.nextLine();
            }
        }
    }

    public static float readFloat(String message) {
        while(true) {
            try {
                System.out.println(message);
                float varFloat = sc.nextFloat();
                return varFloat;
            } catch(InputMismatchException e) {
                System.out.println("Formato incorrecto: solo números, si-decimales, capacidad: 4 bytes");
            } finally {
                sc.nextLine();
            }
        }
    }

    public static double readDouble(String message) {
        while(true) {
            try {
                System.out.println(message);
                double varDouble = sc.nextDouble();
                return varDouble;
            } catch(InputMismatchException e) {
                System.out.println("Formato incorrecto: solo números, si-decimales, capacidad: 8 bytes");
            } finally {
                sc.nextLine();
            }
        }
    }

    public static char readChar(String message) {
        while(true) {
            try {
                System.out.println(message);
                String varString = sc.nextLine();
                if(varString.length() != 1) {
                    throw new InputCustomException("Error: introducir solo un carácter");
                }
                return varString.charAt(0);
            } catch(InputCustomException e) {
                System.out.println(e);
            }
        }
    }

    public static String readString(String message) {
        while(true) {
            try {
                System.out.println(message);
                String varString = sc.nextLine();
                if(varString.length() < 3 || varString.length() > 15) {
                    throw new InputCustomException("Error: mínimo 3 carácteres y máximo 15 carácteres");
                }
                return varString;
            } catch(InputCustomException e) {
                System.out.println(e);
            }
        }
    }

    public static boolean readYesNo(String message) {
        while(true) {
            try {
                System.out.println(message);
                String varString = sc.nextLine();

                if(varString.equals("y")) return true;
                if(varString.equals("n")) return false;
                throw new InputCustomException("Error: solo carácteres 'y' o 'n'");
            } catch(InputCustomException e) {
                System.out.println(e);
            }
        }
    }

}