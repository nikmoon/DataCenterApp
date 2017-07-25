package org.nikbird.innopolis;

import org.junit.Test;
import org.nikbird.innopolis.interfaces.newgen.IServer;
import org.nikbird.innopolis.models.newgen.Server;
import org.nikbird.innopolis.models.newgen.ServerState;

import static org.junit.Assert.*;


/**
 * Created by nikbird on 24.07.17.
 */

public class TestServerModel {

    @Test
    public void addition_isCorrect() throws Exception {

        IServer server = new Server("Сервер PostgreSQL", null, 0, ServerState.GOOD);

        assertEquals("Сервер PostgreSQL", server.getName());
        assertEquals(null, server.getContainer());
        assertEquals(0, server.getIndex());
        assertEquals(ServerState.GOOD, server.getState());

        IServer serverClone = ((Server) server).clone();

        assertEquals(serverClone.getName(), server.getName());
        assertEquals(serverClone.getContainer(), server.getContainer());
        assertEquals(serverClone.getId(), server.getId());
        assertEquals(serverClone.getIndex(), server.getIndex());
        assertEquals(serverClone.getState(), server.getState());
    }
}
