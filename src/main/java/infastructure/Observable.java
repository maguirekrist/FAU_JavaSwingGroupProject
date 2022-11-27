package infastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Observable {

    transient ArrayList<Observer> observerList;

    public Observable()
    {
        observerList = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    public void notifyObservers() {
        for(Observer o : this.observerList)
        {
            o.update(this);
        }
    }

}
