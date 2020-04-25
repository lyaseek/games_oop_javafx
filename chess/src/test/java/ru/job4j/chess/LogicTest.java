package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }
    @Test
    public void whenNoMove(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        boolean rsl = logic.move(Cell.C1, Cell.F4);
        assertThat(rsl,is(false));
    }
    @Test
    public void whenNoFiguresToMove(){
        Logic logic = new Logic();
        logic.add(new PawnBlack(Cell.D2));
        logic.add(new PawnBlack(Cell.E2));
        boolean rsl = logic.move(Cell.F2,Cell.F3);
        assertThat(rsl, is(false));
    }
}