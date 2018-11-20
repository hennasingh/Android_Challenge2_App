package artist.web.com.food2forkrecipes.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodApiResponse {

    @SerializedName("count")
    private Integer mCount;

    @SerializedName("recipes")
    private List<Recipe> mRecipeList;

    public Integer getCount() {
        return mCount;
    }

    public void setCount(Integer count) {
        mCount = count;
    }

    public List<Recipe> getRecipeList() {
        return mRecipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        mRecipeList = recipeList;
    }
}
