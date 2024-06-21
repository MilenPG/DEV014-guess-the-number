import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerPlayerTest {

    @Test
    @DisplayName("Int range generated for computer's guess")
    void makeGuess() {
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", new ArrayList<>());
        assertTrue(computerPlayer.makeGuess()>=0 && computerPlayer.makeGuess()<=100, "Should be true that the makeGuess() return is a int between 0 and 100");
    }
}