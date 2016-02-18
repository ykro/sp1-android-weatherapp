package edu.galileo.android.weatherapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.weatherapp.R;
import edu.galileo.android.weatherapp.model.WeatherInfo;

/**
 * Created by ykro on 11/15/14.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<WeatherInfo> dataset;
    private OnItemClickListener clickListener;

    public CustomRecyclerAdapter(Context context) {
        this.context = context;
        this.dataset = new ArrayList<WeatherInfo>();
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherInfo element = dataset.get(position);

        String strTempMin = context.getString(R.string.main_message_min);
        strTempMin = String.format(strTempMin, element.getTempMin());
        holder.txtTempMin.setText(strTempMin);

        String strTempMax = context.getString(R.string.main_message_max);
        strTempMax = String.format(strTempMax, element.getTempMax());
        holder.txtTempMax.setText(strTempMax);

        holder.txtDescription.setText(element.getDescription());


        if (this.clickListener != null) {
            holder.setOnItemClickListener(element, this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addElement(WeatherInfo element) {
        dataset.add(element);
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTempMin)
        TextView txtTempMin;
        @Bind(R.id.txtTempMax)
        TextView txtTempMax;
        @Bind(R.id.imgIcon)
        ImageView imgIcon;
        @Bind(R.id.txtDescription)
        TextView txtDescription;
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setOnItemClickListener(final WeatherInfo element,
                                           final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(element);
                }
            });

        }
    }
}