import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder() {
    }

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
    }

    public ItemStack build() {
        return item;
    }

    public void setAmount(int amount) {
        item.setAmount(amount);
    }

    public void setHead(UUID uuid) {
        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) playerHead.getItemMeta();
        if (skullMeta != null) {
            skullMeta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
            playerHead.setItemMeta(skullMeta);
        }
        item = playerHead;
    }
    public void setHead(String base64) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        if (skullMeta != null) {
            try {
                GameProfile profile = new GameProfile(UUID.randomUUID(), null);
                profile.getProperties().put("textures", new Property("textures", base64));
                Field profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);

                skull.setItemMeta(skullMeta);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        item = skull;
    }

    public void setMaterial(Material material) {
        if (item != null) {
            item.setType(material);
        } else {
            item = new ItemStack(material);
        }
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
        lore = lore.stream().map(s -> s.replace("&", "§")).collect(Collectors.toList());
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
