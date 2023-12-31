// Generated by view binder compiler. Do not edit!
package com.moutamid.calenderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.moutamid.calenderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CalanderWeekBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView exSevenDateText;

  @NonNull
  public final TextView exSevenDayText;

  @NonNull
  public final View exSevenSelectedView;

  private CalanderWeekBinding(@NonNull FrameLayout rootView, @NonNull TextView exSevenDateText,
      @NonNull TextView exSevenDayText, @NonNull View exSevenSelectedView) {
    this.rootView = rootView;
    this.exSevenDateText = exSevenDateText;
    this.exSevenDayText = exSevenDayText;
    this.exSevenSelectedView = exSevenSelectedView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CalanderWeekBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CalanderWeekBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.calander_week, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CalanderWeekBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.exSevenDateText;
      TextView exSevenDateText = ViewBindings.findChildViewById(rootView, id);
      if (exSevenDateText == null) {
        break missingId;
      }

      id = R.id.exSevenDayText;
      TextView exSevenDayText = ViewBindings.findChildViewById(rootView, id);
      if (exSevenDayText == null) {
        break missingId;
      }

      id = R.id.exSevenSelectedView;
      View exSevenSelectedView = ViewBindings.findChildViewById(rootView, id);
      if (exSevenSelectedView == null) {
        break missingId;
      }

      return new CalanderWeekBinding((FrameLayout) rootView, exSevenDateText, exSevenDayText,
          exSevenSelectedView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
