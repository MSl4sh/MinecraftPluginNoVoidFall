
public class Main extends JavaPlugin implements Listener {
    private String worldName;

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        FileConfiguration config = getConfig();
        config.addDefault("world", "world");
        config.options().copyDefaults(true);
        saveConfig();
        worldName = config.getString("world");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = player.getWorld();

        if (world.getName().equals(worldName) && loc.getY() < 0) {
            player.teleport(world.getSpawnLocation());
        }
    }
}
