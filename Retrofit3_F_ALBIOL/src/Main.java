import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com/";

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MiAPIService service = retrofit.create(MiAPIService.class);

        Call<ArticuloResponse> call = service.getArticulo(25);

        call.enqueue(new Callback<ArticuloResponse>() {
            @Override
            public void onResponse(Call<ArticuloResponse> call, Response<ArticuloResponse> response) {
                System.out.println("[Code: " + response.code() + "]");
                if(response.isSuccessful()){
                    ArticuloResponse articulo = response.body();
                    System.out.println("Response:\n" + articulo);
                }else{
                    System.out.println("ERROR: " + response.message() );
                }
            }

            @Override
            public void onFailure(Call<ArticuloResponse> call, Throwable throwable) {
                System.out.println("Network Error :: " + throwable.getLocalizedMessage());
            }
        });
    }
}