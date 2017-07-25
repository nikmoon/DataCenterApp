package org.nikbird.innopolis.models;

import org.nikbird.innopolis.interfaces.IRack;
import org.nikbird.innopolis.interfaces.IServer;

import java.util.Arrays;
import java.util.Iterator;


/**
 * Created by nikbird on 15.07.17.
 */

public class Rack implements IRack {

    private static int sId = 1;
    private static final int newId() {
        return sId++;
    }

    private final int mId;
    private final IServer[] mServers;
    private int mCountServers;
    private RackPosition mPosition;

    public Rack(final int capacity, final RackPosition position) {
        if (capacity < 1)
            throw new IllegalArgumentException();
        mServers = new IServer[capacity];
        mCountServers = 0;
        mPosition = position;
        mId = newId();
    }

    public Rack(final int capacity) {
        this(capacity, null);
    }

    @Override public RackPosition position() { return mPosition; }
    @Override public int capacity() {
        return mServers.length;
    }
    @Override public int countServers() {
        return mCountServers;
    }
    @Override public int availablePlace() { return capacity() - mCountServers; }

    @Override public int hashCode() { return mId; }
    @Override public boolean equals(Object obj) { return this == obj; }

    @Override public IRack setPosition(RackPosition position) {
        mPosition = position;
        return this;
    }

    @Override public IRack createCopy() {
        IRack newRack = new Rack(capacity());
        for(IServer server: mServers)
            if (server != null) {
                IServer serverCopy = server.createCopy();
                newRack.insertServer(serverCopy, server.position().index());
            }
        return newRack;
    }

    @Override public IServer getServer(int index) {
        return getServerUnchecked(index);
    }

    @Override public boolean insertServer(IServer server, int index) {
        if (server != null && server.position() == null && getServerUnchecked(index) == null) {
            insertServerUnchecked(server, index);
            return true;
        }
        return false;
    }

    @Override public IServer.ServerPosition addServer(IServer server) {
        if (server != null && server.position() == null)
            for(int i = 0, count = capacity(); i < count; i++)
                if (getServerUnchecked(i) == null) {
                    insertServerUnchecked(server, i);
                    return server.position();
                }
        return null;
    }

    @Override public boolean removeServer(IServer server) {
        if (server != null) {
            IServer.ServerPosition position = server.position();
            if (position != null && position.rack() == this) {
                removeServerUnchecked(server);
                return true;
            }
        }
        return false;
    }

    @Override public IServer[] getServers() {
        return Arrays.copyOf(mServers, mServers.length);
    }

    private IServer getServerUnchecked(int serverIndex) { return mServers[serverIndex]; }

    private void insertServerUnchecked(IServer server, int serverIndex) {
        mServers[serverIndex] = server;
//        server.setPosition(new IServer.ServerPosition(this, serverIndex));
        mCountServers++;
    }

    private IServer removeServerUnchecked(int serverIndex) {
        return removeServerUnchecked(mServers[serverIndex]);
    }

    private IServer removeServerUnchecked(IServer server) {
        mServers[server.position().index()] = null;
//        server.setPosition(null);
        mCountServers--;
        return server;
    }

    private int mIterIndex;

    @Override
    public Iterator<IServer> iterator() {
        mIterIndex = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        return mIterIndex < capacity();
    }

    @Override
    public IServer next() {
        return getServerUnchecked(mIterIndex++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
