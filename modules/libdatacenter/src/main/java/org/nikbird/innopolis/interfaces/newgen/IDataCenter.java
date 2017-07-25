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
        void onRackAdded(int index);
        void onRackRemoved(int index);
        void onServerAdded(IServer server);
        void onServerRemoved(IRack rack, int index);
        void onServerStateChanged(IServer server, ServerState prevState);
    }

    void addListener(IListener listener);
    void removeListener(IListener listener);

    boolean eventOk();
    String eventMessage();

    void connect(String url);
    void authRequest(String userName, String password);
}
