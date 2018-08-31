package com.ullarah.umagic.recipe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MagicHoeNormal {

    private String hoeDisplayName;
    private String hoeTypeLore;

    public MagicHoeNormal() {
        setHoeDisplayName(ChatColor.AQUA + "Magical Hoe");
        setHoeTypeLore("" + ChatColor.AQUA + ChatColor.BOLD + "▪▪ NORMAL ▪▪");
    }

    public String getHoeDisplayName() {
        return this.hoeDisplayName;
    }

    private void setHoeDisplayName(String name) {
        this.hoeDisplayName = name;
    }

    public String getHoeTypeLore() {
        return this.hoeTypeLore;
    }

    private void setHoeTypeLore(String lore) {
        this.hoeTypeLore = lore;
    }

    public ItemStack hoe() {

        ItemStack hoeStack = new ItemStack(Material.DIAMOND_HOE, 1);
        ItemMeta hoeMeta = hoeStack.getItemMeta();

        hoeMeta.setDisplayName(getHoeDisplayName());

        ArrayList<String> hoeLore = new ArrayList<>();

        hoeLore.add(getHoeTypeLore());
        hoeLore.add(ChatColor.RESET + "");

        hoeLore.add("" + ChatColor.RED + ChatColor.BOLD + "Use it at your own risk!");
        hoeLore.add(ChatColor.RED + "If anything breaks, it's your own fault!");

        hoeMeta.setLore(hoeLore);

        hoeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        hoeStack.setItemMeta(hoeMeta);

        hoeStack.addUnsafeEnchantment(Enchantment.LUCK, 1);

        return hoeStack;

    }

    public ShapedRecipe recipe() {

        ShapedRecipe hoeRecipe = new ShapedRecipe(hoe());
        hoeRecipe.shape("RMR", "MHM", "RMR");

        hoeRecipe.setIngredient('H', Material.DIAMOND_HOE);
        hoeRecipe.setIngredient('M', Material.GLISTERING_MELON_SLICE);
        hoeRecipe.setIngredient('R', Material.REDSTONE);

        return hoeRecipe;

    }

}
