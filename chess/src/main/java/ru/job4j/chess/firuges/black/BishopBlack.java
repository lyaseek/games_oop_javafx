package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[size];
        int deltaX;
        int deltaY;
        if (dest.y > source.y) {
            deltaY = 1;
        } else {
            deltaY = -1;
        }
        if (dest.x > source.x) {
            deltaX = 1;
        } else {
            deltaX = -1;
        }
        int x = source.x;
        int y = source.y;
        for (int index = 0; index < size; index++) {
            x = x + deltaX;
            y = y + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {

        return Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
