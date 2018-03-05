package com.apps.palka.matt.seetg;

/**
 * Created by matt on 28.02.2018.
 */

public class Place {

    /**
     * String resource for the place name
     */
    private int mPlaceNameId;

    /**
     * String resource for the place address
     */
    private int mPlaceAddressId;

    /**
     * String resource for the place phone number
     */
    private int mPlacePhoneNumberId;

    /**
     * Image resource for the place photo
     */
    private int mPlacePhotoId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this place
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * String resource for the place description
     */
    private int mPlaceDescriptionId;

    /**
     * Create a new Place object
     *
     * @param placeNameId        is the resource ID of the place name
     * @param placeAddressId     is the resource ID of  the place address
     * @param placePhoneNumberId is the resource ID of place phone number
     * @param placePhotoId       is the drawable resource ID of places photo
     * @param placeDescriptionId is the resource ID of the place Description
     */
    public Place(int placeNameId, int placeAddressId, int placePhoneNumberId, int placeDescriptionId, int placePhotoId) {
        mPlaceNameId = placeNameId;
        mPlaceAddressId = placeAddressId;
        mPlacePhoneNumberId = placePhoneNumberId;
        mPlacePhotoId = placePhotoId;
        mPlaceDescriptionId = placeDescriptionId;
    }

    public Place(int placeNameId, int placeAddressId, int placePhoneNumberId, int placeDescriptionId) {
        mPlaceNameId = placeNameId;
        mPlaceAddressId = placeAddressId;
        mPlacePhoneNumberId = placePhoneNumberId;
        mPlaceDescriptionId = placeDescriptionId;
    }

    /**
     * get the place name string ID
     */
    public int getPlaceNameId() {
        return mPlaceNameId;
    }

    /**
     * get the place address string ID
     */
    public int getPlaceAddressId() {
        return mPlaceAddressId;
    }

    /**
     * get the place phone number string ID
     */
    public int getPlacePhoneNumberId() {
        return mPlacePhoneNumberId;
    }

    /**
     * get the place photo image drawable resource ID
     */
    public int getPlacePhotoId() {
        return mPlacePhotoId;
    }

    /**
     * Return whether or not there is a Photo for this place
     */
    public boolean hasPhoto() {
        return mPlacePhotoId != NO_IMAGE_PROVIDED;
    }

    /**
     * get place description string ID
     */
    public int getPlaceDescriptionId() {
        return mPlaceDescriptionId;
    }
}
