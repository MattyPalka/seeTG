package com.apps.palka.matt.seetg;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrinkFragment extends Fragment {

    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.gryfny, R.string.gryfny_address, R.string.gryfny_phone_number, R.string.lorem_ipsum));
        places.add(new Place(R.string.ministerstwo, R.string.ministerstwo_address, R.string.ministerstwo_phone_number, R.string.lorem_ipsum));

        PlaceAdapter itemsAdapter = new PlaceAdapter(getActivity(), places, R.color.drink_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        /** When clicked on list item display toast with place description*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place = places.get(i);

                Toast.makeText(getActivity(), getString(place.getPlaceDescriptionId()), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}
