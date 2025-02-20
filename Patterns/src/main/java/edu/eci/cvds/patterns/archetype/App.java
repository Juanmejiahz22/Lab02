package edu.eci.cvds.patterns.archetype;

public class App {
    public static void main(String[] args) {
        System.out.println("Argumento recibido: " + args[0]);

        if (args.length == 1) {
            // Si se pasa un solo argumento juntos
            String[] fullName = args[0].split(" ");
            if (fullName.length == 2) {
                String firstName = fullName[0];
                String lastName = fullName[1];
                System.out.println("¡Hola " + firstName + " " + lastName + "!");
            } else {
                System.out.println("Ingresar nombre y apellido.");
            }
        } else {
            System.out.println("Ingresar nombre y apellido.");
        }
    }
}

