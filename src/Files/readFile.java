
package Files;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class readFile {
    
    List <String> content;
    private final String dataBase;
    private final String userDataBase;
    private final String host;
    private final String password;
    
    public readFile() throws IOException{
        //URL url = getClass().getResource("/Files/datosServidor.labsys");
        this.content = (Files.readAllLines(Paths.get("C:/datosServidor.labsys")));
        this.dataBase = content.get(1);
        this.userDataBase = content.get(3);
        this.host = content.get(5);
        this.password = content.get(7);
        System.out.println("CORRECTO: Lectura de archivo de conexión");
    }
    
    public String[] getConnectionData(){
        String[] datosConexion = {
            this.dataBase,
            this.userDataBase,
            this.host,
            this.password,
        };
        return datosConexion;
    }
}
