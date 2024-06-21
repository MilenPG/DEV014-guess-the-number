import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

class GuessTheNumberGameTest {

    @Test
    @DisplayName("Testing checkGuess() type return")
    void checkGuessType() {
/*
        Pasos a seguir:
        * Asegurar q target num sea 40
        * Asegurar q computerPlayer.computerGuess sea 40 (mock)
        * Una vez lo anterior esté asegurado, hacer assert para confirmar que checkGuess retorne true.
        * Mock de random nos sirve para paso 1 y 2?
*/
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); //instanciar clase
        Player mockedComputerPlayer = Mockito.mock(ComputerPlayer.class);
        //MockedStatic<Random> mockedRandom = mockStatic(Random.class); // ---> No prosperó esta idea de test original de hacer mock de random.class
        Mockito.when(mockedComputerPlayer.makeGuess())
                .thenReturn(40); //
        //Assertions.assertEquals(40, mockedComputerPlayer.makeGuess(), "Should return 40"); //Probando que mock efectivamente esté retornando 40
        //System.out.println(mockedComputerPlayer.makeGuess()); // Hay manera de poder imprimir en consola fuera de un método main? como lo que quise hacer en esta línea.
        assertInstanceOf(Boolean.class, guessTheNumberGame.checkGuess(mockedComputerPlayer, 40), "Should return a boolean");


    }

    @Test
    @DisplayName("Testing checkGuess() return when params have same value")
    void checkGuessTrue() {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame();
        HumanPlayer mockedHumanPlayer = Mockito.mock(HumanPlayer.class);
        Mockito.when(mockedHumanPlayer.makeGuess())
                .thenReturn(8);
        assertTrue(guessTheNumberGame.checkGuess(mockedHumanPlayer, 8)); //"Should return true if player's guess is 40 and target number is 40");

    }
}