import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.ds.ipcam.IpCamDeviceRegistry;
import com.github.sarxos.webcam.ds.ipcam.IpCamDriver;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;

import javax.swing.*;
import java.net.MalformedURLException;

public class Main {

    static {
        Webcam.setDriver(new IpCamDriver());
    }

    public static void main(String[] args) throws MalformedURLException {
        IpCamDeviceRegistry.register("Lignano", "http://rax1.bsn.net/mjpg/video.mjpg", IpCamMode.PUSH);
        JFrame f = new JFrame("Live Views From Lignano Beach");
        f.add(new WebcamPanel(Webcam.getDefault()));
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
