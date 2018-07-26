package com.hzgc.staticface.core.pojo;

public class BasicObject<T, K> {
    private T typeKey;
    private K objectId;

    public T getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(T typeKey) {
        this.typeKey = typeKey;
    }

    public K getObjectId() {
        return objectId;
    }

    public void setObjectId(K objectId) {
        this.objectId = objectId;
    }
}
