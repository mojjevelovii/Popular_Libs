package ru.shumilova.popular_libs.task2;

public interface Observable {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyAllObservers();

    void spam();
}
