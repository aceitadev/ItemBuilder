import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public static ItemStack build(Material material) {
        return new ItemStack(material);
    }

    public static ItemStack build(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        name = name.replace("&", "§");
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack build(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        name = name.replace("&", "§");
        meta.setDisplayName(name);
        List<String> mutableLore = new ArrayList<>(lore);
        mutableLore.replaceAll(s -> s.replace("&", "§"));
        meta.setLore(mutableLore);
        item.setItemMeta(meta);
        return item;
    }
    
}
