package in.allbing.whatsappclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by <Jithin/Jude> on 24,August,2019.
 * jithin.jude68@gmail.com
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    Context context;
    List<ChatModel> chatModelList;

    public ChatAdapter(Context context, List<ChatModel> chatModelList) {
        this.context = context;
        this.chatModelList = chatModelList;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chat_item,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder viewHolder, int position) {
        viewHolder.textViewName.setText(chatModelList.get(position).name);
        viewHolder.textViewMessage.setText(chatModelList.get(position).message);
        viewHolder.textViewTime.setText(chatModelList.get(position).time);

        Glide.with(this.context).load(chatModelList.get(position).imgUrl).into(viewHolder.imageViewProfilePic);
    }

    @Override
    public int getItemCount() {
        return chatModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewMessage;
        TextView textViewTime;
        ImageView imageViewProfilePic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewMessage = itemView.findViewById(R.id.tv_message);
            textViewTime = itemView.findViewById(R.id.tv_time);
            imageViewProfilePic = itemView.findViewById(R.id.profile_image);
        }
    }
}
