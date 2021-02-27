package com.example.dashboard_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

// Create A Class Adapter
public class Adapter extends ArrayAdapter<Model> implements Filterable {
    private Context context;
    private List<Model> modelList;
    private List<Model> getUserModelListFiltered;


    public Adapter(Context context, List<Model> modelList) {
        super(context, R.layout.testing, modelList);
        this.getUserModelListFiltered = modelList;
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testing, null,true);

        // In this step we connect the XML with Java File
        TextView country = view.findViewById(R.id.state);
        TextView active = view.findViewById(R.id.active);
        TextView Recovered = view.findViewById(R.id.cured);
        TextView deaths = view.findViewById(R.id.death);
        TextView cases = view.findViewById(R.id.total);
        TextView todayCases = view.findViewById(R.id.incactive);
        TextView inccured = view.findViewById(R.id.inccured);
        TextView todayDeaths = view.findViewById(R.id.incdeath);
        TextView flag = view.findViewById(R.id.flag);

        // Adding Data to modellist
        country.setText(modelList.get(position).getCountry());
        active.setText(modelList.get(position).getActive());
        Recovered.setText(modelList.get(position).getRecovered());
        deaths.setText(modelList.get(position).getDeaths());
        cases.setText(modelList.get(position).getCases());
        todayCases.setText(modelList.get(position).getTodayCases());
        inccured.setText(modelList.get(position).getIncRec());
        todayDeaths.setText(modelList.get(position).getTodayDeath());
        flag.setText(modelList.get(position).getFlag());

        return view;
    }

    //search filter command
    @Override
    public int getCount() {
        return modelList.size();
    }


    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence == null | charSequence.length() == 0) {
                    filterResults.count = getUserModelListFiltered.size();
                    filterResults.values = getUserModelListFiltered;
                } else {
                    String searchChr = charSequence.toString().toLowerCase();
                    List<Model> resultData = new ArrayList<>();
                    for (Model Model : getUserModelListFiltered) {
                        if (Model.getCountry().toLowerCase().contains(searchChr)) {
                            resultData.add(Model);
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                modelList = (List<Model>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

}
