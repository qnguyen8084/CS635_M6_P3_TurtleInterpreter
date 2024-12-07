package org.example;

import java.util.List;

public interface MementoCollector {
    void addMemento(TurtleMemento memento);
    List<TurtleMemento> getMementos();
}