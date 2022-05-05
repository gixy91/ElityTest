package fr.gixy.obj;

import fr.gixy.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.*;

import java.util.Random;


public class Pets {

    final private Main main;

    public Pets(Main main) {
        this.main = main;
    }

    public void spawnAnimal(EntityType entityType, Location location, Player player) {

        if (entityType.equals(EntityType.SHEEP)) {
            Sheep sheep = (Sheep) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.SHEEP);
            main.getPetsEntity().add(sheep);


        } else if (entityType.equals(EntityType.COW)) {
            Cow cow = (Cow) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.COW);
            main.getPetsEntity().add(cow);

        } else if (entityType.equals(EntityType.CHICKEN)) {
            Chicken chicken = (Chicken) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.CHICKEN);
            main.getPetsEntity().add(chicken);
        }

    }

    public void setCustomName(String name) {

        main.getPetsEntity().get(0).setCustomName(name);
        main.getPetsEntity().get(0).setCustomNameVisible(true);
        main.setCustomName(name);
    }

    public void doJump() {

        if (main.getPetsEntity().get(0).getType().equals(EntityType.SHEEP)) {

            main.getPetsEntity().get(0).setVelocity(main.getPetsEntity().get(0).getVelocity().setY(0.8));

        } else if (main.getPetsEntity().get(0).getType().equals(EntityType.CHICKEN)) {
            main.getPetsEntity().get(0).setVelocity(main.getPetsEntity().get(0).getVelocity().setY(0.1));

        } else if (main.getPetsEntity().get(0).getType().equals(EntityType.COW)) {
            main.getPetsEntity().get(0).setVelocity(main.getPetsEntity().get(0).getVelocity().setY(0.4));

        }

    }

    public void broadcastSound() {

        if (main.getPetsEntity().get(0).getType().equals(EntityType.SHEEP)) {

            Bukkit.broadcastMessage(main.getCustomName() + " : BEHHHHH !");


        } else if (main.getPetsEntity().get(0).getType().equals(EntityType.COW)) {

            Bukkit.broadcastMessage(main.getCustomName() + " : MEUHHHHHHH");
        } else if (main.getPetsEntity().get(0).getType().equals(EntityType.CHICKEN)) {

            Bukkit.broadcastMessage(main.getCustomName() + " : COCOTTT");

        }
    }

    public void changeColor(Player player) {

        if (main.getPetsEntity().get(0) instanceof Sheep) {

            Random random = new Random();
            ((Sheep) main.getPetsEntity().get(0)).setColor(DyeColor.getByData((byte) random.nextInt(16)));
        }else{

            player.sendMessage(ChatColor.YELLOW+"Vous ne pouvez pas faire cette commande car ce n'est pas un mouton");


        }
    }
}