package generics._09_CustomListIterator;

import generics._09_CustomListIterator.interfaces.CustomList;
import generics._09_CustomListIterator.interfaces.Sorter;

public class SorterImpl<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(CustomList<T> elements) {
        for (int i = 0; i < elements.getSize(); i++) {
            T currentElement = elements.get(i);
            for (int j = i + 1; j < elements.getSize(); j++) {
                if (currentElement.compareTo(elements.get(j)) > 0) {
                    elements.swap(i, j);
                }
            }
        }
    }
}