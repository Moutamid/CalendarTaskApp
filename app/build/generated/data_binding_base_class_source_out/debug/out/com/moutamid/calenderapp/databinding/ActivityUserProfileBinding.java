// Generated by view binder compiler. Do not edit!
package com.moutamid.calenderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.moutamid.calenderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityUserProfileBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView eventCount;

  @NonNull
  public final RecyclerView eventsRC;

  @NonNull
  public final TextView friendCount;

  @NonNull
  public final MaterialButton invite;

  @NonNull
  public final MaterialButton message;

  @NonNull
  public final TextView name;

  @NonNull
  public final LinearLayout noItemLayout;

  @NonNull
  public final ImageView profileIcon;

  @NonNull
  public final MaterialCardView profileImage;

  @NonNull
  public final ToolbarBinding toolbar;

  private ActivityUserProfileBinding(@NonNull RelativeLayout rootView, @NonNull TextView eventCount,
      @NonNull RecyclerView eventsRC, @NonNull TextView friendCount, @NonNull MaterialButton invite,
      @NonNull MaterialButton message, @NonNull TextView name, @NonNull LinearLayout noItemLayout,
      @NonNull ImageView profileIcon, @NonNull MaterialCardView profileImage,
      @NonNull ToolbarBinding toolbar) {
    this.rootView = rootView;
    this.eventCount = eventCount;
    this.eventsRC = eventsRC;
    this.friendCount = friendCount;
    this.invite = invite;
    this.message = message;
    this.name = name;
    this.noItemLayout = noItemLayout;
    this.profileIcon = profileIcon;
    this.profileImage = profileImage;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUserProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUserProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_user_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUserProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.eventCount;
      TextView eventCount = ViewBindings.findChildViewById(rootView, id);
      if (eventCount == null) {
        break missingId;
      }

      id = R.id.eventsRC;
      RecyclerView eventsRC = ViewBindings.findChildViewById(rootView, id);
      if (eventsRC == null) {
        break missingId;
      }

      id = R.id.friendCount;
      TextView friendCount = ViewBindings.findChildViewById(rootView, id);
      if (friendCount == null) {
        break missingId;
      }

      id = R.id.invite;
      MaterialButton invite = ViewBindings.findChildViewById(rootView, id);
      if (invite == null) {
        break missingId;
      }

      id = R.id.message;
      MaterialButton message = ViewBindings.findChildViewById(rootView, id);
      if (message == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.noItemLayout;
      LinearLayout noItemLayout = ViewBindings.findChildViewById(rootView, id);
      if (noItemLayout == null) {
        break missingId;
      }

      id = R.id.profile_icon;
      ImageView profileIcon = ViewBindings.findChildViewById(rootView, id);
      if (profileIcon == null) {
        break missingId;
      }

      id = R.id.profileImage;
      MaterialCardView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.toolbar;
      View toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }
      ToolbarBinding binding_toolbar = ToolbarBinding.bind(toolbar);

      return new ActivityUserProfileBinding((RelativeLayout) rootView, eventCount, eventsRC,
          friendCount, invite, message, name, noItemLayout, profileIcon, profileImage,
          binding_toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
