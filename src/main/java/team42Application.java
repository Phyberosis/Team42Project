import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class team42Application {
    public static void main(String[] args) {
        System.out.println("sdf");
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("./ServiceAccountKey.json");
        }catch(FileNotFoundException e){
            System.out.println("bad service address");
            System.exit(0);
            return;
        }

        FirebaseOptions options;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
//            options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.getApplicationDefault())
//                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
//                    .build();
        } catch (IOException e) {
            System.out.println("bad options");
            return;
        }

        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();

        team42Application getQuote = new team42Application();
        //HashMap<String, String> quote = getQuote.getQuoteFromHTTP();
        ApiFuture<WriteResult> future = db.collection("users").document("4Mh6jV9qTb4g0WMYAFcZ")
                .set("Tony");
    }

    //public HashMap<String, String> getQuoteFromHTTP(){

    //}
}