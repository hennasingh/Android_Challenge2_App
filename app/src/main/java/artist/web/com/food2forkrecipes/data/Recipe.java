package artist.web.com.food2forkrecipes.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("publisher")
    private String mPublisher;

    @SerializedName("f2f_url")
    private String mF2fUrl;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("source_url")
    private String mSourceUrl;

    @SerializedName("recipe_id")
    private String mRecipeId;

    @SerializedName("image_url")
    private String mImageUrl;

    @SerializedName("social_rank")
    private Double mSocialRank;

    @SerializedName("publisher_url")
    private String mPublisherUrl;

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        mPublisher = publisher;
    }

    public String getF2fUrl() {
        return mF2fUrl;
    }

    public void setF2fUrl(String f2fUrl) {
        mF2fUrl = f2fUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSourceUrl() {
        return mSourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        mSourceUrl = sourceUrl;
    }

    public String getRecipeId() {
        return mRecipeId;
    }

    public void setRecipeId(String recipeId) {
        mRecipeId = recipeId;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Double getSocialRank() {
        return mSocialRank;
    }

    public void setSocialRank(Double socialRank) {
        mSocialRank = socialRank;
    }

    public String getPublisherUrl() {
        return mPublisherUrl;
    }

    public void setPublisherUrl(String publisherUrl) {
        mPublisherUrl = publisherUrl;
    }
}

