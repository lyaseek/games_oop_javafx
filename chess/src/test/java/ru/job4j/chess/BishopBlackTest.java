package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        assertThat(Cell.C1, is(new BishopBlack(Cell.C1).position()));
    }

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        assertThat(Cell.D2, is(bishopBlack.copy(Cell.D2).position()));
    }

    @Test
    public void wayTest() {
        assertThat(new BishopBlack(Cell.A7).way(Cell.A7, Cell.G1), is(new Cell[]{Cell.B6, Cell.C5, Cell.D4, Cell.E3, Cell.F2, Cell.G1}));

    }

    @Test(expected = IllegalStateException.class)
    public void whenIsNotDiagonal() {
        new BishopBlack(Cell.D4).way(Cell.D4, Cell.A2);
    }
}