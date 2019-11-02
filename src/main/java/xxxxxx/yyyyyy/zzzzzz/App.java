package xxxxxx.yyyyyy.zzzzzz;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class App {

    public static void main(String[] args) throws Exception {
        AnsiConsole.systemInstall();
        System.out.print(ansi().bold().fgBrightRed().a(">").fgBrightYellow().a(">").fgBrightGreen().a(">").reset().a(" "));
        System.out.println("Hello World!");
    }
}
