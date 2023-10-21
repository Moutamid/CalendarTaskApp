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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.moutamid.calenderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import noman.weekcalendar.WeekCalendar;

public final class ActivityNewEventBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout addtext;

  @NonNull
  public final MaterialCardView datePicker;

  @NonNull
  public final ImageView eImage;

  @NonNull
  public final MaterialCardView eventImage;

  @NonNull
  public final TextView friendName;

  @NonNull
  public final TextView hour;

  @NonNull
  public final TextInputLayout location;

  @NonNull
  public final TextView minute;

  @NonNull
  public final TextView month;

  @NonNull
  public final TextInputLayout name;

  @NonNull
  public final MaterialCardView next;

  @NonNull
  public final MaterialCardView prev;

  @NonNull
  public final ChipGroup queenSourceChipGroup;

  @NonNull
  public final MaterialButton start;

  @NonNull
  public final ToolbarBinding toolbar;

  @NonNull
  public final WeekCalendar weekCalendar;

  @NonNull
  public final TextView zone;

  private ActivityNewEventBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout addtext,
      @NonNull MaterialCardView datePicker, @NonNull ImageView eImage,
      @NonNull MaterialCardView eventImage, @NonNull TextView friendName, @NonNull TextView hour,
      @NonNull TextInputLayout location, @NonNull TextView minute, @NonNull TextView month,
      @NonNull TextInputLayout name, @NonNull MaterialCardView next, @NonNull MaterialCardView prev,
      @NonNull ChipGroup queenSourceChipGroup, @NonNull MaterialButton start,
      @NonNull ToolbarBinding toolbar, @NonNull WeekCalendar weekCalendar, @NonNull TextView zone) {
    this.rootView = rootView;
    this.addtext = addtext;
    this.datePicker = datePicker;
    this.eImage = eImage;
    this.eventImage = eventImage;
    this.friendName = friendName;
    this.hour = hour;
    this.location = location;
    this.minute = minute;
    this.month = month;
    this.name = name;
    this.next = next;
    this.prev = prev;
    this.queenSourceChipGroup = queenSourceChipGroup;
    this.start = start;
    this.toolbar = toolbar;
    this.weekCalendar = weekCalendar;
    this.zone = zone;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNewEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNewEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_new_event, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNewEventBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addtext;
      LinearLayout addtext = ViewBindings.findChildViewById(rootView, id);
      if (addtext == null) {
        break missingId;
      }

      id = R.id.datePicker;
      MaterialCardView datePicker = ViewBindings.findChildViewById(rootView, id);
      if (datePicker == null) {
        break missingId;
      }

      id = R.id.eImage;
      ImageView eImage = ViewBindings.findChildViewById(rootView, id);
      if (eImage == null) {
        break missingId;
      }

      id = R.id.eventImage;
      MaterialCardView eventImage = ViewBindings.findChildViewById(rootView, id);
      if (eventImage == null) {
        break missingId;
      }

      id = R.id.friendName;
      TextView friendName = ViewBindings.findChildViewById(rootView, id);
      if (friendName == null) {
        break missingId;
      }

      id = R.id.hour;
      TextView hour = ViewBindings.findChildViewById(rootView, id);
      if (hour == null) {
        break missingId;
      }

      id = R.id.location;
      TextInputLayout location = ViewBindings.findChildViewById(rootView, id);
      if (location == null) {
        break missingId;
      }

      id = R.id.minute;
      TextView minute = ViewBindings.findChildViewById(rootView, id);
      if (minute == null) {
        break missingId;
      }

      id = R.id.month;
      TextView month = ViewBindings.findChildViewById(rootView, id);
      if (month == null) {
        break missingId;
      }

      id = R.id.name;
      TextInputLayout name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.next;
      MaterialCardView next = ViewBindings.findChildViewById(rootView, id);
      if (next == null) {
        break missingId;
      }

      id = R.id.prev;
      MaterialCardView prev = ViewBindings.findChildViewById(rootView, id);
      if (prev == null) {
        break missingId;
      }

      id = R.id.queenSourceChipGroup;
      ChipGroup queenSourceChipGroup = ViewBindings.findChildViewById(rootView, id);
      if (queenSourceChipGroup == null) {
        break missingId;
      }

      id = R.id.start;
      MaterialButton start = ViewBindings.findChildViewById(rootView, id);
      if (start == null) {
        break missingId;
      }

      id = R.id.toolbar;
      View toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }
      ToolbarBinding binding_toolbar = ToolbarBinding.bind(toolbar);

      id = R.id.weekCalendar;
      WeekCalendar weekCalendar = ViewBindings.findChildViewById(rootView, id);
      if (weekCalendar == null) {
        break missingId;
      }

      id = R.id.zone;
      TextView zone = ViewBindings.findChildViewById(rootView, id);
      if (zone == null) {
        break missingId;
      }

      return new ActivityNewEventBinding((RelativeLayout) rootView, addtext, datePicker, eImage,
          eventImage, friendName, hour, location, minute, month, name, next, prev,
          queenSourceChipGroup, start, binding_toolbar, weekCalendar, zone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}