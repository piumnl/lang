package cn.piumnl.common.lang.run;

/**
 * @author piumnl
 * @version 1.0.0
 * @since on 2017-05-08.
 */
public class Parameter {

    private String command;

    private String arg;

    @Override
    public String toString() {
        return " " + command + " " + arg;
    }
}
