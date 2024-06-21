import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Integer> guesses;
    protected int lastGuess;

    public Player(String name, ArrayList<Integer> guesses) { //siempre los params de constructor son los attr
        this.name = name; //constructor siempre hará referencia a todos los attr que hayan sido nombrados, para inicializarlos
        this.guesses = guesses;
        this.lastGuess = -1;
    }

    public abstract int makeGuess(); // Dentro no hay niguna lógica, pues esta se desarrollará en las clases hijas. retorna suposicion de jugador. método abstracto
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getGuesses() {
        return guesses;
    }
    public int getLastGuess() {
        return this.lastGuess;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGuesses(ArrayList<Integer> guesses) {
        this.guesses = guesses;
    }
}
