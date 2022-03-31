package com.example.modernfurniture;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>{

    private ArrayList<String> textNames = new ArrayList<>();
    private ArrayList<Integer> imagesPath = new ArrayList<>();
    private ArrayList<TextView> textviews = new ArrayList<>();
    private Context context;
    private ArrayList<String> modelNames = new ArrayList<>();
    int row_index;


    public RecyclerviewAdapter(Context context,ArrayList<String> textNames, ArrayList<Integer> imagesPath,ArrayList<String> modelNames) {
        this.textNames = textNames;
        this.imagesPath = imagesPath;
        this.modelNames = modelNames;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(imagesPath.get(position));
        holder.textView.setText(textNames.get(position));
        textviews.add(holder.textView);
        //holder.imageView.setTag(holder);
        holder.imageView.setTag(holder);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewHolder holder2 = (ViewHolder)view.getTag();
                int pos = holder2.getAdapterPosition();

                Log.d("positionmubi",""+pos);
                Common.model = modelNames.get(pos);
                holder2.card_item.setSelected(true);
                for(TextView tv:textviews)
                {
                    tv.setTextColor(context.getColor(R.color.black));//inactive
                }
                holder2.textView.setTextColor(Color.BLUE);

            }


        });

    }

    @Override
    public int getItemCount() {
        return imagesPath.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        CardView card_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.text);
            card_item = itemView.findViewById(R.id.card_item);
        }
    }
}
