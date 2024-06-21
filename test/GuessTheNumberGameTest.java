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
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); //instanciar clase
        Player mockedComputerPlayer = Mockito.mock(ComputerPlayer.class);
        Mockito.when(mockedComputerPlayer.makeGuess())
                .thenReturn(40); //
        assertInstanceOf(Boolean.class, guessTheNumberGame.checkGuess(mockedComputerPlayer, 40), "Should return a boolean");
    }

    @Test
    @DisplayName("Testing checkGuess() return when params have same value")
    void checkGuessTrue() {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame();
        HumanPlayer mockedHumanPlayer = Mockito.mock(HumanPlayer.class);
        mockedHumanPlayer.lastGuess = 40;
        assertTrue(guessTheNumberGame.checkGuess(mockedHumanPlayer, 40), "Should return true if player's guess is 40 and target number is 40");
    }

    @Test
    @DisplayName("Testing checkGuess() return when params have different values")
    void checkGuessFalse() {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame();
        HumanPlayer mockedHumanPlayer = Mockito.mock(HumanPlayer.class);
        Mockito.when(mockedHumanPlayer.makeGuess())
                .thenReturn(8);
        assertFalse(guessTheNumberGame.checkGuess(mockedHumanPlayer, 10), "Should return false if player's guess is 8 and target number is 10");

    }
}