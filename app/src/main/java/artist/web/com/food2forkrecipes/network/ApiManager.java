package artist.web.com.food2forkrecipes.network;

import artist.web.com.food2forkrecipes.data.FoodApiResponse;
import artist.web.com.food2forkrecipes.data.Recipe;
import artist.web.com.food2forkrecipes.helpers.Utils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static RecipeApi sRecipeApi;
    private static ApiManager sApiManager;

    private ApiManager(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sRecipeApi = retrofit.create(RecipeApi.class);
    }

    public static ApiManager getInstance(){
        if(sApiManager==null){
            sApiManager = new ApiManager();
        }
        return sApiManager;
    }

    public void getRecipes(String apiKey, Callback<FoodApiResponse> callback){
        Call<FoodApiResponse> recipeResponse = sRecipeApi.getRecipeResponse(apiKey);
        recipeResponse.enqueue(callback);
    }
}
