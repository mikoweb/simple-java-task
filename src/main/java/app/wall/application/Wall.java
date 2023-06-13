package app.wall.application;

import app.wall.domain.Block;
import app.wall.domain.CompositeBlock;
import app.wall.domain.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final ArrayList<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : getFlattedBlocksList(blocks)) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        ArrayList<Block> result = new ArrayList<>();

        for (Block block : getFlattedBlocksList(blocks)) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
        }

        return result;
    }

    @Override
    public int count() {
        return getFlattedBlocksList(blocks).size();
    }

    public boolean add(Block block) {
        if (blocks.contains(block)) {
            return true;
        }

        return blocks.add(block);
    }

    private ArrayList<Block> getFlattedBlocksList(List<Block> blocks) {
        ArrayList<Block> flatted = new ArrayList<>();

        for (Block block : blocks) {
            flatted.add(block);

            if (block instanceof CompositeBlock composite) {
                flatted.addAll(getFlattedBlocksList(composite.getBlocks()));
            }
        }

        return flatted;
    }
}
