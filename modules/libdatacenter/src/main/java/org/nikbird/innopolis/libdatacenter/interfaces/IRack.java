package org.nikbird.innopolis.libdatacenter.interfaces;

/**
 * Created by nikbird on 26.07.17.
 */

public interface IRack {

    interface RackInfo {
        int capacity();
        int countServers();
        IServer.ServerState serverState(int index);
    }

    RackInfo getInfo();
    IServer server(int index);
    void insertServer(IServer server, int index);
    IServer removeServer(int index);
}
