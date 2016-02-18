package edu.galileo.android.weatherapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.weatherapp.R;
import edu.galileo.android.weatherapp.model.WeatherInfo;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    @Bind(R.id.inputCity) EditText inputCity;

    @Bind(R.id.txtTemp) TextView txtTemp;
    @Bind(R.id.txtTempMin) TextView txtTempMin;
    @Bind(R.id.txtTempMax) TextView txtTempMax;
    @Bind(R.id.txtSunrise) TextView txtSunrise;
    @Bind(R.id.txtSunset) TextView txtSunset;
    @Bind(R.id.txtDescription) TextView txtDescription;
    @Bind(R.id.imgIcon) ImageView imgIcon;

    WeatherInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        info = new WeatherInfo();
        info.setDescription("nubes rotas");
        info.setIconName("04n");
        info.setSunrise("1453465879");
        info.setSunset("1453506955");
        info.setTemp("21");
        info.setTempMin("21");
        info.setTempMax("21");

    }

    @OnClick(R.id.btnSubmit)
    public void handleClick(){
        String strInput = inputCity.getText().toString();
        Log.e(TAG, strInput);

        String strTemp = getString(R.string.main_message_temp);
        strTemp = String.format(strTemp, info.getTemp());
        txtTemp.setText(strTemp);

        String strTempMin = getString(R.string.main_message_min);
        strTempMin = String.format(strTempMin, info.getTempMin());
        txtTempMin.setText(strTempMin);

        String strTempMax = getString(R.string.main_message_max);
        strTempMax = String.format(strTempMax, info.getTempMax());
        txtTempMax.setText(strTempMax);

        txtDescription.setText(info.getDescription());

        String iconName = info.getIconName();
        String iconUrl = "http://openweathermap.org/img/w/" + iconName + ".png";
        Glide.with(this).load(iconUrl).into(imgIcon);

    }
}
