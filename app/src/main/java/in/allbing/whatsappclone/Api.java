package in.allbing.whatsappclone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by <Jithin/Jude> on 25,August,2019.
 * jithin.jude68@gmail.com
 */
public interface Api {
    @GET("jkc1v")
    Call<List<ChatModel>> getAllChats();
}
