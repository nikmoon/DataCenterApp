package org.nikbird.innopolis.models;

import org.nikbird.innopolis.interfaces.IServer;

/**
 * Created by nikbird on 14.07.17.
 */

public final class Server implements IServer {

    public static final State STATE_DEFAULT = State.GOOD;

    private static int sId = 1;
    private static final int newId() {
        return sId++;
    }

    private final int mId;
    private State mState;
    private ServerPosition mPosition;

    public Server(State state) {
        mState = state;
        mPosition = null;
        mId = newId();
    }

    public Server(IServer server) { this(server.state()); }
    public Server() { this(STATE_DEFAULT); }

    @Override public State state() { return mState; }
    @Override public ServerPosition position() { return mPosition; }
    @Override public int hashCode() { return mId; }
    @Override public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Server.class)
            return ((Server) obj).mId == mId;
        else
            return false;
    }

    @Override public IServer createCopy() { return new Server(mState); }
}
