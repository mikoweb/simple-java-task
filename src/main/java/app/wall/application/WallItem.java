package app.wall.application;

import app.wall.domain.Block;

public class WallItem implements Block {
    private final String color;
    private final String material;

    public WallItem(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
