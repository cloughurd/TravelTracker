package e.durt.traveltracker;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainMapActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new MyMapFragment();
    }
}
