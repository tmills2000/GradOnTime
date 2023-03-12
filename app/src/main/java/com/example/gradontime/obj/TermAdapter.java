package com.example.gradontime.obj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradontime.R;
import com.example.gradontime.ui.TermList;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {
    private List<Term> terms;
    private Context context;
    private LayoutInflater inflater;
    class TermViewHolder extends RecyclerView.ViewHolder {
        private final TextView idView, titleView;
        private TermViewHolder(View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.termId);
            titleView = itemView.findViewById(R.id.termTitle);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                Term currTerm = terms.get(position);
                Intent intent = new Intent(context, TermList.class);
                intent.putExtra("id", currTerm.getTermId());
                intent.putExtra("name",currTerm.getTitle());
                intent.putExtra("startDate", currTerm.getStartDate());
                intent.putExtra("endDate", currTerm.getEndDate());
            });

        }
    }
    public TermAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {
        if (terms != null) {
            Term currTerm = terms.get(position);
            String title = currTerm.getTitle();
            int id = currTerm.getTermId();
            holder.titleView.setText(title);
            holder.idView.setText(String.valueOf(id));
        }
        else {
            holder.titleView.setText("Title not found.");
            holder.idView.setText("Id not found.");
        }
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }
    public void setTerms(List<Term> terms) {
        this.terms = terms;
        notifyDataSetChanged();
    }
}
