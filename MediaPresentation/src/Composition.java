import mediaObjects.IMedia;

import java.util.List;

public abstract class Composition implements IMedia {
    protected List<IMedia> objects;

    public Composition(IMedia... objects) {
        this.objects = List.of(objects);
    }
}
