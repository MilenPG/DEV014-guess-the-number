import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class GuessTheNumberGameTest {

    @Test
    void checkGuess() {

        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); //instanciar clase
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", new ArrayList<>());
        MockedStatic<Random> mockedRandom = mockStatic(Random.class);
        Mockito.when(guessTheNumberGame.getTargetNumber())
                .thenReturn(40);
        Mockito.when(computerPlayer.makeGuess())
                .thenReturn(40);

        Assertions.assertEquals(true, guessTheNumberGame.checkGuess(computerPlayer));
        /*
        Pasos a seguir:
        * Asegurar q target num sea 20
        * Asegurar q computerPlayer.computerGuess sea 20
        * Una vez lo anterior esté asegurado, hacer assert para confirmar que checkGuess retorne true.
        * Mock de random nos sirve para paso 1 y 2.
        * */

    }

    @Test
    void clueMessage() {
    }
}