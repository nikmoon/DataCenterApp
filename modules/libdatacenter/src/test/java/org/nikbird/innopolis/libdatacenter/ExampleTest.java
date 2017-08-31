package org.nikbird.innopolis.libdatacenter;

import org.junit.Test;
import org.nikbird.innopolis.libdatacenter.interfaces.IComponent;
import org.nikbird.innopolis.libdatacenter.models.ServerNew;

import static org.junit.Assert.*;

/**
 * Created by nikbird on 31/08/2017.
 */

public class ExampleTest {

    @Test
    public void test() {

        IComponent server = new ServerNew();
        IComponent.Info serverInfo = server.getInfo();

        System.out.println(serverInfo.getName());
        System.out.println(serverInfo.getIndex());
        System.out.println(serverInfo.getContainerInfo());

    }
}
