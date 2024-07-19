package com.jackbusters.armadillobrushfix.mixins;

import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Armadillo.class)
public class ArmadilloFix {
    @Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean isInstanceOfBrush(ItemStack instance, Item item){
        return instance.getItem() instanceof BrushItem;
    }
}
