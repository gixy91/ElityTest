package fr.gixy.commands;

import fr.gixy.Main;
import fr.gixy.obj.Pets;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public class CommandZoo implements CommandExecutor {

    final private Main main;

    public CommandZoo(Main main) {

        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Pets pets = new Pets(main);

        if (sender instanceof Player) {
            if (!main.getPetsEntity().isEmpty()) {

                player.sendMessage("Erreur : " + ChatColor.RED + " Votre animal est encore en vie !");
                return true;
            }
            if (args.length != 1) {

                player.sendMessage("Syntaxe correcte :" + ChatColor.RED + " /zoo [mouton,cochon,vache]");

                return true;
            }
            if (args[0].equalsIgnoreCase("poulet")) {

                pets.spawnAnimal(EntityType.CHICKEN, player.getLocation(), player);

            } else if (args[0].equalsIgnoreCase("vache")) {

                pets.spawnAnimal(EntityType.COW, player.getLocation(), player);
            } else if (args[0].equalsIgnoreCase("mouton")) {

                pets.spawnAnimal(EntityType.SHEEP, player.getLocation(), player);


            }
        }

        return false;
    }
}
