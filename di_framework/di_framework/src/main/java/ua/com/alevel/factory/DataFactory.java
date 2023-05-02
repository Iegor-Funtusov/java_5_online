package ua.com.alevel.factory;

import org.reflections.Store;
import org.reflections.scanners.Scanners;
import ua.com.alevel.annotations.ViewData;

import java.util.HashSet;
import java.util.Set;

public class DataFactory {

    private final Set<String> dataSet = new HashSet<>();
    private final Store appStore;

    public DataFactory(Store store) {
        appStore = store;
    }

    public void initData() {
        appStore.forEach((k, v) -> {
            if (k.equals(Scanners.TypesAnnotated.name())) {
                v.forEach((key, value) -> {
                    if (key.equals(ViewData.class.getName())) {
                        dataSet.addAll(value);
                    }
                });
            }
        });
    }

    public Set<String> getDataSet() {
        return dataSet;
    }
}
