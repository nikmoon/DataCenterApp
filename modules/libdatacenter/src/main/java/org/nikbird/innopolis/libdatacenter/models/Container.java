package org.nikbird.innopolis.libdatacenter.models;

import org.nikbird.innopolis.libdatacenter.interfaces.IComponent;

/**
 * Created by nikbird on 31/08/2017.
 */

public class Container extends AbstractComponent {

    private IComponent[] mComponents;
    private Info mInfo = new ContainerInfo();

    @Override
    public Info getInfo() {
        return mInfo;
    }

    @Override
    public IComponent getComponent(int index) {
        return mComponents[index];
    }

    @Override
    public void setState(State state) {
    }

    @Override
    public void setComponent(IComponent component, int index) {
        mComponents[index] = component;
    }

    private class ContainerInfo extends AbstractInfo {
        @Override
        public State getState() {
            return null;
        }

        @Override
        public Info getComponentInfo(int index) {
            return mComponents[index].getInfo();
        }
    }
}
