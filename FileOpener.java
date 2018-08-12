import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class FileOpener {
    private JFileChooser chooser;
    private FileNameExtensionFilter filter;
    private File selectedFile;

    public FileOpener(String fileType) {
        chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        filter = new FileNameExtensionFilter(fileType.toUpperCase() + " Files", fileType);
        chooser.setFileFilter(filter);

    }

    public void findFile() {
        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        } else {
            System.out.println("File not correctly found; please try again.");
            findFile();
        }
    }

    public File getSelectedFile() {
        return selectedFile;
    }
}
