import mediaObjects.IMedia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceComposition extends Composition {
    public SequenceComposition(IMedia... objects) {
        super(objects);
    }

    @Override
    public String render() {
        List<String> rendered = objects.stream().map(IMedia::render).collect(Collectors.toList());
        String result = String.join("\n" + "-".repeat(getWidth()) + "\n", rendered);
        return result;
    }

    @Override
    public void display() {
        for (IMedia o :
                objects) {
            o.display();
            System.out.println(" ");
            System.out.println("-----------------");
        }
    }

    @Override
    public int getWidth() {
        return objects.stream().map(IMedia::getWidth).max(Comparator.naturalOrder()).get();
    }

    @Override
    public int getHeight() {
        int h = objects.size();
        for (IMedia o :
                objects) {
            h += o.getHeight();
        }
        return h;
    }
}
