package com.example.CGI.model.valueobject;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Position implements Serializable {
    private int seatRow;
    private int seatColumn;

    public Position() {}

    public Position(int seatRow, int seatColumn) {
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return seatRow == position.seatRow && seatColumn == position.seatColumn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatRow, seatColumn);
    }
}
