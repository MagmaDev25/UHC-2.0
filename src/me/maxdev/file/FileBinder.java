package me.maxdev.file;

import java.util.HashMap;
import java.util.Map;

public class FileBinder {
    private Map<String, FileCreator> binder = new HashMap<>();

    public void bind(String name, FileCreator file){
        if(file == null){
            return;
        }
        binder.put(name, file);
    }

    public FileCreator getFile(String name){
        return binder.get(name);
    }
}
