package com.alexo.desarrollomovilfase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class APIActivity extends AppCompatActivity {

    private TextView text_result;
    Button getAPIInfo;
    Button refAPIInfo;
    String getURL = "https://jsonplaceholder.typicode.com/posts/1";
    OkHttpClient client;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiactivity);
        text_result = findViewById(R.id.tvAPIInfo);
        client = new OkHttpClient();

        getAPIInfo = findViewById(R.id.btnAPIGet);
        getAPIInfo.setOnClickListener(onClickGetInfo());

        refAPIInfo = findViewById(R.id.btnAPIRefresh);

    }

    private View.OnClickListener onClickGetInfo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = new Request.Builder().url(getURL).build();
                client.newCall(request).enqueue(callbackRequest());
            }

            private Callback callbackRequest() {
                return new Callback() {
                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    text_result.setText(response.body().string());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                text_result.setMovementMethod(new ScrollingMovementMethod());
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        text_result.setText("Hubo un error en la comunicacion");
                    }
                };
            }
        };
    }
}

