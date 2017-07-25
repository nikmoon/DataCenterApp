package org.nikbird.innopolis.models.newgen;

import org.nikbird.innopolis.interfaces.newgen.IComposite;
import org.nikbird.innopolis.interfaces.newgen.IRack;
import org.nikbird.innopolis.interfaces.newgen.IServer;

/**
 * Created by nikbird on 25.07.17.
 */

public final class Server implements IServer, Cloneable {

    private static int sId = 1;
    private final static int newId() { return sId++; }

    private int mId;
    private String mName;
    private IRack mContainer;
    private int mIndex;
    private ServerState mState;

    public Server(String name, IRack container, int index, ServerState state) {
        if (container == null)
            throw new NullPointerException("Rack reference is null");
        if (0 > index || index >= container.getCapacity())
            throw new IndexOutOfBoundsException("Index out of rack bounds" + index);
        mId = newId();
        mName = name;
        mContainer = container;
        mIndex = index;
        mState = state;
    }

    @Override public String getName() { return mName; }
    @Override public IRack getContainer() { return mContainer; }
    @Override public int getId() { return mId; }
    @Override public int getIndex() { return mIndex; }
    @Override public ServerState getState() { return mState; }

    @Override public IServer setState(ServerState newState) {
        mState = newState;
        return this;
    }

    @Override public Server clone() throws CloneNotSupportedException {
        return (Server) super.clone();
    }
}
