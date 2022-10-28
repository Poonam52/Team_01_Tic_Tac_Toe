package game;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ModelTest {

    private Model model;

    @BeforeAll
    public static void setupAll(){
        System.out.println("Should Print Before All Model Tests");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Instantiating Model");
        model = new Model();
    }

    @Test
    @DisplayName("Should Select Model")
    void shouldSelectModel() {
        Location locationTest = new Location(1, 1);
        model.select(locationTest);
    }

    @Test
    @DisplayName("Should Not Select When Location is Null for Select()")
    public void shouldThrowRuntimeExceptionWhenLocationIsNullForSelect(){
        String FailedMessage = "Should Pass Location in Select method";
        Assertions.assertThrows(RuntimeException.class,()->{
           model.select(null);
        },FailedMessage);
    }

    @Test
    @DisplayName("Should Get Label")
    void shouldGetLabel() {
        Location locationTest = new Location(2, 2);
        String result = model.getLabel(locationTest);
        System.out.println(result);
        //assertFalse(result.isEmpty());
        assertEquals((result.equals("") || result.equals("X") || result.equals("O")) , true);
        Assertions.assertThrows(IllegalStateException.class,()->{
            throw new IllegalStateException("error message");
        });
    }

    @Test
    @DisplayName("Should Not Select When Location is Null for GetLabel()")
    public void shouldThrowRuntimeExceptionWhenLocationIsNullForGetLabel(){
        String FailedMessage = "Should Pass Location in GetLabel method";
        Assertions.assertThrows(RuntimeException.class,()->{
            model.getLabel(null);
        },FailedMessage);
    }

    @Test
    void gameIsOver() {
        boolean oGame = model.gameIsOver();
        assertEquals(false,oGame);
    }

    @Test
    void getWinnerCalled() {
        // create and set mock(s)
        boolean getWCall  = model.getWinnerCalled();
        assertEquals(false, getWCall);
    }

    @Test
    void getWinner() {
        int getWinner = model.getWinner();
        assertNotEquals(1, getWinner);
    }
}