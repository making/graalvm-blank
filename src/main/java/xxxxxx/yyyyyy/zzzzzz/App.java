package xxxxxx.yyyyyy.zzzzzz;

import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.fusesource.jansi.AnsiConsole;

import java.util.Arrays;

import static org.fusesource.jansi.Ansi.ansi;

public class App {

    public static void main(String[] args) throws Exception {
        final OptionParser parser = new OptionParser();
        final OptionSpec<Void> version = parser.acceptsAll(Arrays.asList("v", "version"), "Print version");
        final OptionSpec<Void> help = parser.acceptsAll(Arrays.asList("h", "help"), "Print help");
        try {
            final OptionSet options = parser.parse(args);

            if (options.has(help)) {
                parser.printHelpOn(System.out);
                return;
            }
            if (options.has(version)) {
                printVersion();
                return;
            }

            AnsiConsole.systemInstall();
            hello();
        } catch (OptionException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    static void hello() {
        System.out.print(ansi().bold().fgBrightRed().a(">").fgBrightYellow().a(">").fgBrightGreen().a(">").reset().a(" "));
        System.out.println("Hello World!");
    }

    static void printVersion() {
        System.out.println("1.0.0");
    }
}
