package fr.takiu.tpyoutube.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.takiu.tpyoutube.R;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class HistoricItemAdapter extends RecyclerView.Adapter<HistoricItemAdapter.ViewHolder>{

    public List<String> list;

    public HistoricItemAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historic_item, parent, false);
        HistoricItemAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView)itemView.findViewById(R.id.tv_historic_item);
        }

        @Override
        public void onClick(View v) {
            //TODO lancer la recherche
        }
    }
}
