package com.epam.multi.hw7.battleships.state;

public interface State<T> {
    T getNextState();
}
