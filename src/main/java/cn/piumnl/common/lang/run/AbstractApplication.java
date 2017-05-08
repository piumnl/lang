package cn.piumnl.common.lang.run;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author piumnl
 * @version 1.0.0
 * @since on 2017-05-08.
 */
public abstract class AbstractApplication implements Application {

    protected static Runtime runtime;

    private Path input;

    private Path output;

    static {
        runtime = Runtime.getRuntime();
    }

    public AbstractApplication(Path input, Path output) {
        this.input = input;
        this.output = output;
    }

    public Process exec(Parameter[] parameters) throws IOException {
        return runtime.exec(name() + parameters);
    }

    public Path getInput() {
        return input;
    }

    public void setInput(Path input) {
        this.input = input;
    }

    public Path getOutput() {
        return output;
    }

    public void setOutput(Path output) {
        this.output = output;
    }
}
