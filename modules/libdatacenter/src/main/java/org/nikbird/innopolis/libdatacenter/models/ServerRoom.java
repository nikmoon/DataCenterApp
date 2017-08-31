package org.nikbird.innopolis.libdatacenter.models;

import org.nikbird.innopolis.libdatacenter.interfaces.IRack;
import org.nikbird.innopolis.libdatacenter.interfaces.IServerRoom;

/**
 * Created by nikbird on 26.07.17.
 */

public class ServerRoom implements IServerRoom {

    private IRack[] mRacks;
    private int mCount;
    private RoomInfo mRoomInfo = new RoomInfo() {
        @Override public int capacity() { return mRacks.length; }
        @Override public int countRacks() { return mCount; }
        @Override public IRack.RackInfo rackInfo(int index) { return mRacks[index].getInfo(); }
    };

    @Override public RoomInfo getInfo() { return mRoomInfo; }
    @Override public IRack rack(int index) { return mRacks[index]; }

    @Override
    public void insertRack(IRack rack, int index) {
        if (rack == null)
            throw new NullPointerException("Rack reference is null");
        if (mRacks[index] != null)
            throw new IllegalArgumentException("Room position is busy: " + index);
        mRacks[index] = rack;
        mCount++;
    }

    @Override
    public IRack removeRack(int index) {
        IRack rack = mRacks[index];
        mRacks[index] = null;
        mCount--;
        return rack;
    }

    public ServerRoom(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Room capacity cant be less then 1");
        mRacks = new IRack[capacity];
        mCount = 0;
    }
}
