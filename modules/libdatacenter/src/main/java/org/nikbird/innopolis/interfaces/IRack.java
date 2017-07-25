package org.nikbird.innopolis.interfaces;

import java.util.Iterator;

/**
 * Created by nikbird on 14.07.17.
 */

public interface IRack extends Iterator<IServer>, Iterable<IServer> {

    class RackPosition {
        private final IServerRoom mRoom;
        private final int mIndex;

        public RackPosition(final IServerRoom room, final int index) {
            if (room == null)
                throw new IllegalArgumentException();
            if (index < 0 || index >= room.capacity())
                throw new ArrayIndexOutOfBoundsException();
            mRoom = room;
            mIndex = index;
        }

        public IServerRoom room() { return mRoom; }
        public int index() { return mIndex; }
        public IRack getRack() { return mRoom.getRack(mIndex); }
    }

    RackPosition position();
    int capacity();
    int countServers();
    int availablePlace();
    IRack setPosition(RackPosition position);
    IServer getServer(int index);
    IServer[] getServers();
    boolean insertServer(IServer server, int index);
    boolean removeServer(IServer server);
    IServer.ServerPosition addServer(IServer server);
    IRack createCopy();
}
