package app;

import app.wall.application.CompositeWallItem;
import app.wall.application.Wall;
import app.wall.application.WallItem;
import app.wall.domain.Block;
import app.wall.domain.enums.Color;
import app.wall.domain.enums.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Wall wall = new Wall();

        wall.add(new WallItem(Color.RED.toString(), Material.PLASTIC.toString()));
        wall.add(new WallItem(Color.RED.toString(), Material.METAL.toString()));
        wall.add(new WallItem(Color.RED.toString(), Material.WOOD.toString()));
        wall.add(new WallItem(Color.BLUE.toString(), Material.WOOD.toString()));
        wall.add(new WallItem(Color.YELLOW.toString(), Material.WOOD.toString()));

        ArrayList<Block> compositeItems = new ArrayList<>();
        compositeItems.add(new WallItem(Color.YELLOW.toString(), Material.TEXTILE.toString()));
        compositeItems.add(new WallItem(Color.GREEN.toString(), Material.STONE.toString()));

        CompositeWallItem composite = new CompositeWallItem(
            compositeItems,
            Color.BROWN.toString(),
            Material.STONE.toString()
        );

        wall.add(composite);

        Optional<Block> firstGreenBlock = wall.findBlockByColor(Color.GREEN.toString());

        if (firstGreenBlock.isEmpty()) {
            System.out.println("Green block not found!");
        } else {
            System.out.println("----------------");
            System.out.println(firstGreenBlock.get().getColor());
            System.out.println(firstGreenBlock.get().getMaterial());
            System.out.println("----------------");
        }

        List<Block> woodBlocks = wall.findBlocksByMaterial(Material.WOOD.toString());
        System.out.println("Found ".concat(Integer.toString(woodBlocks.size())).concat(" wood blocks."));
    }
}
