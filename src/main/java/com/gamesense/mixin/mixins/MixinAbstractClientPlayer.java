// _____         _     _        _      _ _
//|_   _|__  ___| |__ | |_ _ __(_) ___(_) |_ _   _
//  | |/ _ \/ __| '_ \| __| '__| |/ __| | __| | | |
//  | |  __/ (__| | | | |_| |  | | (__| | |_| |_| |
//  |_|\___|\___|_| |_|\__|_|  |_|\___|_|\__|\__, |
//                                           |___/
//This guy is a true chad
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
            case "femboycock":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capefemboycock.png"));
                break;
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
            case "lofi":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capelofiblack.png"));
                break;
            case "gentowo":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capegentowo.png"));
                break;
            case "zane":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capezane.png"));
                break;
            case "tux":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capetux.png"));
                break;
            case "flushed":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capeflushed.png"));
                break;
            case "boba":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capeboba.png"));
                break;
            case "nhs":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capenhs.png"));
                break;
            case "namiix":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capenamiix.png"));
                break;
            case "tails":
                callbackInfoReturnable.setReturnValue(new ResourceLocation("gamesense:capetails.png"));
                break;
            }
        }
    }
}
