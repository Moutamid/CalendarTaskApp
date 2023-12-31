// Generated by view binder compiler. Do not edit!
package com.moutamid.calenderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.moutamid.calenderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BsImageMenuBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnRemoveImage;

  private BsImageMenuBinding(@NonNull MaterialCardView rootView, @NonNull Button btnCancel,
      @NonNull Button btnRemoveImage) {
    this.rootView = rootView;
    this.btnCancel = btnCancel;
    this.btnRemoveImage = btnRemoveImage;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static BsImageMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BsImageMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bs_image_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BsImageMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCancel;
      Button btnCancel = ViewBindings.findChildViewById(rootView, id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btnRemoveImage;
      Button btnRemoveImage = ViewBindings.findChildViewById(rootView, id);
      if (btnRemoveImage == null) {
        break missingId;
      }

      return new BsImageMenuBinding((MaterialCardView) rootView, btnCancel, btnRemoveImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
