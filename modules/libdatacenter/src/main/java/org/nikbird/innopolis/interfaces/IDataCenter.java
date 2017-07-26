package org.nikbird.innopolis.interfaces;



/**
 * Created by nikbird on 26.07.17.
 */

public interface IDataCenter {

    class RackAddress {
        public int roomIndex;
        public int rackIndex;
        public RackAddress(int roomIndex, int rackIndex) {
            this.roomIndex = roomIndex;
            this.rackIndex = rackIndex;
        }
    }

    class ServerAddress extends RackAddress {
        public int serverIndex;
        public ServerAddress(int roomIndex, int rackIndex, int serverIndex) {
            super(roomIndex, rackIndex);
            this.serverIndex = serverIndex;
        }
    }

    interface DataCenterInfo {
        int countRooms();

        boolean connectState();
        String connectMessage();

        boolean authState();
        String authMessage();

        IServerRoom.RoomInfo roomInfo(int index);
        IRack.RackInfo rackInfo(RackAddress address);
        IServer.ServerState serverState(ServerAddress address);
    }

    interface IListener {
        void onConnectEvent();
        void onAuthEvent();
        void onReady();
        void onRackAdded(RackAddress address, IRack.RackInfo info);
        void onRackRemoved(RackAddress address);
        void onServerAdded(ServerAddress address, IServer.ServerState state);
        void onServerRemoved(ServerAddress address);
        void onServerStateChanged(ServerAddress address, IServer.ServerState state);
    }

    void connect(String url);
    void authenticate(String userName, String password);

    DataCenterInfo getInfo();
    IServerRoom serverRoom(int index);

    void addListener(IListener listener);
    void removeListener(IListener listener);

    void addServerRoom(IServerRoom room);
    IServerRoom removeServerRoom(IServerRoom room);

}
