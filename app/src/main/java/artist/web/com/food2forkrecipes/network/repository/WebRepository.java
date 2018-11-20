package artist.web.com.food2forkrecipes.network.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import artist.web.com.food2forkrecipes.RecipeApplication;
import artist.web.com.food2forkrecipes.data.FoodApiResponse;
import artist.web.com.food2forkrecipes.data.Recipe;
import artist.web.com.food2forkrecipes.helpers.ResultDisplay;
import artist.web.com.food2forkrecipes.helpers.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebRepository {

    private static final String TAG = WebRepository.class.getSimpleName();

    private static volatile WebRepository sWebRepository;

    private MutableLiveData<ResultDisplay<List<Recipe>>> mRecipeListObservable = new MutableLiveData<>();

    private WebRepository(){

    }

    public static WebRepository getInstance(){
        if(sWebRepository==null){
            sWebRepository = new WebRepository();
        }
        return sWebRepository;
    }

    public void getRecipeListResult(){
        mRecipeListObservable.setValue(ResultDisplay.loading(Collections.<Recipe>emptyList()));

        RecipeApplication.sApiManager.getRecipes(Utils.API_KEY, new Callback<FoodApiResponse>() {
            @Override
            public void onResponse(Call<FoodApiResponse> call, Response<FoodApiResponse> response) {
                if(response.isSuccessful()){
                    mRecipeListObservable.setValue(ResultDisplay.success(response.body().getRecipeList()));
                }else{
                    mRecipeListObservable.setValue(ResultDisplay.error(response.message(), Collections.<Recipe>emptyList()));
                }
            }

            @Override
            public void onFailure(Call<FoodApiResponse> call, Throwable t) {

                mRecipeListObservable.setValue(ResultDisplay.error(t.getMessage(),Collections.<Recipe>emptyList()));
                Log.d(TAG, "HTTP request failed");

            }
        });
    }

    public LiveData<ResultDisplay<List<Recipe>>> getRecipeListData(){
        return mRecipeListObservable;
    }
}
