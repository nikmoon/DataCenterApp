package org.nikbird.innopolis.models.newgen;

import org.nikbird.innopolis.interfaces.newgen.IComponent;
import org.nikbird.innopolis.interfaces.newgen.IRack;
import org.nikbird.innopolis.interfaces.newgen.IServer;
import org.nikbird.innopolis.interfaces.newgen.IServerRoom;

import java.util.Arrays;

/**
 * Created by nikbird on 25.07.17.
 */

public class Rack implements IRack, Cloneable {

    private static int sId = 1;
    private final static int newId() {return sId++; }

    private int mId;
    private String mName;
    private IServerRoom mRoom;
    private int mIndex;
    private IServer[] mServers;
    private int mCount;

    public Rack(String name, IServerRoom room, int index, int capacity) {
        if (room == null)
            throw new NullPointerException("Room reference is null");
        if (0 > index || index >= room.getCapacity())
            throw new IndexOutOfBoundsException("Index out of room bounds: " + index);
        if (capacity < 1)
            throw new IllegalArgumentException("Room capacity cant be less than 1");
        mId = newId();
        mName = name;
        mRoom = room;
        mIndex = index;
        mServers = new IServer[capacity];
        mCount = 0;
    }

    @Override public IServerRoom getContainer() { return mRoom; }
    @Override public int getIndex() { return mIndex; }
    @Override public String getName() { return mName; }
    @Override public int getId() { return 0; }
    @Override public int getCapacity() { return mServers.length; }
    @Override public int getItemCount() { return mCount; }
    @Override public IServer getItem(int index) { return mServers[index]; }
    @Override public IServer[] getComponents() { return Arrays.copyOf(mServers, mServers.length); }

    @Override public void addItem(IComponent item) {
        if (mServers[item.getIndex()] != null)
            throw new IllegalArgumentException("Position in rack is busy: " + item.getIndex());
        IServer server = (IServer) item;
        mServers[item.getIndex()] = server;
        mCount++;
    }

    @Override public void removeItem(IComponent item) {
        if (mServers[item.getIndex()] == null)
            throw new IllegalArgumentException("Position in rack empty: " + item.getIndex());
        mServers[item.getIndex()] = null;
        mCount--;
    }
}
