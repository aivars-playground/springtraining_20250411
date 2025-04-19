package org.example.base.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InitializationAppConf {

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Running commandLineRunner for args: " + Arrays.toString(args));
        };
    }

    @Bean
    ApplicationRunner applicationRunner(ApplicationContext applicationContext) {
        return appArgs -> {
            System.out.println(
                    "Running applicationRunner for:" +
                        "\n  SourceArgs: " + Arrays.toString(appArgs.getSourceArgs()) +
                        "\n  NonOptionArgs: "+ appArgs.getNonOptionArgs().toString() +
                        "\n  OptionNames " + appArgs.getOptionNames().toString() +
                        "\n    Option value for(myOption) "+appArgs.getOptionValues("myOption").toString()
            );
        };
    }
}

    /*
        running app with "abc --myOption=bbb --myOption=ccc" arguments would return (in console, and in random order)

        Running applicationRunner for:
          SourceArgs: [abc, --myOption=bbb, --myOption=ccc]
          NonOptionArgs: [abc]
          OptionNames [myOption]
            Option value for(myOption) [bbb, ccc]
        Running commandLineRunner for args: [abc, --myOption=bbb, --myOption=ccc]
     */