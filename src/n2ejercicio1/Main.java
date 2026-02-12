package n2ejercicio1;

public class Main {
    public static void main(String[] args) {

        byte varByte = ConsoleReader.readByte("Introducir edad: ");
        int varInt = ConsoleReader.readInt("Introducir décimo lotería navidad: ");
        float varFloat = ConsoleReader.readFloat("Introducir precio: ");
        double varDouble = ConsoleReader.readDouble("Introducir valor de PI: ");

        //NOTA: los métodos aceptan números como String, no hay verífica de solo carácteres.
        char varChar = ConsoleReader.readChar("Introducir inicial de tu nombre: ");
        String varString = ConsoleReader.readString("Introducir apellido: ");
        boolean YesNo = ConsoleReader.readYesNo("Te gustó la comida? (y/n)");

        System.out.println(varByte + ", " + varInt + ", " + varFloat + ", " + varDouble);
        System.out.println(varChar + ", " + varString + ", " + YesNo);
    }
}
