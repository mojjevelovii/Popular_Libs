package ru.shumilova.popular_libs.task2;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {
    List<Observer> subscribers = new ArrayList<>();
    int count;

    @Override
    public void spam() {
        count++;
        notifyAllObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : subscribers) {
            observer.updateData(observer.toString(), count);
        }
    }
}
