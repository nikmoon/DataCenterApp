package org.nikbird.innopolis.libdatacenter.models;

import org.nikbird.innopolis.libdatacenter.interfaces.IRack;
import org.nikbird.innopolis.libdatacenter.interfaces.IServer;

/**
 * Created by nikbird on 26.07.17.
 */

public class Rack implements IRack {

    private IServer[] mServers;
    private int mCount;
    private RackInfo mRackInfo = new RackInfo() {
        @Override public int capacity() { return mServers.length; }
        @Override public int countServers() { return mCount; }
        @Override public IServer.ServerState serverState(int index) { return mServers[index].state(); }
    };

    @Override public RackInfo getInfo() { return mRackInfo; }
    @Override public IServer server(int index) { return mServers[index]; }

    @Override
    public void insertServer(IServer server, int index) {
        if (server == null)
            throw new NullPointerException("Server reference is null");
        if (mServers[index] != null)
            throw new IllegalArgumentException("Rack position is busy: " + index);
        mServers[index] = server;
        mCount++;
    }

    @Override
    public IServer removeServer(int index) {
        IServer server = mServers[index];
        mServers[index] = null;
        mCount--;
        return server;
    }

    public Rack(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Rack capacity cant be less then 1");
        mServers = new IServer[capacity];
        mCount = 0;
    }
}
