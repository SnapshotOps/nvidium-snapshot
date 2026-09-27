package me.cortex.nvidium.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.renderpearl.backend.opengl.GlDevice;
import com.mojang.renderpearl.backend.opengl.GlStateManager;
import com.mojang.renderpearl.frontend.FrontendGpuDevice;

public final class RenderPearlStateManager {
    private RenderPearlStateManager() {}

    public static GlStateManager get() {
        GpuDevice device = RenderSystem.getDevice();
        if (device instanceof FrontendGpuDevice frontend && frontend.backend instanceof GlDevice glDevice) {
            return glDevice.stateManager();
        }
        throw new IllegalStateException("OpenGL GlStateManager is not available on current device");
    }
}

