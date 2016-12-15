package com.example.chad.memedoppler;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class UserLocation extends AppCompatActivity {

    public static String zip = "01003";
    public String townName = "Amherst";
    public String afterTown = "MA";
    public String stateName = "MA";
    public static String town = "Amherst, MA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_REGIONS)
                .build();
        autocompleteFragment.setFilter(typeFilter);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            public static final String TAG = "UserLocation";

            @Override
            public void onPlaceSelected(Place place) {
                Log.i(TAG, "Place: " + place.getAddress());
                Log.i(TAG, "Place: " + place.getId());
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                List<Address> addresses;
                try {
                    addresses = geocoder.getFromLocation(
                            place.getLatLng().latitude,
                            place.getLatLng().longitude,
                            1);
                    if (addresses.size() > 0) {
                        if (addresses.get(0).getPostalCode() != null) {
                            zip = addresses.get(0).getPostalCode();
                            Log.i(TAG, "ZIP: " + zip);
                        }
                    }
                    StringTokenizer townToken = new StringTokenizer((String) place.getAddress(), ",");
                    townName = townToken.nextToken();
                    if (townToken.hasMoreTokens()) {
                        afterTown = townToken.nextToken();
                        StringTokenizer afterTownToken = new StringTokenizer(afterTown);
                        stateName = afterTownToken.nextToken();
                        town = townName + ", " + stateName;
                    }
                    else {
                        afterTown = "";
                        stateName = "";
                        town = townName;
                    }
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent); // Exit the location pane and return to main activity
                    Toast.makeText(getApplicationContext(), zip, Toast.LENGTH_LONG).show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
    }

    public static String getZip() {
        return zip;
    }

    public static String getTown() {
        return town;
    }

    public void MainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
