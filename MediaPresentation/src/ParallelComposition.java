import mediaObjects.IMedia;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelComposition extends Composition {

    public ParallelComposition(IMedia... objects) {
        super(objects);
    }

    @Override
    public String render() {
        List<String> rendered = objects.stream().map(IMedia::render).collect(Collectors.toList());

//        int w = rendered.stream().map(String::length).collect(Collectors.toList());

        String result = String.join(" | ", rendered);
        return result;
    }

    @Override
    public void display() {
        for (IMedia o :
                objects) {
            o.display();
            System.out.println(" ");
        }
    }
}
