package ua.com.alevel.factory;

import jakarta.persistence.Entity;
import org.reflections.Store;
import org.reflections.scanners.Scanners;

import java.util.HashSet;
import java.util.Set;

public class EntityFactory {

    private final Set<Class<?>> entitySet = new HashSet<>();
    private final Store appStore;

    public EntityFactory(Store store) {
        this.appStore = store;
    }

    public void initEntities() {
        appStore.forEach((k, v) -> {
            if (k.equals(Scanners.TypesAnnotated.name())) {
                v.forEach((key, value) -> {
                    if (key.equals(Entity.class.getName())) {
                        value.forEach(val -> {
                            try {
                                Class<?> entity = Class.forName(val);
                                entitySet.add(entity);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                });
            }
        });
    }

    public Set<Class<?>> getEntitySet() {
        return entitySet;
    }
}
