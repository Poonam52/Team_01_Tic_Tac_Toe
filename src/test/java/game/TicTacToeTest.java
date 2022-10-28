package game;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeAll
    public static void setupAll(){
        System.out.println("Should Print Before All TicTacToeTest Tests");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Instantiating TicTacToeTest");
        ticTacToe = new TicTacToe();
    }
    //@Mock
    @Test
    @DisplayName("Should Get Model")
     void shouldGetModel() {
        Model model;
        model = ticTacToe.getModel();
        assertAll("Model",
                ()-> assertNotNull(model.gameIsOver(),
                        model.gameIsOver() +"False -> Game is continue / True -> Game Over"),
                ()-> assertNotNull(model.getWinnerCalled(),
                        "Winner Called not null"),
                ()-> assertNotNull(model.getWinner(),
                        "Winner not null")
                );
        assertFalse(model.gameIsOver(),"Game is continue");
    }

    @Test
    void shouldReset() {
        ticTacToe.reset();
    }

    @Test
    void shouldMain() {
        assertNotNull(ticTacToe,"Not null Constructor");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each TicTacToeTest Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the TicTacToeTest");
    }
}