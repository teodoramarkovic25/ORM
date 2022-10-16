package dao;

import java.util.List;

public interface Dao <E>{
    public List<E> readElements();
    public void writeElements(List<E> elements);
}
