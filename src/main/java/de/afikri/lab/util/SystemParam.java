package de.afikri.lab.util;

public class SystemParam {
    String findKey(String entry){
        if(entry == null || entry.trim().equals(""))
            return "-";
        String ret = System.getProperties().keySet()
                .stream()
                .map(key -> key.toString())
                .filter(key->key.contains(entry))
                .findFirst().orElse(" ");
        return ret;
    }

    String getParam(String entry){
        return System.getProperty(findKey(entry));
    }
}
