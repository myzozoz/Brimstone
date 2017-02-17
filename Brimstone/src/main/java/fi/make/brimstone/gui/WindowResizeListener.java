
package fi.make.brimstone.gui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class WindowResizeListener implements ComponentListener{
    private FrameInit f;
    public WindowResizeListener(FrameInit f){
        this.f = f;
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        f.adjustToResize();
    }
    @Override
    public void componentMoved(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
