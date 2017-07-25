package org.nikbird.innopolis.interfaces.newgen;

import org.nikbird.innopolis.models.newgen.ServerState;

/**
 * Created by nikbird on 24.07.17.
 */

public interface IServer extends INamedEntity, IComponent {
    ServerState getState();
    IServer setState(ServerState newState);
}
