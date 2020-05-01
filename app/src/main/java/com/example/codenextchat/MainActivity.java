package com.example.codenextchat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView editImage;
    ArrayList<Message> messages = new ArrayList<>();
    ArrayAdapter<Message> messagesAdapter;




    //TODO: Define a DatabaseReference reference to the messages object here
    DatabaseReference databaseMessages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        editImage = findViewById(R.id.edit_image);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseMessages = database.getReference().child("messages");


        ListView listView = findViewById(R.id.list_view);


        //TODO: Create a custom ArrayAdapter for Messages.
        // We'll name the classs MessageAdapter


        /*
        * TODO: Add a listener for when a child message is added to the messages object in the db here
        *
        * When a child message has been added to the db:
        *       1. get the message String from the Snapshot and add it to the ArrayList
        *       2. notify the adapter to update the listview with a new message
        */
        databaseMessages.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //TODO: Add messages to custom ArrayAdapter
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    public void sendMessage(View view) {

        // Get message metadata from our View
        String text = editText.getText().toString();

        //TODO: Get the URL for images stored in your Firebase app
        // Hint: Try attaching the debugger to a breakpoint somewhere in putImageinStorage.
        // If you see a url, copy and paste the value into the searchbar. What do you see?


        //TODO: Push message to Chat App database as a child node
        //TODO: Clear View containing text and photo input.


    }

    /*
     * Creates an Intent that prompts user to select an image.
     *
     * startActivityForResult will trigger the function onActivityResult(int, int, Intent)
     * This code is provided for you.
     */
    public void addImage(View view){

        final int REQUEST_IMAGE = 3;
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    /*
    * Function is triggered by startActivityForResult(Intent, int).
    *
    * Called when an activity you launched exits, giving you the requestCode you started it with,
    * the resultCode it returned, and any additional data from it
    *
    * @param requestCode    The integer request code originally supplied to startActivityForResult()
    * @param resultCode     Integer code corresponding to status of Activity.
    *                       For more info and possible result codes, you can check out this website:
    *                       https://developer.android.com/reference/android/app/Activity#RESULT_OK
    * @param data           An Intent, which can return result data to the caller
    *
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                //Using the Intent, we can access the filepath of an image in our Android device
                final Uri uri = data.getData();

                //TODO: Generate a unique key to access our hosted image on Firebase later.
                // Key must be a string.
                String key = null;

                //TODO: Create an instance of a StorageReference Object to store image into Firebase
                StorageReference storageReference = null;

                //Add Image to Firestore by using a helper function
                putImageInStorage(storageReference, uri, key);

                //TODO: Set ContentDescription of our ImageView in the inputBar
                // Once we've put a message into the database, we can immediately access the
                // image. Our function sendMessage(View) will actually post the data.

            }
        }

    }

    /*  Hosts an image in Firestore. Using an URI, the function creates a URL.
     *  In Firebase Storage API version 16.0.1, the method to retrieve a url using taskSnapshot object
     *  has changed. To Request a URL from a URI we've put into storage, we use:
     *                          task.getResult().getMetadata().getReference().getDownloadUrl()
     * The line of code above will return a Promise which is why we must attach an onCompleteListener.
     * A Promise is an object that may produce a single value some time in the future. In our case,
     * we promise to return a URL at some point when we try to put the file into
     *
     *@param storageReference   A reference to a Google Cloud Storage object
     *@param uri                A reference to a Uniform resource identifier - the location of the image
     *
     *                          You've used a subset of uri's since you can remember...urls!
     *                          URLs help us locate resources on the web. In our case,
     *                          we'll be using resources from our android device. As you'll see in the
     *                          debugger, links to Android resources begin with
     *                           'gs://' instead of 'https://'
     *
     * @param key              String value of the current message's id
     */
    private void putImageInStorage(StorageReference storageReference, Uri uri, final String key) {

        //TODO: Using the StorageReference Object and URI, post our image on Firebase.

            //TODO: Add an onCompleteListener
            // The Listener will respond once a URL is returned from our Promise.

                //TODO: Display loaded image using Glide
                // This should be inside of the onComplete method of our Listener

    }
}
