import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class team42Application {
    public static void main(String[] args) {

        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("./ServiceAccountKey.json");
        }catch(FileNotFoundException e){
            System.out.println("bad service address");
            System.exit(0);
        }

        //sdf

    }
}