package net.msiepie.modteste.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MODDS_TAB = new CreativeModeTab("MODDS") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ROSARIA.get());
        }
    };
}
