
package org.movsim.viewer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.movsim.input.MovsimCommandLine;
import org.movsim.input.ProjectMetaData;
import org.movsim.logging.Logger;
import org.movsim.viewer.ui.AppFrame;
import org.movsim.viewer.ui.LogWindow;
import org.movsim.viewer.ui.ViewProperties;
import org.movsim.viewer.util.LocalizationStrings;

public class App {

    /**
     * @param args
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws URISyntaxException, IOException {

        Locale.setDefault(Locale.US);

        final ResourceBundle resourceBundle = ResourceBundle.getBundle(LocalizationStrings.class.getName(),
                Locale.getDefault());

        LogWindow.setupLog4JAppender();

        final ProjectMetaData projectMetaData = ProjectMetaData.getInstance();

        Logger.initializeLogger();

        // parse the command line, putting the results into projectMetaData
        MovsimCommandLine.parse(args);

        Properties properties = ViewProperties.loadProperties(projectMetaData);

        AppFrame appFrame = new AppFrame(resourceBundle, projectMetaData, properties);
    }

}
