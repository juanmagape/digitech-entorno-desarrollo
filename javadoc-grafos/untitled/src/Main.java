import java.util.Scanner;

public class Main {
    /**
     * Creación de variables para el programa.
     * Se crean con static y fuera para no declararlas cada vez que se llama a la función
     */
    static String[] usuario = {"cargol", "Lexico", "hide.afk", "admin"};
    static String[] pass = {"123", "345", "567", "password"};
    static String userLog = "";
    static String userPass = "";
    static boolean userExis = false;
    static boolean passExis = false;
    static int posicion = 0;
    static boolean volverAIntentar = true;

    /**
     * Función principal del programa, donde se inicia.
     * Bucle para seguir el programa en caso de que el usuario falle, y quiera volver a intentar.
     */
    public static void main() {
        Scanner print = new Scanner(System.in);

        System.out.println("=================================================================");
        System.out.println("==================== PRACTICA JAVADOC/GRAFOS ====================");
        System.out.println("=================================================================");

        while(volverAIntentar) {

            userExis = false;
            passExis = false;
            posicion = 0;

            Login(print);
            ValidarUser();

            if (!userExis || !passExis) {
                System.out.println("Quieres volver a intentarlo? - [1 - SI / 2 - NO]");
                try {
                    int valorSeguir = print.nextInt();
                    print.nextLine();
                    if (valorSeguir == 2) {
                        volverAIntentar = false;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    /**
     * Función para recoger los datos para el login del usuario
     * Con scanner se recoge el usuario y la contraseña y se guarda en las variables userLog y userPass
     */
    public static void Login(Scanner print) {
        System.out.println("\nIntroduce el nombre de usuario:");
        userLog = print.nextLine();
        System.out.println("Introduce la contraseña:");
        userPass = print.nextLine();
    }

    /**
     * Función para validar el usuario
     * Bucle para recorrer el array de usuarios, valida que se encuentra el usuario.
     * Cuando es correcto se envia a la función de validar contraseña.
     */
    public static void ValidarUser() {
        for (int i = 0; i < usuario.length; i++) {

            posicion++;

            if (usuario[i].equals(userLog)) {
                userExis = true;
                ValidarPass();
                break;

            }
        }
        if (!userExis) {
            System.out.println("Usuario incorrecto, prueba de nuevo");
        }
    }

    /**
     * Función para validar la contraseña, se revisa la posición donde estaba el usuario
     * En caso de que la contraseña que se encuentra en la misma posición coincida, el booleano pasa a true.
     * Valida si usuario y contraseña existe, en caso de que exista se termina el programa.
     */
    public static void ValidarPass() {
            if (userPass.equals(pass[posicion - 1])) {
                passExis = true;

            } else {
                System.out.println("Contraseña incorrecta, vuelva a intentarlo");
            }

        if (userExis && passExis) {
            System.out.println("Inicio de sesión correcto");
            volverAIntentar = false;
        }
        System.out.println("==================================================================");

    }
}
