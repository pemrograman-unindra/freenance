package unindra;

import unindra.core.DB;
import unindra.modules.auth.service.AuthService;
import unindra.modules.auth.ui.Login;
import unindra.modules.auth.ui.Register;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        try {
            DB.init();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                DB.closeConnection();
            }));
            if (AuthService.isUserExists()) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    new Login().setVisible(true);
                });
            } else {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    new Register().setVisible(true);
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menjalankan aplikasi : "+e.getMessage());
        }
    }
}
