package net.msiepie.modteste.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msiepie.modteste.ModTeste;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModTeste.MOD_ID);

    public static final RegistryObject<SoundEvent> GRITO_GNOMO =
            registerSoundEvent("grito_gnomo");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(ModTeste.MOD_ID, name);
        return SOUND_EVENT.register(name, () -> new SoundEvent(new ResourceLocation(ModTeste.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
