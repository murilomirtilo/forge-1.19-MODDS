package net.msiepie.modteste.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.msiepie.modteste.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class gnomoitem extends Item {
    public gnomoitem(Properties properties) {
        super(properties);
    }

    private int numero = 0;


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Quem sabe os poderes ocultos que os gnomos possuem...").withStyle(ChatFormatting.AQUA));
        } else {
          components.add(Component.literal("Pressione SHIFT para mais informações").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        level.playSound(player, player.blockPosition(), ModSounds.GRITO_GNOMO.get(), SoundSource.PLAYERS, 1f, 1f);
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            conversar(player);



            //level.playSound(player, player.blockPosition(), ModSounds.GRITO_GNOMO.get(), SoundSource.PLAYERS, 1f, 1f);
            player.getCooldowns().addCooldown(this, 20);
            numero++;
        }

        return super.use(level, player, hand);
    }

    private void conversar(Player player) {
            switch (numero) {
                case 0:
                    player.sendSystemMessage(Component.literal("Oi"));
                    break;
                case 1:
                    player.sendSystemMessage(Component.literal("Eu sou um gnomo mágico"));
                    break;
                case 2:
                    player.sendSystemMessage(Component.literal("Me deixe em paz!"));
                    break;
                case 3:
                    player.sendSystemMessage(Component.literal("Qual é o seu problema??"));
                    break;
                case 4:
                    player.sendSystemMessage(Component.literal("ME LARGA"));
                    break;
                case 5:
                    player.sendSystemMessage(Component.literal("Você vai se arrepender!"));
                    break;
                case 6:
                    player.sendSystemMessage(Component.literal("Eu vou te transformar em sapo!"));
                    break;
                case 7:
                    player.sendSystemMessage(Component.literal("Desapareça da minha vista!"));
                    break;
                case 8:
                    player.sendSystemMessage(Component.literal("Eu sou um gnomo poderoso!"));
                    break;
                case 9:
                    player.sendSystemMessage(Component.literal("Você despertou minha fúria!"));
                    break;
                case 10:
                    player.sendSystemMessage(Component.literal("SUCUMBAAAAAAA!"));
                    player.hurt(DamageSource.explosion(player),50f);
                    numero = 0;
                    break;
                default:
                    break;
            }
    }

//    private void outputRandomNumber(Player player) {
//        player.sendSystemMessage(Component.literal("ME LARGA PORRA"));
//    }

//    private int getRandomNumber() {
//        return RandomSource.createNewThreadLocalInstance().nextInt(10);
//    }
}