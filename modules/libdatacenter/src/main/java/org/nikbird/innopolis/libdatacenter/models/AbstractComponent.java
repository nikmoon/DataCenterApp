package org.nikbird.innopolis.libdatacenter.models;

import org.nikbird.innopolis.libdatacenter.interfaces.IComponent;

/**
 * Created by nikbird on 31/08/2017.
 */

public abstract class AbstractComponent implements IComponent {

    private String mName;
    private int mIndex;
    private IComponent mContainer;

    public abstract class AbstractInfo implements IComponent.Info {
        @Override
        public String getName() {
            return mName;
        }

        @Override
        public int getIndex() {
            return mIndex;
        }

        @Override
        public Info getContainerInfo() {
            return mContainer == null ? null : mContainer.getInfo();
        }
    }

    @Override
    public final IComponent getContainer() {
        return mContainer;
    }

    @Override
    public void setContainer(IComponent container) {
        mContainer = container;
    }

    @Override
    public final void setName(String name) {
        mName = name == null ? "" : name;
    }

    @Override
    public final void setIndex(int index) {
        mIndex = index;
    }

    public AbstractComponent() {
        setName(null);
        setIndex(-1);
    }
}
