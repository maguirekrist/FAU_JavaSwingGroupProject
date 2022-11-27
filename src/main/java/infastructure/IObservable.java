package infastructure;

public interface IObservable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
