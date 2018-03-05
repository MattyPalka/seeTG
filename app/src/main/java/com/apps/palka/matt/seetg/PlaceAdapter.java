package com.apps.palka.matt.seetg;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by matt on 28.02.2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * resource ID for the background color of the list
     */
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param places  A List of places objects to display in a list
     */
    public PlaceAdapter(Activity context, ArrayList<Place> places, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID place_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the Name from the current Place object and
        // set this text on the name TextView
        nameTextView.setText(currentPlace.getPlaceNameId());

        // Find the TextView in the list_item.xml layout with the ID place_address
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.place_address);
        // Get the address from the current Place object and
        // set this text on the number TextView
        addressTextView.setText(currentPlace.getPlaceAddressId());

        // Find the TextView in the list_item.xml layout with the ID place_phone_number
        TextView phoneNumberTextView = (TextView) listItemView.findViewById(R.id.place_phone_number);
        // Get the phone number from the current Place object and
        // set this text on the number TextView
        phoneNumberTextView.setText(currentPlace.getPlacePhoneNumberId());

        // Find the ImageView in the list_item.xml layout with the ID place_photo
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.place_photo);

        if (currentPlace.hasPhoto()) {
            // Get the image resource ID from the current Place object and
            // set the image to iconView
            iconView.setImageResource(currentPlace.getPlacePhotoId());
            /** make sure that the view is visible */
            iconView.setVisibility(View.VISIBLE);
        } else {
            /** Otherwise set iconView (Photo) to GONE (not visible)*/
            iconView.setVisibility(View.GONE);
        }

        //set the theme color for the list view
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color it refers to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //sets the bg color
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
