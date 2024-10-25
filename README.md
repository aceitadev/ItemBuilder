# 🛠️ ItemBuilder - Criação de Itens Personalizados para Minecraft Bukkit

Uma classe utilitária em Java para facilitar a criação de itens personalizados em plugins Bukkit para Minecraft. O `ItemBuilder` oferece métodos rápidos para criar itens com nome, descrição (lore), e outros atributos customizados.

## 🚀 Funcionalidades

- **📦 Criação Rápida de Itens**: Crie itens baseados em qualquer `Material`.
- **✨ Nome Personalizado**: Defina um nome para o item com suporte a cores.
- **📜 Descrição (Lore)**: Adicione uma descrição ao item com múltiplas linhas, também com suporte a cores.

## 📚 Como Usar

### 1. Adicionar `ItemBuilder` ao Projeto

Copie a classe `ItemBuilder` para o seu projeto Bukkit:

```java
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        lore.replaceAll(s -> s.replace("&", "§"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
```

### 2. Criar um Item Básico

Para criar um item básico sem personalizações:

```java
ItemStack simpleItem = ItemBuilder.build(Material.DIAMOND);
```

### 3. Criar um Item com Nome Personalizado

Para definir um nome customizado com cores, utilize o símbolo `&` para representar cores:

```java
ItemStack namedItem = ItemBuilder.build(Material.GOLDEN_APPLE, "&6Maçã Dourada");
```

### 4. Criar um Item com Nome e Lore (Descrição)

Defina um nome e uma lore com cores para o item:

```java
List<String> lore = List.of("&7Um item raro", "&aUse com sabedoria!");
ItemStack loreItem = ItemBuilder.build(Material.NETHER_STAR, "&bEstrela do Nether", lore);
```

### 📝 Exemplo Completo

```java
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Item simples
        ItemStack simpleItem = ItemBuilder.build(Material.DIAMOND);

        // Item com nome personalizado
        ItemStack namedItem = ItemBuilder.build(Material.GOLDEN_APPLE, "&6Maçã Dourada");

        // Item com nome e lore
        List<String> lore = List.of("&7Um item raro", "&aUse com sabedoria!");
        ItemStack loreItem = ItemBuilder.build(Material.NETHER_STAR, "&bEstrela do Nether", lore);

        // Exibir detalhes (exemplo hipotético)
        System.out.println(namedItem.getItemMeta().getDisplayName());
        System.out.println(loreItem.getItemMeta().getLore());
    }
}
```

Com o `ItemBuilder`, você pode personalizar facilmente itens para seu plugin Bukkit, garantindo uma experiência mais imersiva e criativa para seus jogadores.
