package app.wall.application;

import app.wall.domain.Block;
import app.wall.domain.CompositeBlock;

import java.util.ArrayList;
import java.util.List;

public class CompositeWallItem extends WallItem implements CompositeBlock {
    private final ArrayList<Block> blocks;

    public CompositeWallItem(ArrayList<Block> blocks, String color, String material) {
        super(color, material);
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
