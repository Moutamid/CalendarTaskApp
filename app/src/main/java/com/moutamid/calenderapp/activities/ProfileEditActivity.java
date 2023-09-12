package com.moutamid.calenderapp.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fxn.stash.Stash;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.moutamid.calenderapp.MainActivity;
import com.moutamid.calenderapp.R;
import com.moutamid.calenderapp.databinding.ActivityProfileEditBinding;
import com.moutamid.calenderapp.models.UserModel;
import com.moutamid.calenderapp.utilis.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class ProfileEditActivity extends AppCompatActivity {
    ActivityProfileEditBinding binding;
    Uri imageUri;
    Map<String, Object> user = new HashMap<>();
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Constants.initDialog(this);

        binding.toolbar.title.setText("Edit Profile");
        binding.toolbar.back.setOnClickListener(v -> onBackPressed());

        getUserDetails();

        binding.image.setOnClickListener(v -> {

            ImagePicker.Companion.with(this)
                    .cropSquare()
                    .compress(1024)
                    .maxResultSize(1080, 1080)
                    .createIntent(new Function1<Intent, Unit>() {
                        @Override
                        public Unit invoke(Intent intent) {
                            startForProfileImageResult.launch(intent);
                            return null;
                        }
                    });
        });

        binding.update.setOnClickListener(v -> {
            Constants.showDialog();
            if (imageUri != null) {
                updateImage();
            } else {
                updateData(userModel.getImage());
            }
        });

    }

    private void updateImage() {
        String id = UUID.randomUUID().toString();
        Constants.storageReference(Constants.auth().getCurrentUser().getUid()).child("profilePics").child(id).putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    taskSnapshot.getStorage().getDownloadUrl()
                            .addOnSuccessListener(uri -> {
                                updateData(uri.toString());
                            }).addOnFailureListener(e -> {
                                Constants.dismissDialog();
                                Constants.createSnackbar(this, binding.getRoot(), e.getLocalizedMessage());
                            });
                }).addOnFailureListener(e -> {
                    Constants.dismissDialog();
                    Constants.createSnackbar(this, binding.getRoot(), e.getLocalizedMessage());
                });
    }

    private void updateData(String link) {
        userModel.setImage(link);
        userModel.setName(binding.username.getEditText().getText().toString().trim());
        Stash.put(Constants.USERNAME, binding.username.getEditText().getText().toString().trim());
        Stash.put(Constants.USER_IMAGE, link);
        Constants.databaseReference().child(Constants.USER).child(Constants.auth().getCurrentUser().getUid())
                .setValue(userModel).addOnSuccessListener(unused -> {
                    Constants.dismissDialog();
                    Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }).addOnFailureListener(e -> {
                    Constants.dismissDialog();
                    Constants.createSnackbar(this, binding.getRoot(), e.getLocalizedMessage());
                });
    }

    private void getUserDetails() {
        Constants.showDialog();
        Constants.databaseReference().child(Constants.USER).child(Constants.auth().getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        userModel = dataSnapshot.getValue(UserModel.class);
                        Stash.put(Constants.USERNAME, userModel.getName());
                        Stash.put(Constants.USER_IMAGE, userModel.getImage());
                        Stash.put(Constants.EMAIL, userModel.getEmail());
                        binding.username.getEditText().setText(userModel.getName());
                        binding.email.getEditText().setText(userModel.getEmail());
                        Glide.with(ProfileEditActivity.this).load(userModel.getImage()).placeholder(R.drawable.profile_icon).into(binding.profileImage);
                    } else {
                        Constants.createSnackbar(this, binding.getRoot(), "User data not found");
                    }
                    Constants.dismissDialog();
                }).addOnFailureListener(e -> {
                    Constants.dismissDialog();
                    Constants.createSnackbar(this, binding.getRoot(), e.getLocalizedMessage(), "Dismiss");
                });
    }

    private final ActivityResultLauncher<Intent> startForProfileImageResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int resultCode = result.getResultCode();
                    Intent data = result.getData();

                    if (resultCode == Activity.RESULT_OK) {
                        // Image Uri will not be null for RESULT_OK
                        imageUri = data.getData();
                        Glide.with(ProfileEditActivity.this)
                                .load(imageUri)
                                .placeholder(R.drawable.profile_icon)
                                .into(binding.profileImage);
                    } else if (resultCode == ImagePicker.RESULT_ERROR) {
                        Constants.createSnackbar(ProfileEditActivity.this, binding.getRoot(), ImagePicker.getError(data));
                    } else {
                        Constants.createSnackbar(ProfileEditActivity.this, binding.getRoot(), "No Image is selected");
                    }
                }
            }
    );

}