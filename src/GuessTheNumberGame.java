import java.util.Random; //lo usaremos como atributo dentro de una clase para definir nro ganador
import java.util.ArrayList; //luego dentro de la clase donde se usará, se debe especificar tipo de dato entre "<>", si es combinación, se dejan vacíos.
import java.util.Scanner;

public class GuessTheNumberGame {
    private Random random; //atributo 1: util.Random = hacer uso de librería de Java para crear nro. aleatorio - random tiene su propio tipo de dato "Random"
    private int targetNumber;
    public GuessTheNumberGame() {
        this.random = new Random(); //estudiar uso del this - solo para atributos y métodos que estén dentro de una misma clase creada
        this.targetNumber = random.nextInt(1, 101);
    }//debe ser = a random.algo?
    /* buena práctica: generar atributos y sus datos con acceso "private" o "protected"*/
    public int getTargetNumber() {
        return this.targetNumber;
    }

    public static void main(String [] args) {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); // Aquí estamos 'instanciando' la clase, es decir invocándola para poder usarla a ella y sus atributos dentro de este encapsulamiento
        System.out.println("Welcome!");
        System.out.print(getTargetNumber());
    }
    // Escribir en la consola la bienvenida y la solicitud de información
}
