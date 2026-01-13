package com.jungleexpansion.content.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class BananaBunchBlock extends Block {
    public BananaBunchBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .strength(0.5F)
                .sound(SoundType.WOOD)
                .noOcclusion());
    }
}
