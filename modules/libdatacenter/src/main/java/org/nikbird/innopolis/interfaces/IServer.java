package org.nikbird.innopolis.interfaces;

/**
 * Created by nikbird on 26.07.17.
 */

public interface IServer {

    enum ServerState {
        GOOD,
        FAIL;
    }

    ServerState state();
    void setState(ServerState state);
}
