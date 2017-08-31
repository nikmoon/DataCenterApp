package org.nikbird.innopolis.libdatacenter.interfaces;

/**
 * Created by nikbird on 31/08/2017.
 */

public interface IComponent {

    enum State {
        GOOD,
        FAIL
    }

    interface Info {
        String getName();
        int getIndex();
        State getState();
        Info getContainerInfo();
        Info getComponentInfo(int index);
    }

    Info getInfo();
    IComponent getContainer();
    IComponent getComponent(int index);

    void setName(String name);
    void setIndex(int index);
    void setState(State state);
    void setContainer(IComponent container);
    void setComponent(IComponent component, int index);
}
