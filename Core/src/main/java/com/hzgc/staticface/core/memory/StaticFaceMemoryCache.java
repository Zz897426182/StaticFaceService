package com.hzgc.staticface.core.memory;

import com.hzgc.staticface.core.pojo.StaticFaceObject;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StaticFaceMemoryCache extends BasicMemoryCache<String, StaticFaceObject> {

    static {

    }

    @Override
    protected int writeMemory(StaticFaceObject value) {
        return super.writeMemory(value);
    }

    @Override
    protected int writeMemory(String key, StaticFaceObject value) {
        return super.writeMemory(key, value);
    }

    @Override
    protected int writeMemory(List<StaticFaceObject> valueList) {
        return super.writeMemory(valueList);
    }

    @Override
    protected int deletMemory(String objectId, String typeKey) {
        return super.deletMemory(objectId, typeKey);
    }

    @Override
    protected int deleteMemory(List<StaticFaceObject> valueList) {
        return super.deleteMemory(valueList);
    }

    @Override
    protected List<ConcurrentHashMap<String, StaticFaceObject>> getMemory(List<String> typeList) {
        return super.getMemory(typeList);
    }

    @Override
    protected ConcurrentHashMap<String, StaticFaceObject> getMemory(String typeKey) {
        return super.getMemory(typeKey);
    }
}
