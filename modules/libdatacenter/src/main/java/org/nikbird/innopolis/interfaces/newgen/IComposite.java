package org.nikbird.innopolis.interfaces.newgen;

/**
 * Created by nikbird on 25.07.17.
 */

public interface IComposite extends IComponent {
    int getCapacity();
    int getItemCount();
    IComponent getItem(int index);
    IComponent[] getComponents();
    void addItem(IComponent item);
    void removeItem(IComponent item);
}
