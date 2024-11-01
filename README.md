# 🛠️ ItemBuilder

Uma classe utilitária em Java para facilitar a criação de itens personalizados em plugins Bukkit para Minecraft. O `ItemBuilder` oferece métodos convenientes para configurar um item com nome, descrição (lore), quantidade, modelo personalizado, e outros atributos customizados, proporcionando flexibilidade na personalização de itens em seu plugin.

## 🚀 Funcionalidades

- **📦 Criação Rápida de Itens**: Crie itens baseados em qualquer `Material`.
- **✨ Nome Personalizado**: Defina um nome para o item com suporte a cores.
- **📜 Descrição (Lore)**: Adicione uma descrição ao item com múltiplas linhas, também com suporte a cores.
- **🔢 Quantidade**: Defina a quantidade do item diretamente.
- **🆕 Modelo Personalizado**: Aplique um modelo customizado ao item.

## 📚 Como Usar

### 1. Adicionar `ItemBuilder` ao Projeto

Copie a classe `ItemBuilder` para o seu projeto Bukkit:

```java
import org.bukkit.Material;
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
        name = name.replace("&", "§");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
    }

    public void setLore(List<String> lore) {
        lore = lore.stream().map(line -> line.replace("&", "§")).toList();
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public void setLore(String lore) {
        lore = lore.replace("&", "§");
        List<String> loreList = new ArrayList<>();
        loreList.add(lore);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(loreList);
        item.setItemMeta(meta);
    }

    public void setLore(String... lore) {
        List<String> loreList = new ArrayList<>();
        for (String line : lore) {
            loreList.add(line.replace("&", "§"));
        }
        ItemMeta meta = item.getItemMeta();
        meta.setLore(loreList);
        item.setItemMeta(meta);
    }

    public void addLineLore(String line) {
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

}
```

### 2. Criar um Item Básico

Para criar um item básico sem personalizações:

```java
ItemStack simpleItem = new ItemBuilder(Material.DIAMOND).build();
```

### 3. Criar um Item com Nome Personalizado

Para definir um nome customizado com cores, utilize o símbolo `&` para representar cores:

```java
ItemBuilder namedItemBuilder = new ItemBuilder(Material.GOLDEN_APPLE);
namedItemBuilder.setName("&6Maçã Dourada");
ItemStack namedItem = namedItemBuilder.build();
```

### 4. Criar um Item com Nome e Lore (Descrição)

Defina um nome e uma lore com cores para o item:

```java
List<String> lore = List.of("&7Um item raro", "&aUse com sabedoria!");
ItemBuilder loreItemBuilder = new ItemBuilder(Material.NETHER_STAR);
loreItemBuilder.setName("&bEstrela do Nether");
loreItemBuilder.setLore(lore);
ItemStack loreItem = loreItemBuilder.build();
```

### 5. Definir Quantidade e Modelo Personalizado

Para definir a quantidade e o modelo personalizado do item:

```java
ItemBuilder customItemBuilder = new ItemBuilder(Material.DIAMOND_SWORD);
customItemBuilder.setName("&cEspada Diamante");
customItemBuilder.setAmount(10);
customItemBuilder.setModelID(1); // Exemplo de modelo customizado
ItemStack customItem = customItemBuilder.build();
```

### 📝 Exemplo Completo

```java
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Item simples
        ItemStack simpleItem = new ItemBuilder(Material.DIAMOND).build();

        // Item com nome personalizado
        ItemBuilder namedItemBuilder = new ItemBuilder(Material.GOLDEN_APPLE);
        namedItemBuilder.setName("&6Maçã Dourada");
        ItemStack namedItem = namedItemBuilder.build();

        // Item com nome e lore
        List<String> lore = List.of("&7Um item raro", "&aUse com sabedoria!");
        ItemBuilder loreItemBuilder = new ItemBuilder(Material.NETHER_STAR);
        loreItemBuilder.setName("&bEstrela do Nether");
        loreItemBuilder.setLore(lore);
        ItemStack loreItem = loreItemBuilder.build();

        // Item com quantidade e modelo customizado
        ItemBuilder customItemBuilder = new ItemBuilder(Material.DIAMOND_SWORD);
        customItemBuilder.setName("&cEspada Diamante");
        customItemBuilder.setAmount(10);
        customItemBuilder.setModelID(1);
        ItemStack customItem = customItemBuilder.build();
    }
}
```
