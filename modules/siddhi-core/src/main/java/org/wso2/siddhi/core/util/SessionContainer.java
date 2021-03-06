/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.core.util;

import org.wso2.siddhi.core.event.SessionComplexEventChunk;
import org.wso2.siddhi.core.event.stream.StreamEvent;

import java.io.Serializable;

/**
 * This keeps the information of a session key. i.e. current session and the previous session
 */
public class SessionContainer implements Serializable {

    private String key;
    private SessionComplexEventChunk<StreamEvent> currentSession;
    private SessionComplexEventChunk<StreamEvent> previousSession;

    public SessionContainer(String key) {
        currentSession = new SessionComplexEventChunk<>(key);
        previousSession = new SessionComplexEventChunk<>(key);
        this.key = key;
    }

    public SessionContainer() {
        currentSession = new SessionComplexEventChunk<>();
        previousSession = new SessionComplexEventChunk<>();
    }

    public long getCurrentSessionEndTimestamp() {
        if (currentSession.getFirst() != null) {
            return currentSession.getEndTimestamp();
        } else {
            return -1;
        }
    }

    public long getPreviousSessionEndTimestamp() {
        if (previousSession.getFirst() != null) {
            return previousSession.getEndTimestamp();
        } else {
            return -1;
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SessionComplexEventChunk<StreamEvent> getCurrentSession() {
        return currentSession;
    }

    public SessionComplexEventChunk<StreamEvent> getPreviousSession() {
        return previousSession;
    }
}
