/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kafka.server.share;

import kafka.server.DelayedOperationKey;

import org.apache.kafka.common.TopicIdPartition;

import java.util.Objects;

/**
 * A key for delayed operations that fetch data for share consumers.
 */
public class DelayedShareFetchKey implements DelayedOperationKey {
    private final String groupId;
    private final TopicIdPartition topicIdPartition;

    DelayedShareFetchKey(String groupId, TopicIdPartition topicIdPartition) {
        this.groupId = groupId;
        this.topicIdPartition = topicIdPartition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelayedShareFetchKey that = (DelayedShareFetchKey) o;
        return topicIdPartition.equals(that.topicIdPartition) && groupId.equals(that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicIdPartition, groupId);
    }

    @Override
    public String toString() {
        return "DelayedShareFetchKey(groupId=" + groupId +
                ", topicIdPartition=" + topicIdPartition +
                ")";
    }

    @Override
    public String keyLabel() {
        return String.format("groupId=%s, topicIdPartition=%s", groupId, topicIdPartition);
    }
}
