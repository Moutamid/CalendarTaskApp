package com.moutamid.calenderapp.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.fxn.stash.Stash;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.moutamid.calenderapp.R;
import com.moutamid.calenderapp.SplashScreenActivity;
import com.moutamid.calenderapp.activities.ProfileEditActivity;
import com.moutamid.calenderapp.activities.SelectUserActivity;
import com.moutamid.calenderapp.activities.SettingActivity;
import com.moutamid.calenderapp.activities.UserProfileActivity;
import com.moutamid.calenderapp.adapters.EventAdapter;
import com.moutamid.calenderapp.adapters.EventProfileAdapter;
import com.moutamid.calenderapp.databinding.FragmentProfileBinding;
import com.moutamid.calenderapp.models.TaskModel;
import com.moutamid.calenderapp.models.UserModel;
import com.moutamid.calenderapp.utilis.Constants;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    Context context;
    ArrayList<TaskModel> taskList;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);
        context = binding.getRoot().getContext();

//        setStatusBarColor();


        taskList = new ArrayList<>();

        binding.name.setOnClickListener(v -> startActivity(new Intent(context, ProfileEditActivity.class)));
        binding.profileImage.setOnClickListener(v -> startActivity(new Intent(context, ProfileEditActivity.class)));
        binding.edit.setOnClickListener(v -> startActivity(new Intent(context, SettingActivity.class)));
        binding.newEvent.setOnClickListener(v -> {
            showCreateDialog();
        });


        binding.eventsRC.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.eventsRC.setHasFixedSize(false);


        return binding.getRoot();
    }

    private void showCreateDialog() {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.search_user);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCancelable(true);
        dialog.show();

        MaterialButton create = dialog.findViewById(R.id.create);
        TextInputLayout username = dialog.findViewById(R.id.username);

        create.setOnClickListener(v -> {
            if (username.getEditText().getText().toString().isEmpty()) {
                Toast.makeText(context, getString(R.string.user_name_is_empty), Toast.LENGTH_SHORT).show();
            } else {
                dialog.dismiss();
                Constants.showDialog();
                Constants.databaseReference().child(Constants.USER).get()
                        .addOnSuccessListener(dataSnapshot -> {
                            Constants.dismissDialog();
                            if (dataSnapshot.exists()) {
                                UserModel temp = null;
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    UserModel model = snapshot.getValue(UserModel.class);

                                    if (model.getUsername().equals(username.getEditText().getText().toString().trim()) ||
                                            model.getEmail().equals(username.getEditText().getText().toString().trim())) {
                                        temp = model;
                                        break;
                                    }
                                }

                                if (temp != null) {

                                    if (temp.getID().equals(Constants.auth().getCurrentUser().getUid())) {
                                        Toast.makeText(context, getString(R.string.you_can_t_create_event_with_your_self), Toast.LENGTH_SHORT).show();
                                    } else {
                                        context.startActivity(new Intent(context, UserProfileActivity.class).putExtra("userID", temp.getID()));
                                    }
                                } else {
                                    Toast.makeText(context, getString(R.string.user_not_found), Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .addOnFailureListener(e -> {
                            Constants.dismissDialog();
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            }
        });
    }

    private void getSendRequests() {
        Constants.showDialog();
        Constants.databaseReference().child(Constants.ACTIVE_TASKS).child(Constants.auth().getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            taskList.clear();
                            Stash.clear(Constants.NOTI_SCHEDULE);
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                TaskModel taskModel = dataSnapshot.getValue(TaskModel.class);
                                if (!taskModel.isEnded()) {
                                    taskList.add(taskModel);
                                }
                                if (taskList.size() > 0) {
                                    binding.eventsRC.setVisibility(View.VISIBLE);
                                    binding.noItemLayout.setVisibility(View.GONE);
                                } else {
                                    binding.eventsRC.setVisibility(View.GONE);
                                    binding.noItemLayout.setVisibility(View.VISIBLE);
                                }
                                binding.eventCount.setText("" + taskList.size());
                                Stash.put(Constants.NOTI_SCHEDULE, taskList);
                                EventProfileAdapter adapter = new EventProfileAdapter(context, taskList);
                                binding.eventsRC.setAdapter(adapter);

                            }
                        }
                        Constants.dismissDialog();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Constants.dismissDialog();
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        Constants.initDialog(requireContext());
        getSendRequests();
        UserModel user = (UserModel) Stash.getObject(Constants.STASH_USER, UserModel.class);
        binding.name.setText(user.getUsername());
        Glide.with(context).load(user.getImage()).placeholder(R.drawable.profile_icon).into(binding.profileIcon);
    }
}