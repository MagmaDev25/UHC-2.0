package me.maxdev.file;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FileBinder {
    private Map<String, FileCreator> binder = new HashMap<>();

    public void bind(String name, FileCreator file){
        if(file == null){
            return;
        }
        binder.put(name, file);
    }

    public Optional<FileCreator> getFile(String name){
        return Optional.ofNullable(binder.get(name));
    }
}
