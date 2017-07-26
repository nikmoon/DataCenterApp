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
    public void autenticate(String userName, String password) {

    }

    @Override
    public DataCenterInfo getInfo() {
        return null;
    }

    @Override
    public IServerRoom serverRoom(int index) {
        return null;
    }

    @Override
    public IServerRoom.RoomInfo addServerRoom(IServerRoom room) {
        return null;
    }

    @Override
    public IServerRoom removeRack(int index) {
        return null;
    }
}
