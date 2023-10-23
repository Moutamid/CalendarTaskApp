// Generated by view binder compiler. Do not edit!
package com.moutamid.calenderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.moutamid.calenderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ButtonsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout bottom;

  @NonNull
  public final MaterialButton uploadImage;

  @NonNull
  public final MaterialButton uploadVideo;

  private ButtonsBinding(@NonNull ConstraintLayout rootView, @NonNull LinearLayout bottom,
      @NonNull MaterialButton uploadImage, @NonNull MaterialButton uploadVideo) {
    this.rootView = rootView;
    this.bottom = bottom;
    this.uploadImage = uploadImage;
    this.uploadVideo = uploadVideo;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ButtonsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ButtonsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.buttons, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ButtonsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom;
      LinearLayout bottom = ViewBindings.findChildViewById(rootView, id);
      if (bottom == null) {
        break missingId;
      }

      id = R.id.uploadImage;
      MaterialButton uploadImage = ViewBindings.findChildViewById(rootView, id);
      if (uploadImage == null) {
        break missingId;
      }

      id = R.id.uploadVideo;
      MaterialButton uploadVideo = ViewBindings.findChildViewById(rootView, id);
      if (uploadVideo == null) {
        break missingId;
      }

      return new ButtonsBinding((ConstraintLayout) rootView, bottom, uploadImage, uploadVideo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}