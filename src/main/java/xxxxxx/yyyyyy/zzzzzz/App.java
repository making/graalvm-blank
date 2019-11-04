package xxxxxx.yyyyyy.zzzzzz;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.fusesource.jansi.AnsiConsole;

import java.util.Arrays;

import static org.fusesource.jansi.Ansi.ansi;

public class App {

    public static void main(String[] args) throws Exception {
        final OptionParser parser = new OptionParser();
        final OptionSpec<Void> version = parser.acceptsAll(Arrays.asList("v", "version"));
        final OptionSet options = parser.parse(args);
        if (options.has(version)) {
            printVersion();
            return;
        }
        AnsiConsole.systemInstall();
        hello();
    }

    static void hello() {
        System.out.print(ansi().bold().fgBrightRed().a(">").fgBrightYellow().a(">").fgBrightGreen().a(">").reset().a(" "));
        System.out.println("Hello World!");
    }

    static void printVersion() {
        System.out.println("1.0.0");
    }
}
