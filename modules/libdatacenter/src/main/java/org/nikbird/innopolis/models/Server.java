package org.nikbird.innopolis.models;

import org.nikbird.innopolis.interfaces.IServer;

/**
 * Created by nikbird on 26.07.17.
 */

public class Server implements IServer {

    private ServerState mState;

    @Override public ServerState state() { return mState; }
    @Override public void setState(ServerState state) { mState = state; }

    public Server(ServerState state) { mState = state; }
}
