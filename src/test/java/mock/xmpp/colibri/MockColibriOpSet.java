/*
 * Jicofo, the Jitsi Conference Focus.
 *
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mock.xmpp.colibri;

import mock.*;

import org.jitsi.eventadmin.*;
import org.jitsi.impl.protocol.xmpp.colibri.*;
import org.jitsi.protocol.xmpp.colibri.*;

/**
 *
 * @author Pawel Domas
 */
public class MockColibriOpSet
    implements OperationSetColibriConference
{
    private final MockProtocolProvider protocolProvider;

    private final EventAdmin eventAdmin;

    private OperationSetColibriConferenceImpl colibriImpl;

    public MockColibriOpSet(MockProtocolProvider protocolProvider,
                            EventAdmin           eventAdmin)
    {
        this.protocolProvider = protocolProvider;

        colibriImpl = new OperationSetColibriConferenceImpl();

        this.eventAdmin = eventAdmin;

        colibriImpl.initialize(
            protocolProvider.getMockXmppConnection(), eventAdmin);
    }

    public AllocThreadingTestColibriConference createAllocThreadingConf()
    {
        return new AllocThreadingTestColibriConference(
            protocolProvider.getMockXmppConnection(), eventAdmin);
    }

    @Override
    public ColibriConference createNewConference()
    {
        return colibriImpl.createNewConference();
    }
}
