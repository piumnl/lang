package cn.piumnl.common.lang.run;

import java.io.IOException;

/**
 * @author piumnl
 * @version 1.0.0
 * @since on 2017-05-08.
 */
public interface Application {

    String name();

    void run(Parameter[] parameters) throws IOException;
}
