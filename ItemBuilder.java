import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private final ItemStack item;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
    }

    public ItemStack build() {
        return item;
    }

    public void setAmount(int amount) {
        item.setAmount(amount);
    }

    public void setName(String name) {
        if (name == null) return;
        name = name.replace("&", "§");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
    }

    public void setLore(List<String> lore) {
        if (lore == null) return;
        lore = lore.stream().map(line -> line.replace("&", "§")).toList();
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public void setLore(String lore) {
        if (lore == null) return;
        lore = lore.replace("&", "§");
        List<String> loreList = new ArrayList<>();
        loreList.add(lore);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(loreList);
        item.setItemMeta(meta);
    }

    public void setLore(String... lore) {
        if (lore == null) return;
        List<String> loreList = new ArrayList<>();
        for (String line : lore) {
            loreList.add(line.replace("&", "§"));
        }
        ItemMeta meta = item.getItemMeta();
        meta.setLore(loreList);
        item.setItemMeta(meta);
    }

    public void addLineLore(String line) {
        if (line == null) return;
        line = line.replace("&", "§");
        List<String> lore = item.getItemMeta().getLore();
        lore.add(line);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public void setModelID(int modelId) {
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(modelId);
        item.setItemMeta(meta);
    }

    public void addEnchant(Enchantment enchant) {
        item.addUnsafeEnchantment(enchant, 1);
    }

    public void addEnchant(Enchantment enchant, int level) {
        item.addUnsafeEnchantment(enchant, level);
    }

    public void setGlowing(boolean glowing) {
        ItemMeta meta = item.getItemMeta();
        if (glowing) {
            meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        } else {
            meta.removeEnchant(Enchantment.ARROW_INFINITE);
        }
        item.setItemMeta(meta);
    }

}
