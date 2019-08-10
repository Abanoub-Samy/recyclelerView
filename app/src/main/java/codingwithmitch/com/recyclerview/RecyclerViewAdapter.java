package codingwithmitch.com.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Integer> arr_id;
    private ArrayList<String> arr_title;
    private ArrayList<String> arr_body;

    private Context mContext;

    RecyclerViewAdapter(Context context, ArrayList<Integer> id, ArrayList<String> title,ArrayList<String> body) {
        arr_id = id;
        arr_title = title;
        arr_body = body ;
        mContext = context;
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView idText;
        TextView titletext;
        LinearLayout parentLayout;

        ViewHolder(View itemView) {
            super(itemView);
            idText = itemView.findViewById(R.id.id);
            titletext = itemView.findViewById(R.id.title);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.idText.setText(arr_id.get(position).toString());
        holder.titletext.setText(arr_title.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + arr_id.get(position));

                Toast.makeText(mContext, arr_id.get(position).toString(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GetBody.class);
                intent.putExtra("body", arr_body.get(position).toString());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr_id.size();
    }



}















