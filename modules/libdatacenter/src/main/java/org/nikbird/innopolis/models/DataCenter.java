package org.nikbird.innopolis.models;

import org.nikbird.innopolis.interfaces.IDataCenter;
import org.nikbird.innopolis.interfaces.IRack;
import org.nikbird.innopolis.interfaces.IServer;
import org.nikbird.innopolis.interfaces.IServerRoom;

import java.util.List;

/**
 * Created by nikbird on 26.07.17.
 */

public class DataCenter implements IDataCenter {

    private List<IServerRoom> mRooms;
    private boolean mConnectState;
    private String mConnectMessage;
    private boolean mAuthState;
    private String mAuthMessage;
    private List<IListener> mListeners;
    private DataCenterInfo mInfo = new DataCenterInfo() {
        @Override public int countRooms() { return mRooms.size(); }
        @Override public boolean connectState() { return mConnectState; }
        @Override public String connectMessage() { return mConnectMessage; }
        @Override public boolean authState() { return mAuthState; }
        @Override public String authMessage() { return mAuthMessage; }

        @Override public IServerRoom.RoomInfo roomInfo(int index) {
            return mRooms.get(index).getInfo();
        }

        @Override
        public IRack.RackInfo rackInfo(RackAddress address) {
            return mRooms.get(address.roomIndex).rack(address.rackIndex).getInfo();
        }

        @Override
        public IServer.ServerState serverState(ServerAddress address) {
            return rackInfo(address).serverState(address.serverIndex);
        }
    };

    @Override
    public void connect(String url) {

    }

    @Override
    public void authenticate(String userName, String password) {

    }

    @Override public DataCenterInfo getInfo() {
        return mInfo;
    }
    @Override public IServerRoom serverRoom(int index) {
        return mRooms.get(index);
    }

    @Override
    public void addListener(IListener listener) {
        if (listener == null)
            throw new NullPointerException("Listener cant be null");
        if (containsReference(mListeners, listener) >= 0)
            return;
        mListeners.add(listener);
    }

    @Override
    public void removeListener(IListener listener) {
        removeReference(mListeners, listener);
    }

    @Override
    public void addServerRoom(IServerRoom room) {
        if (room == null)
            throw new NullPointerException("Room reference cant be null");
        if (containsReference(mRooms, room) >= 0)
            return;
        mRooms.add(room);
    }

    @Override
    public IServerRoom removeServerRoom(IServerRoom room) {
        int index = containsReference(mRooms, room);
        if (index >= 0)
            mRooms.remove(index);
        return room;
    }

    public static int containsReference(List list, Object ref) {
        for(int i = 0, count = list.size(); i < count; i++)
            if (list.get(i) == ref)
                return i;
        return -1;
    }

    public static boolean removeReference(List list, Object ref) {
        for(int i = 0, count = list.size(); i < count; i++)
            if (list.get(i) == ref) {
                list.remove(i);
                return true;
            }
        return false;
    }
}
