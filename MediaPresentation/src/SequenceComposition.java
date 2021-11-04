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
        int max_w = 0;
        for (String s :
                rendered) {
            int w;
            try {
                w = s.substring(0, s.indexOf("\n")).length();
            } catch (Exception e) {
                w = s.length();
            }
            if (w > max_w) {
                max_w = w;
            }
        }

        String result = String.join("\n" + "-".repeat(max_w) + "\n", rendered);
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
}
