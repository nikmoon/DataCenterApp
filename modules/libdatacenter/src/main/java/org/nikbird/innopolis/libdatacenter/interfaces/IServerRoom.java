package org.nikbird.innopolis.libdatacenter.interfaces;

/**
 * Created by nikbird on 26.07.17.
 */

public interface IServerRoom {

    interface RoomInfo {
        int capacity();
        int countRacks();
        IRack.RackInfo rackInfo(int index);
    }

    RoomInfo getInfo();
    IRack rack(int index);
    void insertRack(IRack rack, int index);
    IRack removeRack(int index);
}
