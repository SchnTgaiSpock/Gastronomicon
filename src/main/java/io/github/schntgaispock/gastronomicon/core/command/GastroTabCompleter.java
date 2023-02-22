package io.github.schntgaispock.gastronomicon.core.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/**
 * Tab completion for the '/gastronomicon' command
 */
public class GastroTabCompleter implements TabCompleter {

    public static final List<String> nums = Arrays.asList("1", "2", "5", "10", "20", "50", "100", "200");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (!(sender instanceof Player player)) {
            return null;
        }

        switch (args.length) {
            case 0:
                break;

            case 1:
                return filter(args[0], "help", "proficiencies", "profile", "skills");

            case 2:
                switch (args[0]) {
                    case "skills", "profile", "proficiencies":
                        final List<String> names = Bukkit.getServer().getOnlinePlayers().stream().map((Player p) -> {
                            return p.getName();
                        }).toList();
                        names.sort((String s1, String s2) -> s1.compareTo(s2));
                        return filter(args[1], names);

                    case "set", "modify":
                        return filter(args[1], "proficiency", "skill");

                    default:
                        break;
                }

            case 3:
                switch (args[2]) {
                    case "set":
                        switch (args[1]) {
                            case "proficiency":
                                return filter(args[2], nums);

                            case "skill":
                                return filter(args[2], "on", "off");
                        
                            default:
                                break;
                        }
                        break;

                    case "modify":
                        if (!args[1].equals("proficiency")) break;
                        
                        return filter(args[2], nums);

                    default:
                        break;
                }

            // case 4:
            //     switch (args[1]) {
            //         case value:
                        
            //             break;
                
            //         default:
            //             break;
            //     }
            // TODO: finish tab completion

            default:
                break;
        }

        return null;
    }

    private List<String> filter(String filter, String... strings) {
        return filter(filter, Arrays.asList(strings));
    }

    // private List<String> filter(String filter, Collection<String> strings) {
    // return filter(filter, Arrays.asList(strings.toArray(String[]::new)));
    // }

    private List<String> filter(String filter, List<String> strings) {
        strings.removeIf((String string) -> {
            return !string.startsWith(filter);
        });
        return strings;
    }

}
