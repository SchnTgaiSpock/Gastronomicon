package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.command.GastroCommandExecutor;
import io.github.schntgaispock.gastronomicon.core.command.GastroTabCompleter;

/**
 * Does all the necessary prep work for commands to work
 */
public class CommandSetup {
    
    public static void setup() {
        
        Gastronomicon.getInstance().getCommand("gastronomicon").setExecutor(new GastroCommandExecutor());
        Gastronomicon.getInstance().getCommand("gastronomicon").setTabCompleter(new GastroTabCompleter());

    }

}
