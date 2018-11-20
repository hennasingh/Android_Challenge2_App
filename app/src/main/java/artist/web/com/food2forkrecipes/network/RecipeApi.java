package artist.web.com.food2forkrecipes.network;

import artist.web.com.food2forkrecipes.data.FoodApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

    @GET("search")
    Call<FoodApiResponse> getRecipeResponse(@Query("key") String apiKey);
}
