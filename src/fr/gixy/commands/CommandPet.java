package fr.gixy.commands;

import fr.gixy.Main;
import fr.gixy.obj.Pets;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandPet implements CommandExecutor {

    final private Main main;

    public CommandPet(Main main) {

        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Pets pets = new Pets(main);

        if (sender instanceof Player) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.GREEN + "Vous devez mettre au moins un argument pour valider la commande"
                        +ChatColor.YELLOW+ "-> /pet help ");
                return true;
            }

            if (args.length > 2) {

                player.sendMessage("Votre commande comporte trop d'arguments !");
                return true;
            }

            if(main.getPetsEntity().isEmpty()){
                player.sendMessage(ChatColor.RED+"Il n'y a pas de pets en vie !");

                return true;
            }

            if (args[0].equalsIgnoreCase("name")) {

                String name = args[1];
                pets.setCustomName(name);
                player.sendMessage(ChatColor.GREEN + "Le nouveau nom de votre pet est : " + ChatColor.YELLOW + name);

            } else if (args[0].equalsIgnoreCase("jump")) {

                pets.doJump();
            } else if (args[0].equalsIgnoreCase("sound")) {

                pets.broadcastSound();

            } else if (args[0].equalsIgnoreCase("color")) {

                pets.changeColor(player);


            } else if (args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.YELLOW + "Liste des arguments :");
                player.sendMessage("");
                player.sendMessage("§m------------------------------------");
                player.sendMessage("");
                player.sendMessage("/pet name");
                player.sendMessage("/pet jump");
                player.sendMessage("/pet sound");
                player.sendMessage("/pet color");
                player.sendMessage("");
                player.sendMessage("§m------------------------------------");
            }


        }
        return false;
    }
}