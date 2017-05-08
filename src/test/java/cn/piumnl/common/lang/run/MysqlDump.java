package cn.piumnl.common.lang.run;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

import cn.piumnl.common.lang.file.PathUtil;

/**
 * @author piumnl
 * @version 1.0.0
 * @since on 2017-05-08.
 */
public class MysqlDump extends AbstractApplication {

    private static final String NAME = "mysqldump";
    private static final long SINGLE_FILE_MAX_LINE = 1000;

    public MysqlDump(Path input, Path output) {
        super(input, output);
    }

    public String name() {
        return NAME;
    }

    public void run(Parameter[] parameters) throws IOException {
        Process process = exec(parameters);

        try (InputStreamReader input =
                     new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
             Scanner scanner = new Scanner(input);
             FileWriter output = new FileWriter(PathUtil.toFile(getOutput()))) {

            long count = 0;

            while (scanner.hasNextLine()) {
                if (count % SINGLE_FILE_MAX_LINE == 0) {
                    output.flush();
                    count++;
                }

                String nextLine = scanner.nextLine();
                output.write(nextLine + "\n");
            }
        }
    }
}
