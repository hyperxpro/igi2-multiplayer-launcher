
package launcher;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class Check_Loader {

    public static void check() {
        try {
            File file = new File("IGI-2 Multiplayer Launcher Files\\res\\Launcher.2.Launcher");
            StringBuffer hexString;

            if (file.exists()) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                {
                    FileInputStream fis = new FileInputStream(file);

                    byte[] dataBytes = new byte[1024];

                    int nread = 0;
                    while ((nread = fis.read(dataBytes)) != -1) {
                        md.update(dataBytes, 0, nread);
                    };
                    byte[] mdbytes = md.digest();

                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
                    }

                    hexString = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
                    }
                }

                if (!hexString.toString().equals("f4c3ca2af99a169875b13333da9391320e6b3488377d3cc966afdf4315facf")) {
                    JOptionPane.showMessageDialog(null, "Image Loader Files Are Corrupted. Please Reinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Image Loader Files Not Found. Please Reinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Show Detailed Error.\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 134", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Read Image Loader File.\nMake Sure Launcher Have Enough Rights To Access Image Loader Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Algorithm On Image Loader Files.\nMake Sure Launcher Have Enough Rights To Access Image Loader Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
