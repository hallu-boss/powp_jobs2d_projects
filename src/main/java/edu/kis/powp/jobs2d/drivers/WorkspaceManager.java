package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.drivers.canva.WorkspaceCanva;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;

public class WorkspaceManager {
    private WorkspaceCanva currentWorkspace = null;

    public synchronized void setCurrentCanva(WorkspaceCanva driver) {
        currentWorkspace = driver;
    }

    public synchronized CanvaShape getCurrentCanvasShape() {
        return currentWorkspace.getBound();
    }
}
