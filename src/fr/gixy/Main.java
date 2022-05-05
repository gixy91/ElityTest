package fr.gixy;

import fr.gixy.commands.CommandPet;
import fr.gixy.commands.CommandZoo;
import fr.gixy.listeners.EntityDeath;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    List<Entity> petsEntity = new ArrayList<>();
    String customName;

    @Override
    public void onEnable() {

        getCommand("zoo").setExecutor(new CommandZoo(this));
        getCommand("pet").setExecutor(new CommandPet(this));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EntityDeath(this), this);

    }

    @Override
    public void onDisable() {


    }

    public List<Entity> getPetsEntity() {
        return petsEntity;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }
}
