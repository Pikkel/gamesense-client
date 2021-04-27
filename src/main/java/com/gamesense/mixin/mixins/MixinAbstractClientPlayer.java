package com.gamesense.mixin.mixins;

import com.gamesense.api.util.render.CapeUtil;
import com.gamesense.client.module.ModuleManager;
import com.gamesense.client.module.modules.render.CapesModule;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.UUID;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {

    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    public void getLocationCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        UUID uuid = getPlayerInfo().getGameProfile().getId();
        CapesModule capesModule = ModuleManager.getModule(CapesModule.class);
        // TODO: this is really dumb and we should make this better by adding an enum
        if (capesModule.isEnabled() && CapeUtil.hasCape(uuid)) {
            switch (capesModule.capeMode.getValue()) {
            case "black":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capeblack.png"));
                break;
            case "white":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capewhite.png"));
                break;
            case "phobos":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capephobos.png"));
                break;
            case "mars":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capemars.png"));
                break;
            }
        }
    }
}