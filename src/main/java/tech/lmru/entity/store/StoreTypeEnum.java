package tech.lmru.entity.store;

import java.util.HashMap;
import java.util.Map;

public enum StoreTypeEnum {
    OFFLINE(0),
    ONLINE(1);
    
    private int intValue;
    
    private static Map<Integer, StoreTypeEnum> map = new HashMap<Integer, StoreTypeEnum>();
    
    static {
        for( StoreTypeEnum storeTypeEnum : StoreTypeEnum.values()) {
            map.put(storeTypeEnum.intValue, storeTypeEnum);
        }
    }
    
    private StoreTypeEnum(final int enumIntValue) {
        intValue = enumIntValue;
    }
    
    public static StoreTypeEnum valueOf(int enumNumber) {
        return map.get(enumNumber);
    }
    
    private int getIntValue() {
        return intValue;
    }
    
}