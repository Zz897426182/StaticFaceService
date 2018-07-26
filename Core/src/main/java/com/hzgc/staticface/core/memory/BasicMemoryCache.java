package com.hzgc.staticface.core.memory;

import com.hzgc.staticface.core.constants.MemoryConstants;
import com.hzgc.staticface.core.pojo.BasicObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

abstract class BasicMemoryCache<K, V extends BasicObject<K, K>> {
    private final ConcurrentHashMap<K, ConcurrentHashMap<K, V>>
            memoryCache = new ConcurrentHashMap<>();

    protected int writeMemory(V value) {
        if (value != null && value.getTypeKey() != null) {
            if (value.getObjectId() != null) {
                ConcurrentHashMap<K, V> typeMap = memoryCache.get(value.getTypeKey());
                if (typeMap != null) {
                    typeMap.put(value.getObjectId(), value);
                } else {
                    typeMap = new ConcurrentHashMap<K, V>();
                    typeMap.put(value.getObjectId(), value);
                    memoryCache.put(value.getTypeKey(), typeMap);
                }
                return MemoryConstants.successfull;
            } else {
                return MemoryConstants.failed;
            }
        } else {
            return MemoryConstants.failed;
        }
    }

    protected int writeMemory(K key, V value) {
        if (value != null && value.getTypeKey() != null) {
            if (value.getObjectId() != null) {
                ConcurrentHashMap<K, V> typeMap = memoryCache.get(key);
                if (typeMap != null) {
                    typeMap.put(value.getObjectId(), value);
                } else {
                    typeMap = new ConcurrentHashMap<K, V>();
                    typeMap.put(value.getObjectId(), value);
                    memoryCache.put(key, typeMap);
                }
                return MemoryConstants.successfull;
            } else {
                return MemoryConstants.failed;
            }
        } else {
            return MemoryConstants.failed;
        }
    }

    protected int writeMemory(List<V> valueList) {
        if (valueList != null && valueList.size() > 0) {
            for (V v : valueList) {
                if (v != null && v.getObjectId() != null && v.getTypeKey() != null) {
                    ConcurrentHashMap<K, V> typeMap = memoryCache.get(v.getTypeKey());
                    if (typeMap != null) {
                        typeMap.put(v.getObjectId(), v);
                    } else {
                        typeMap = new ConcurrentHashMap<>();
                        typeMap.put(v.getObjectId(), v);
                        memoryCache.put(v.getTypeKey(), typeMap);
                    }
                }
            }
            return MemoryConstants.successfull;
        }
        return MemoryConstants.failed;

    }

    protected int deletMemory(K objectId, K typeKey) {
        if (objectId != null && typeKey != null) {
            ConcurrentHashMap<K, V> typeMap = memoryCache.get(typeKey);
            if (typeMap != null) {
                typeMap.remove(objectId);
                return MemoryConstants.successfull;
            } else {
                return MemoryConstants.successfull;
            }
        } else {
            return MemoryConstants.failed;
        }
    }

    protected int deleteMemory(List<V> valueList) {
        if (valueList != null && valueList.size() > 0) {
            for (V v : valueList) {
                if (v.getTypeKey() != null && v.getObjectId() != null) {
                    ConcurrentHashMap<K, V> typeMap = memoryCache.get(v.getTypeKey());
                    if (typeMap != null) {
                        typeMap.remove(v.getObjectId());
                        return MemoryConstants.successfull;
                    } else {
                        return MemoryConstants.successfull;
                    }
                }
            }
            return MemoryConstants.successfull;
        } else {
            return MemoryConstants.failed;
        }
    }

    protected List<ConcurrentHashMap<K, V>> getMemory(List<K> typeList) {
        if (typeList != null && typeList.size() > 0) {
            List<ConcurrentHashMap<K, V>> newList = new ArrayList<>();
            for (K k : typeList) {
                ConcurrentHashMap<K, V> typeMap = memoryCache.get(k);
                newList.add(typeMap);
            }
            return newList;
        } else {
            return new ArrayList<>();
        }
    }

    protected ConcurrentHashMap<K, V> getMemory(K typeKey) {
        if (typeKey != null) {
            ConcurrentHashMap<K, V> typeMap = memoryCache.get(typeKey);
            if (typeMap == null) {
                return new ConcurrentHashMap<>();
            } else {
                return typeMap;
            }
        } else {
            return new ConcurrentHashMap<>();
        }
    }

}
