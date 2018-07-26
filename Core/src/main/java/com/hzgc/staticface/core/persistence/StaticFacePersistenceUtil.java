package com.hzgc.staticface.core.persistence;

import com.hzgc.staticface.core.pojo.StaticFaceObject;

import java.util.List;

public class StaticFacePersistenceUtil extends PersistenceUtil<String, StaticFaceObject>{
    @Override
    int writeHBase(String value) {
        return 0;
    }

    @Override
    int writeHBase(List<String> value) {
        return 0;
    }

    @Override
    int writeHBase(String typeKey, StaticFaceObject value) {
        return 0;
    }

    @Override
    int deleteHBase(String objectId, String typeKey) {
        return 0;
    }

    @Override
    int deleteHBase(List<StaticFaceObject> valueList) {
        return 0;
    }

    @Override
    List<StaticFaceObject> getHBase(List<String> objectIdList) {
        return null;
    }

    @Override
    StaticFaceObject getHBase(String objectId) {
        return null;
    }
}
