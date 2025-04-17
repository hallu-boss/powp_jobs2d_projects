package edu.kis.powp.jobs2d.drivers.canva;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;


public class WorkspaceCanva implements Job2dDriver {
    private final Job2dDriver innerDriver;

    private int currentX,  currentY;
    private CanvaShape bound;

    
    public WorkspaceCanva(Job2dDriver innerDriver, CanvaShape bound) {
        this.innerDriver = innerDriver;
        this.bound = bound;
    }

    public CanvaShape getBound() {
        return bound;
    }

    @Override
    public void setPosition(int x, int y) {
        int[] clipped = clipPointToBounds(x, y);
        currentX = clipped[0];
         currentY = clipped[1];
        innerDriver.setPosition(currentX,  currentY);
    }

    @Override
    public void operateTo(int x, int y) {
        int[] clipped = bound.clipLine(currentX,  currentY, x, y);
        currentX = clipped[0];
         currentY = clipped[1];
        innerDriver.operateTo(currentX,  currentY);
    }

    private int[] clipPointToBounds(int x, int y) {
        if (bound.contains(x, y)) {
            return new int[]{x, y};
        } else {
            return bound.clipLine(currentX,  currentY, x, y);
        }
    }

}
