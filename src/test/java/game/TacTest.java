package game;

import game.Tac;
import org.junit.jupiter.api.Test;
import game.Tac;

class TacTest {

    @Test
    void main() {

    }

    @Test
    void Test_print() {
        Tac objtac= new Tac();
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        objtac.print(a);
    }
}