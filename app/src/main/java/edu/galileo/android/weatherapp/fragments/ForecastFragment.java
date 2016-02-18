package edu.galileo.android.weatherapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.weatherapp.R;
import edu.galileo.android.weatherapp.activities.WeatherDetailActivity;
import edu.galileo.android.weatherapp.adapter.CustomRecyclerAdapter;
import edu.galileo.android.weatherapp.adapter.OnItemClickListener;
import edu.galileo.android.weatherapp.model.WeatherInfo;


public class ForecastFragment extends Fragment implements OnItemClickListener, ForecastFragmentListener {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private CustomRecyclerAdapter adapter;

    public ForecastFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CustomRecyclerAdapter(getActivity().getApplicationContext());
            adapter.setOnItemClickListener(this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(WeatherInfo element) {

        Intent i = new Intent(getActivity(), WeatherDetailActivity.class);

        i.putExtra(WeatherDetailActivity.MIN_KEY, element.getTempMin());
        i.putExtra(WeatherDetailActivity.MAX_KEY, element.getTempMax());
        i.putExtra(WeatherDetailActivity.ICON_KEY, element.getIconName());
        i.putExtra(WeatherDetailActivity.TEMP_KEY, element.getTemp());
        i.putExtra(WeatherDetailActivity.SUNSET_KEY, element.getSunset());
        i.putExtra(WeatherDetailActivity.SUNRISE_KEY, element.getSunrise());

        startActivity(i);
    }

    @Override
    public void addToList(WeatherInfo info) {
        adapter.addElement(info);
    }
}
