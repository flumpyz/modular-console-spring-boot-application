package com.example.modularconsoleapplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModularConsoleApplication {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        File file = new File(fileName);
        if (!file.exists()) {
            throw new IOException();
        }

        List<Module> modules = getSuitableModules(file);
        printSuitableModules(modules);

        String userLine = scanner.next();
        String[] userArgs = userLine.split("\s");
        String arg = null;
        Integer moduleNumber = Integer.parseInt(userArgs[0]);

        if (userArgs.length > 1) {
            arg = userArgs[1];
        }

        String moduleResult = modules.get(moduleNumber - 1).getValue(file, arg);
        System.out.printf("Result: \n%s%n", moduleResult);
    }

    public static List<Module> getSuitableModules(File file) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ModularConsoleApplication.class);
        return applicationContext
                .getBeansOfType(Module.class)
                .values()
                .stream()
                .filter(m -> m.checkExtension(file))
                .collect(Collectors.toList());
    }

    public static void printSuitableModules(List<Module> modules) {
        System.out.println();
        for (int i = 0; i < modules.size(); i++) {
            System.out.printf("%s : %s%n", i + 1, modules.get(i).getDescription());
        }
    }
}
