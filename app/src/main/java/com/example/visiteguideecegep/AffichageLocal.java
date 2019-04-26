package com.example.visiteguideecegep;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewFlipper;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class AffichageLocal extends AppCompatActivity {
    FirebaseStorage storage = null;
    StorageReference storageRef = null;
    StorageReference imageRef = null;
    FirebaseAuth mAuth = null;

    ViewFlipper imageFlipper = null;
    Animation animFlipInForeward = null;
    Animation animFlipOutForeward = null;
    Animation animFlipInBackward = null;
    Animation animFlipOutBackward = null;
    GestureDetector gestureDetector = null;

    TextView textViewNomDuLocal = null;
    TextView textViewNumeroDuLocal = null;
    TextView textViewDescriptionDuLocal = null;
    Boolean toucher = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_local);
        imageFlipper = findViewById( R.id.image_flipper );
        animFlipInForeward = AnimationUtils.loadAnimation(this, R.anim.flipin);
        animFlipOutForeward = AnimationUtils.loadAnimation(this, R.anim.flipout);
        animFlipInBackward = AnimationUtils.loadAnimation(this, R.anim.flipin_reverse);
        animFlipOutBackward = AnimationUtils.loadAnimation(this, R.anim.flipout_reverse);
        gestureDetector = new GestureDetector(simpleOnGestureListener);
        textViewNomDuLocal = findViewById(R.id.textViewNomDuLocal);
        textViewNumeroDuLocal = findViewById(R.id.textViewNumeroDuLocal);
        textViewDescriptionDuLocal = findViewById(R.id.textViewDescriptionDuLocal);
        toucher = false;
        SwipeLeft();
        setTouchListener();
        createArrayOfFiles("A-111");
    }

    private void SwipeRight(){
        imageFlipper.setInAnimation(animFlipInBackward);
        imageFlipper.setOutAnimation(animFlipOutBackward);
        imageFlipper.showPrevious();
    }

    private void SwipeLeft(){
        imageFlipper.setInAnimation(animFlipInForeward);
        imageFlipper.setOutAnimation(animFlipOutForeward);
        imageFlipper.showNext();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        super.dispatchTouchEvent(ev);
        if (toucher == true)
        {
            gestureDetector.onTouchEvent(ev);
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                toucher = false;
            }
        }, 2000);
        return true;
    }

    private void setTouchListener()
    {
        imageFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                toucher = true;
                return true;
            }
        });
    }

    private void setScrollListener(final MediaController mediaController)
    {
        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                mediaController.hide();
            }
        });
    }

    SimpleOnGestureListener simpleOnGestureListener
            = new SimpleOnGestureListener(){

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            float sensitvity = 50;
            if((e1.getX() - e2.getX()) > sensitvity){
                SwipeLeft();
            }else if((e2.getX() - e1.getX()) > sensitvity){
                SwipeRight();
            }
            return true;
        }

    };

    private void createArrayOfFiles(final String numeroLocal)
    {
        String aile = "Aile " + String.valueOf(numeroLocal.charAt(0));
        String etage = "Étage " + String.valueOf(numeroLocal.charAt(2));
        CollectionReference colRef = FirebaseFirestore.getInstance().collection("Étages").document(etage).collection("Ailes").document(aile).collection("Locaux");
        colRef.whereEqualTo("Numero", numeroLocal)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                List<String> lesFichiers = (List<String>) document.get("Fichiers");
                                setCloudStorage(numeroLocal);
                                displayImages(numeroLocal, lesFichiers);
                                displayVideos(numeroLocal, lesFichiers);
                                textViewNomDuLocal.setText(document.get("Nom").toString());
                                textViewNumeroDuLocal.setText(document.get("Numero").toString());
                                textViewDescriptionDuLocal.setText(document.get("Description").toString());
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Erreur", LENGTH_LONG).show();
                        }
                    }
                });
        //ProgressBar progressBar = findViewById(R.id.progressBar);
        //progressBar.setVisibility(View.INVISIBLE);
    }

    private void displayVideos(String numeroLocal, List<String> lesFichiers)
    {
        for (int cpt = 0; cpt < lesFichiers.size(); cpt++)
        {
            if (lesFichiers.get(cpt).endsWith("mp4") || lesFichiers.get(cpt).endsWith("mp3"))
            {
                LinearLayout linearLayout = findViewById(R.id.linearLayout);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                VideoView videoView = new VideoView(this);
                final MediaController mediaController = new MediaController(this);

                final float scale = getResources().getDisplayMetrics().density;
                int dpWidthInPx  = (int) (500 * scale);
                int dpHeightInPx = (int) (250 * scale);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpWidthInPx, dpHeightInPx);
                layoutParams.setMargins(0,0,0,8);
                videoView.setLayoutParams(layoutParams);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                setScrollListener(mediaController);

                relativeLayout.addView(videoView);
                linearLayout.addView(relativeLayout);
                downloadVideoOrAudio(numeroLocal, lesFichiers.get(cpt), videoView);
            }
        }
    }

    private void displayImages(String numeroLocal, List<String> lesFichiers)
    {
        for (int cpt = 0; cpt < lesFichiers.size(); cpt++)
        {
            if (lesFichiers.get(cpt).endsWith("jpg") || lesFichiers.get(cpt).endsWith("png"))
            {
                downloadImage(numeroLocal, lesFichiers.get(cpt));
            }
        }
        imageFlipper.setFlipInterval(5000);
        imageFlipper.startFlipping();
    }

    private void setCloudStorage(String numeroLocal)
    {
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        mAuth.signInAnonymously();
        if (user == null) {
            signInAnonymously();
        }
    }

    private void signInAnonymously() {
        mAuth.signInAnonymously().addOnSuccessListener(this, new  OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
            }
        })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(getApplicationContext(), "Auth failure", LENGTH_LONG).show();
                    }
                });
    }

    public void downloadImage(String numeroLocal, String nomDuFichier)
    {
        imageRef = storageRef.child(numeroLocal + "/" + nomDuFichier);
        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                ImageView image = new ImageView ( getApplicationContext() );
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(image);
                imageFlipper.addView(image);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
               Toast.makeText(getApplicationContext(), "Download image error", LENGTH_LONG).show();
            }
        });
    }

    public void downloadVideoOrAudio(String numeroLocal, String nomDuFichier, final VideoView videoView)
    {
        StorageReference videoRef = storageRef.child(numeroLocal + "/" + nomDuFichier);
        videoRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                videoView.setVideoURI(uri);
                videoView.setVisibility(View.VISIBLE);
                videoView.requestFocus();
                videoView.seekTo(1);
                //videoView.start();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Download image error", LENGTH_LONG).show();
            }
        });
    }
}