import mediaObjects.IMedia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelComposition extends Composition {
    private String sep = " | ";

    public ParallelComposition(IMedia... objects) {
        super(objects);
    }

    @Override
    public String render() {
        List<Integer> w = objects.stream().map(IMedia::getWidth).collect(Collectors.toList());
        String[][] matrix = new String[getHeight()][objects.size()];
        for (int i = getHeight() - 1; i >= 0; i--) {
            for (int j = 0; j < w.size(); j++) {
                matrix[i][j] = " ".repeat(w.get(j));
            }

        }
        int j = 0;
        for (IMedia object : objects) {
            String s = object.render();
            String[] strings = s.lines().toArray(String[]::new);
            for (int i = 0; i < strings.length; i++) {
                matrix[i][j] = strings[i] + " ".repeat(w.get(j) - strings[i].length());
            }
            j++;
        }
        List<String> renderedLines = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            renderedLines.add(String.join(sep, matrix[i]));
        }
        return String.join("\n", renderedLines);
    }

    @Override
    public void display() {
        for (IMedia o :
                objects) {
            o.render();
        }
    }

    @Override
    public int getWidth() {
        int w = (objects.size() - 1) * sep.length();
        for (IMedia o :
                objects) {
            w += o.getWidth();
        }
        return w;
    }

    @Override
    public int getHeight() {
        return objects.stream().map(IMedia::getHeight).max(Comparator.naturalOrder()).get();
    }
}
