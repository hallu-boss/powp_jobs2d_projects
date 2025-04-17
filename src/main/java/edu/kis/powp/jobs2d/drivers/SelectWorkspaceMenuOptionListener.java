package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.drivers.canva.WorkspaceCanva;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWorkspaceMenuOptionListener implements ActionListener {
    private DriverManager driverManager;
    private WorkspaceCanva canvas = null;
    private LineDriverAdapter borderDriver = new LineDriverAdapter(DrawerFeature.getDrawerController(), LineFactory.getDottedLine(), "border");


    public SelectWorkspaceMenuOptionListener(WorkspaceCanva canva, DriverManager driverManager) {
        this.driverManager = driverManager;
        this.canvas = canva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        driverManager.setCurrentDriver(canvas);
        canvas.getBound().draw(borderDriver);
    }
}
