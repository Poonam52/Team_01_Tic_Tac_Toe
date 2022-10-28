package game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SquareTest extends Square{

    static Location location = new Location(1, 1);
    static TicTacToe ticTacToe = new TicTacToe();

    static{
        ticTacToe.getModel().select(location);
    }

    public SquareTest() {
        super(ticTacToe, location);
    }
    @Test
    void testPaintComponent() {
        Graphics g = Mockito.mock(Graphics.class);
        Graphics scratchGraphics = Mockito.mock(Graphics.class);
        Mockito.when(g.create()).thenReturn(scratchGraphics);
        Font font = new Font(null, 0, 10);
        Mockito.when(g.getFont()).thenReturn(font);
        Mockito.doNothing().when(scratchGraphics).dispose();

        paintComponent(g);
        this.doClick();
        System.out.println("Move selected: "+getText());
        assertThat(getText(), anyOf(is("X"), is("O")));
    }

}
