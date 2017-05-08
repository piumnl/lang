package cn.piumnl.common.lang.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author piumnl
 * @version 1.0.0
 * @since on 2017-05-08.
 */
public class PathUtil {

    public static File toFile(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        return path.toFile();
    }
}
