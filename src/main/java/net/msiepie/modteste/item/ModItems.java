package net.msiepie.modteste.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msiepie.modteste.ModTeste;
import net.msiepie.modteste.item.custom.gnomoitem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModTeste.MOD_ID);

    public static final RegistryObject<Item> ROSARIA = ITEMS.register("rosaria", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.MODDS_TAB)));
    public static final RegistryObject<Item> RAW_ROSARIA = ITEMS.register("raw_rosaria", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.MODDS_TAB)));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.MODDS_TAB)));
    public static final RegistryObject<Item> GNOMO_ITEM = ITEMS.register("gnomoitem",
            () -> new gnomoitem(new Item.Properties().tab(ModCreativeModeTab.MODDS_TAB).stacksTo(1)));



    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }
}
