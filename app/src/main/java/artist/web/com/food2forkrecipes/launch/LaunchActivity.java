package artist.web.com.food2forkrecipes.launch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import artist.web.com.food2forkrecipes.R;
import artist.web.com.food2forkrecipes.recipelist.RecipeListActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.btn_getFood)
    Button mGoFoodBtn;

    Unbinder mUnbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mUnbinder=ButterKnife.bind(this);
        mGoFoodBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_getFood){
            Intent listIntent = RecipeListActivity.newIntent(this);
            startActivity(listIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
