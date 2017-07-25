package org.nikbird.innopolis.interfaces;

/**
 * Created by nikbird on 14.07.17.
 */

public interface IServer {

    enum State { GOOD, FAIL }

    class ServerPosition {
        private final IRack mRack;
        private final int mIndex;

        public ServerPosition(final IRack rack, final int index) {
            if (rack == null)
                throw new IllegalArgumentException();
            if (index < 0 || index >= rack.capacity())
                throw new ArrayIndexOutOfBoundsException();
            mRack = rack;
            mIndex = index;
        }

        public IRack rack() { return mRack; }
        public int index() { return mIndex; }
        public IServer getServer() { return mRack.getServer(mIndex); }
    }

    State state();
    ServerPosition position();
    IServer createCopy();
}
