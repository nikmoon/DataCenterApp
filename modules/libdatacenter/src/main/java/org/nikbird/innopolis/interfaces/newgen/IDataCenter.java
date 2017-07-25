package org.nikbird.innopolis.interfaces.newgen;

import org.nikbird.innopolis.models.newgen.ServerState;

/**
 * Created by nikbird on 24.07.17.
 */

public interface IDataCenter extends IServerRoom {

    interface IListener {
        void onConnectionEvent();
        void onAuthChanged();
        void onReady();
        void onRackAdded(int rackIndex);
        void onRackRemoved(int rackIndex);
        void onServerAdded(int rackIndex, int serverIndex);
        void onServerRemoved(int rackIndex, int serverIndex);
        void onServerStateChanged(int rackIndex, int serverIndex, ServerState newState);
    }

    void addListener(IListener listener);
    void removeListener(IListener listener);

    boolean eventOk();
    String eventMessage();

    void connect(String url);
    void authenticate(String userName, String password);
}
