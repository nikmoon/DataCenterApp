package org.nikbird.innopolis.libdatacenter.models;

import org.nikbird.innopolis.libdatacenter.interfaces.IComponent;

/**
 * Created by nikbird on 31/08/2017.
 */

public class ServerNew extends AbstractComponent {

    public static final State DEFAULT_STATE = State.GOOD;

    private State mState;
    private Info mInfo = new ServerInfo();

    @Override
    public Info getInfo() {
        return mInfo;
    }

    @Override
    public IComponent getComponent(int index) {
        return null;
    }

    @Override
    public void setComponent(IComponent component, int index) {
    }

    @Override
    public void setState(State state) {
        mState = state;
    }

    public ServerNew() {
        setState(DEFAULT_STATE);
    }

    public ServerNew(State state) {
        setState(state);
    }

    private class ServerInfo extends AbstractInfo {
        @Override
        public State getState() {
            return mState;
        }

        @Override
        public Info getComponentInfo(int index) {
            return null;
        }
    }
}
