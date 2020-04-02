package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class createArena implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("LoLCore.Arena.create")) {
                if(command.getName().equalsIgnoreCase("LOLarena")) {
                    switch (args[0]) {
                        case "create":
                            Arena arena = new Arena();
                            if(Arena.latestArenaNumber != 7) {
                                player.sendMessage("Created arena nr. " + arena.getArenaNumber());
                            } else {
                                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Nie mozesz miec wiecej niz 8 gier!");
                            }
                            break;
                            case "setspawn":
                                switch (args[2]) {
                                case "team1":
                                    for(Arena a : Arena.avaibleAreans) {
                                        if(args[2].equals(a.getArenaNumber())) {
                                            a.team1spawn = player.getLocation();
                                            return true;
                                        }
                                    }
                                    break;
                                    case "team2":
                                        for(Arena a : Arena.avaibleAreans) {
                                            if(args[2].equals(a.getArenaNumber())) {
                                                a.team2spawn = player.getLocation();
                                                return true;
                                            }
                                        }
                                        break;
                                    default:
                                        return true;
                                }
                            break;
                                default:
                                    return true;
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Nie masz permisji!");
            }
        }



        return false;
    }
}
