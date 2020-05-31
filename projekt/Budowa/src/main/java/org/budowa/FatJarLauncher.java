package org.budowa;

public class FatJarLauncher {

    // Shade, Assembly, and other plugins mess with the jar structure and ... threads?
    // and i dont fully understand it but we require this little shim
    // https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing

    public static void main(String[] args) throws Exception {
        App.main(args);
    }

}
