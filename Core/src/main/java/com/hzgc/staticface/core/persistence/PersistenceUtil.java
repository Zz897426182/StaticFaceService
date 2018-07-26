package com.hzgc.staticface.core.persistence;

import com.hzgc.common.hbase.HBaseHelper;
import com.hzgc.staticface.core.pojo.BasicObject;

import java.util.List;

abstract class PersistenceUtil<K, V extends BasicObject<K, K>> {
    static {
        HBaseHelper.getHBaseConnection();
    }

    abstract int writeHBase(K value);

    abstract int writeHBase(List<K> value);

    abstract int writeHBase(K typeKey, V value);

    abstract int deleteHBase(K objectId, K typeKey);

    abstract int deleteHBase(List<V> valueList);

    abstract List<V> getHBase(List<K> objectIdList);

    abstract V getHBase(K objectId);
}
