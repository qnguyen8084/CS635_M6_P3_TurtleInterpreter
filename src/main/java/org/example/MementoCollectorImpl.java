package org.example;

import java.util.ArrayList;
import java.util.List;

public class MementoCollectorImpl implements MementoCollector {
    private final List<TurtleMemento> mementos = new ArrayList<>();

    @Override
    public void addMemento(TurtleMemento memento) {
        mementos.add(memento);
    }

    @Override
    public List<TurtleMemento> getMementos() {
        return mementos;
    }
}